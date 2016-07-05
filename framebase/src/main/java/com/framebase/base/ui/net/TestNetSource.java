package com.framebase.base.ui.net;

import com.framebase.base.net.source.AbstractSourceRTS;
import com.framebase.base.utile.JSONUtile;

/**
 * Created by Administrator on 2016/1/15.
 */
public class TestNetSource extends AbstractSourceRTS<TestData, TestReq> {
    public String hosid;
    @Override
    protected TestReq getRequest() {
        TestReq testReq=  new TestReq();
        testReq.testBean.setHosid(hosid);
        return testReq;
    }

    @Override
    protected TestData parseResp(byte[] bytes) {
        String json = new String(bytes);
        @SuppressWarnings("unchecked")
        ObjectListResult<TestResultBean> result = (ObjectListResult<TestResultBean>) JSONUtile
                .json2Obj(json, ObjectListResult.class, TestResultBean.class);
        if (result == null) {
            return null;
        }
        TestData  testData=new TestData();
        testData.code = result.getCode();
        testData.msg = result.getMsg();
        testData.list = result.getList();
        return testData;
    }
}
