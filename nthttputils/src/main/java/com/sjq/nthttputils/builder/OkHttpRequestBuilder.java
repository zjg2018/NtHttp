package com.sjq.nthttputils.builder;


import android.util.Log;
import android.widget.Toast;

import com.sjq.nthttputils.UrlCheckUtils;
import com.sjq.nthttputils.request.RequestCall;
import com.sjq.nthttputils.utils.Constant;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder>
{
    protected String url;
    protected String nwIp;
    protected String zwIp;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected int id;
    public T id(int id)
    {
        this.id = id;
        return (T) this;
    }

    public T url(String url)
    {
        url= UrlCheckUtils.checkUrl( url,nwIp,zwIp,1);
        this.url = url;
        return (T) this;
    }

    public T nwIp(String nwIp)
    {
        this.nwIp = nwIp;
        return (T) this;
    }
    public T zwIp(String zwIp)
    {
        this.zwIp = zwIp;
        return (T) this;
    }



    public T tag(Object tag)
    {
        this.tag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers)
    {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val)
    {
        if (this.headers == null)
        {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public abstract RequestCall build();

}
