package com.sjq.nthttputils.builder;


import com.sjq.nthttputils.OkHttpUtils;
import com.sjq.nthttputils.request.OtherRequest;
import com.sjq.nthttputils.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
