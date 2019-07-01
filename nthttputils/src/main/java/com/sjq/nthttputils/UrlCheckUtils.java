package com.sjq.nthttputils;

import android.util.Log;

import com.sjq.nthttputils.utils.Constant;

import java.io.IOException;

public class UrlCheckUtils {


    public static String checkUrl(String url, int type) {
        if (type == 1) {
            boolean isexist = startPing("192.168.30.188");
            if (isexist) {
                url = url.replace(Constant.GKIP, "192.168.30.188");
            } else {
                isexist = startPing("10.101.0.90");
                if (isexist) {
                    url = url.replace(Constant.GKIP, "10.101.0.90");
                }
            }
        }
        return url;
    }

    private static boolean  startPing(String ip) {
        boolean isexist = false;
        Process process = null;

        try {
            process = Runtime.getRuntime().exec("ping -c 1 -i 0.5 -W 1 " + ip);
            int status = process.waitFor();
            if (status == 0) {
                isexist = true;
            } else {
                isexist = false;
            }
        } catch (IOException e) {
            isexist = false;
        } catch (InterruptedException e) {
            isexist = false;
        } finally {
            process.destroy();
        }
        Log.i("mmmm", "ping:" + ip + ",isexist:" + isexist);
        return isexist;
    }
}
