package com.framebase.base.ui.net;

import com.framebase.base.net.able.RequestBack;
import com.framebase.base.net.source.AbstractSourceHandler;

/**
 * Created by Administrator on 2016/1/15.
 */
public class TestManage extends AbstractSourceHandler<TestData> {
    private TestNetSource testNetSource;
    private  DataManagerListener dataManagerListener=new  DataManagerListener();
    public TestManage(RequestBack requestBack) {
        super(requestBack);
        testNetSource=new TestNetSource();
        testNetSource.setRequsetListener(dataManagerListener);
    }
    public void setData(String hosid){
        testNetSource.hosid = hosid;
    }
    public void doRequest(){
        testNetSource.doRequest();;
    }
}
