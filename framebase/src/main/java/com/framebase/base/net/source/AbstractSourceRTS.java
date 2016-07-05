package com.framebase.base.net.source;

import com.framebase.base.net.able.RequsetListener;
import com.framebase.base.net.threads.TaskManager;
import com.framebase.base.ui.receive.NetStateReceiver;

/**
 * Created by Administrator on 2016/1/14.
 */
public abstract class AbstractSourceRTS<T extends AbstractResponseData, V extends AbstractRequestData> {
    private RequestState requestState = new RequestState();
    private RequsetListener requsetListener;

    /**
     * 获取请求参数
     */
    protected abstract V getRequest();

    /**
     * 转化Resp
     */
    protected abstract T parseResp(byte[] bytes);

    public void setRequsetListener(RequsetListener requsetListener) {
        this.requsetListener = requsetListener;
    }

    public void doRequest() {
        if (NetStateReceiver.getNetWorkState() == 0) {
            requestState.onFailed(AbstractSourceHandler.WHAT_LOCALITY_NET_WORK_ERROR, "网络初始化失败");
            return;
        }
        if (NetStateReceiver.getNetWorkState() == NetStateReceiver.NET_STATE_NONET) {
            requestState.onFailed(AbstractSourceHandler.WHAT_LOCALITY_NET_WORK_ERROR, "没有网络");
            return;
        }
        SourceTask sourceTask = new SourceTask(requestState, getRequest());
        TaskManager.getInstance().execute(sourceTask);
    }

    class RequestState implements SourceTask.OnRequestBack {

        @Override
        public void onSucess(int responseCode, String responseMsg, byte[] bytes) {
            T t = parseResp(bytes);
            if (t == null) {
                //数据错误
                responseMsg = "json转换类失败";
                requsetListener.RequsetDetails(AbstractSourceHandler.WHAT_DATA_ERROR, responseCode, null, responseMsg);
                return;
            }
            responseMsg = t.msg;
            String code = t.code;
            if ("0".equals(code)) {
                //业务请求成功
                requsetListener.RequsetDetails(AbstractSourceHandler.WHAT_DEAL_SUCCESS, responseCode, t, responseMsg);
                return;
            }
            if (("00000010").equals(code)
                    || ("00000009").equals(code)) {
                requsetListener.RequsetDetails(AbstractSourceHandler.WHAT_DATA_TOKEN_ERROR, responseCode, t, responseMsg);
                return;
            }
            //业务请求 其他原因失败
            requsetListener.RequsetDetails(AbstractSourceHandler.WHAT_DEAL_FAILED, responseCode, t, responseMsg);
        }

        @Override
        public void onFailed(int responseCode, String responseMsg) {
            requsetListener.RequsetDetails(0, responseCode, null, responseMsg);
        }

        public void onFailed(int responseCode, Object obj, String responseMsg) {
            requsetListener.RequsetDetails(0, responseCode, obj, responseMsg);
        }
    }
}
