package com.sjq.nthttp;


import com.sjq.nthttputils.OkHttpUtils;
import com.sjq.nthttputils.builder.PostFormBuilder;
import com.sjq.nthttputils.callback.StringCallback;
import java.io.File;
import java.util.HashMap;

public class HttpUtils {


    private static WeakHandler handler = new WeakHandler();

    //参数：
    public static void getData(String url, HashMap params, final CallBack callBack) {
        PostFormBuilder postFormBuilder = OkHttpUtils.post();

        if (params != null) {
            for (Object key : params.keySet()) {
                if (params.get(key) != null) {
                    if (params.get(key) instanceof File) {
                        File file = (File) params.get(key);
                        postFormBuilder.addFile(key + "", file.getName(), file);
                    } else {
                        postFormBuilder.addParams(key + "", params.get(key).toString());
                    }
                }
            }
        }

        postFormBuilder
                .url(Constants.BaseUrl + url)
                .build()
                .readTimeOut(30000L)
                .writeTimeOut(30000L)
                .connTimeOut(30000L)
                .execute(new StringCallback() {

                    @Override
                    public void onError(okhttp3.Call call, final Exception e, int id) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onFailed(e);
                            }
                        });
                    }

                    @Override
                    public void onResponse(final String response, int id) {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onSuccess(response);
                            }
                        });

                    }
                });
    }
}
