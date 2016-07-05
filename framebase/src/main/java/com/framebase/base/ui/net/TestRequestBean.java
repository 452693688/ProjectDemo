package com.framebase.base.ui.net;

import com.framebase.base.utile.Md5Util;

/**
 * Created by Administrator on 2016/1/15.
 */
public class TestRequestBean {
    /**
     * 服务商编码
     **/
    private String spid = "9901";
    /**
     * 终端ip
     **/
    private String oper = "127.0.0.1";
    private String channel = "21";
    /**
     * 随机码
     */
    private String random = "1234";
    /**
     * 客户端上传的消息Id,需要服务器原样返回
     */
    private String clientStr;
    /**
     * 校验码 sign = MD5(MD5(PASSWORD) + SPID + RANDOM) PASSWORD=djf8dk
     **/
    private String sign = Md5Util
            .encode((Md5Util.encode("djf8dk") + spid + random));
    public String service = "apphosnewsforumlist";
    /**
     * 医院id，可空
     */
    private String hosid;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHosid() {
        return hosid;
    }

    public void setHosid(String hosid) {
        this.hosid = hosid;
    }

    public String getClientStr() {
        return clientStr;
    }

    public void setClientStr(String clientStr) {
        this.clientStr = clientStr;
    }


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }


}
