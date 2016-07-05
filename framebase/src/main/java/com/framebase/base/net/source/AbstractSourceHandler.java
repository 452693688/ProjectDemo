package com.framebase.base.net.source;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.framebase.base.net.able.RequestBack;
import com.framebase.base.net.able.RequsetListener;

import java.lang.ref.SoftReference;

/**
 * Created by Administrator on 2016/1/15.
 */
public abstract class AbstractSourceHandler<T> extends Handler {
    SoftReference<RequestBack> requestBacks = null;

    public AbstractSourceHandler(RequestBack requestBack) {
        requestBacks = new SoftReference<RequestBack>(requestBack);
    }

    private RequestBack getRequestBack() {
        if (requestBacks == null) {
            return null;
        }
        RequestBack requestBack = requestBacks.get();
        return requestBack;
    }

    @Override
    public void handleMessage(Message message) {
        RequestBack requestBack = getRequestBack();
        if (requestBack == null) {
            return;
        }
        Bundle bundle = message.getData();
        String msg = bundle.getString("msg");
        requestBack.OnBack(message.what, message.obj, msg);
    }

    private Message getMessage(int what, T t, String msg) {
        Message message = this.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        message.what = what;
        message.obj = t;
        message.setData(bundle);
        return message;
    }

    public class DataManagerListener implements RequsetListener<T> {
        @Override
        public void RequsetDetails(int resultCode, int responseCode, T t, String msg) {
            int code = responseCode;
            if (responseCode == WHAT_NET_REQUEST_SUCCESS) {
                code = resultCode;
            }
            Message message = null;
            switch (code) {
                case WHAT_DEAL_SUCCESS:
                    message = onDealSucces(code, t, msg);
                    break;
                case WHAT_DEAL_FAILED:
                    message = onDealFailed(code, t, msg);
                    break;
                default:
                    message = getMessage(code, t, msg);
                    break;
            }
            sendMessage(message);
            //sendMessageDelayed(message,100);
        }

        public Message onDealSucces(int what, T t, String msg) {
            return getMessage(what, t, msg);
        }

        public Message onDealFailed(int what, T t, String msg) {
            return getMessage(what, t, msg);
        }
    }

    /**
     * 访问网络成功
     */
    public static final int WHAT_NET_REQUEST_SUCCESS = 200;

    /**
     * 业务处理成功
     */
    public static final int WHAT_DEAL_SUCCESS = 300;
    /**
     * 业务操作失败
     */
    public static final int WHAT_DEAL_FAILED = 301;
    /**
     * json转换类失败
     */
    public static final int WHAT_DATA_ERROR = 302;
    /**
     * token失效或不能为空
     */
    public static final int WHAT_DATA_TOKEN_ERROR = 306;

    /**
     * 网络错误
     */
    public static final int WHAT_LOCALITY_NET_WORK_ERROR = 101;


}
