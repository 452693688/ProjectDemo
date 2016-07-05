package com.framebase.base.ui.net;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/15.
 */
public class TestResultBean implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 版块id */
    private Integer forumId;
    /** 版块名称 */
    private String forumName;
    /** 版块描述 */
    private String forumDesc;
    /** 医院id（共有版本医院id为空） */
    private String hosId;
    /** 咨询数 */
    private Integer newsCount;
    public Integer getForumId() {
        return forumId;
    }
    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }
    public String getForumName() {
        return forumName;
    }
    public void setForumName(String forumName) {
        this.forumName = forumName;
    }
    public String getForumDesc() {
        return forumDesc;
    }
    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }
    public String getHosId() {
        return hosId;
    }
    public void setHosId(String hosId) {
        this.hosId = hosId;
    }
    public Integer getNewsCount() {
        return newsCount;
    }
    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
