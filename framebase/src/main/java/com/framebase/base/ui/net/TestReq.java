package com.framebase.base.ui.net;

import com.framebase.base.net.source.AbstractRequestData;

/**
 * Created by Administrator on 2016/1/15.
 */
public class TestReq extends AbstractRequestData<TestRequestBean> {
    public TestRequestBean testBean = new TestRequestBean();

    @Override
    protected String getUrl() {
        return "http://ws.diandianys.com/app";
    }

    @Override
    protected TestRequestBean getData() {
        return testBean;
    }
}
