package com.framebase.base.ui.net;

import java.util.List;

/**
 * Created by Administrator on 2016/1/15.
 */
public class ObjectListResult<T> extends ResultBase {
    private List<T> list;
    private List<T> uMedList;
    /** 添加日程 返回对象 */
    private List<T> dsList;
    private List<T> docInfoVoList;
    /** 预约号源 */
    private List<T> hyxxList;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getuMedList() {
        return uMedList;
    }

    public void setuMedList(List<T> uMedList) {
        this.uMedList = uMedList;
    }

    public List<T> getDsList() {
        return dsList;
    }

    public void setDsList(List<T> dsList) {
        this.dsList = dsList;
    }

    public List<T> getDocInfoVoList() {
        return docInfoVoList;
    }

    public void setDocInfoVoList(List<T> docInfoVoList) {
        this.docInfoVoList = docInfoVoList;
    }

    public List<T> getHyxxList() {
        return hyxxList;
    }

    public void setHyxxList(List<T> hyxxList) {
        this.hyxxList = hyxxList;
    }
}
