package com.framebase.base.net.source;

import com.framebase.base.net.connect.URLConnectionBase;
import com.framebase.base.utile.JSONUtile;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by Administrator on 2016/1/14.
 */
public class SourceTask<T extends AbstractRequestData<?>> implements Runnable {
    private int responseCode;
    private String responseMsg;
    private OnRequestBack onRequestBack;
    private T requestData;

    public SourceTask(OnRequestBack onRequestBack, T requestData) {
        this.onRequestBack = onRequestBack;
        this.requestData = requestData;
    }

    private byte[] postMethod() {
        try {
            HttpURLConnection urlConn = (HttpURLConnection) URLConnectionBase.getURLConnection(requestData.getUrl());
            // 设置为Post请求
            urlConn.setRequestMethod("POST");
            //设置重定向
            urlConn.setInstanceFollowRedirects(true);
            // 开始连接
            urlConn.connect();
            // 发送请求参数
            DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());
            Object data = requestData.getData();
            String str = JSONUtile.obj2String(data);
            dos.write(str.getBytes());
            dos.flush();
            dos.close();
            // 判断请求是否成功
            responseCode = urlConn.getResponseCode();
            responseMsg = urlConn.getResponseMessage();
            if (responseCode != 200) {
                return null;
            }
            InputStream input = urlConn.getInputStream();
            byte[] result = new byte[1024];
            StringBuffer buffer = new StringBuffer();
            while ((input.read(result)) > 0) {
                buffer.append(new String(result));
            }
            input.close();
            return buffer.toString().getBytes();
        } catch (IOException ioe) {
            responseMsg = ioe.getMessage();
            responseCode = 400;
            return null;
        }
    }

    @Override
    public void run() {
        byte[] result = postMethod();
        if (result == null) {
            onRequestBack.onFailed(responseCode, responseMsg);
            return;
        }
        onRequestBack.onSucess(responseCode, responseMsg, result);
    }

    public interface OnRequestBack {
        /**
         * 成功
         *
         * @param bytes
         */
        void onSucess(int responseCode, String responseMsg, byte[] bytes);

        /**
         * 失败
         */
        void onFailed(int responseCode, String responseMsg);
    }
}
