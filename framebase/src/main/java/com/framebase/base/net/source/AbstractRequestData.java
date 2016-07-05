package com.framebase.base.net.source;

/**
 * Created by Administrator on 2016/1/15.
 */
public abstract class AbstractRequestData<T> {
    protected abstract T getData();

    protected abstract String getUrl();


}
