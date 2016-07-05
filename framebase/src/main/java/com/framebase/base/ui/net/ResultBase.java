package com.framebase.base.ui.net;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/15.
 */
public class ResultBase implements Serializable {
    // 状态码
    private String code;
    // 消息
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getClientStr() {
        return clientStr;
    }

    public void setClientStr(String clientStr) {
        this.clientStr = clientStr;
    }

    private boolean succ;
    /**
     * 有效期7天
     */
    private String token;
    /**
     * 1 医生2 微信端患者,3 医生助理
     */
    private String type;
    /**
     * 医生id
     */
    private String did;
    /**
     * 客户端上传的id，需要服务器返回
     */
    private String clientStr;
}
