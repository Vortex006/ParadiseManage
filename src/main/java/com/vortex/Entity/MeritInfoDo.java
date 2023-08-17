package com.vortex.Entity;

public class MeritInfoDo {
    private int meritInfoId;//功德详情ID
    private int meritInfoForUserId;//被操作功德的用户ID
    private int meritInfoRootId;//操作功德的系统用户ID
    private String meritInfoDate;//功德操作时间
    private String meritInfoContent;//具体操作描述

    public MeritInfoDo() {
    }

    public MeritInfoDo(int meritInfoForUserId, int meritInfoRootId, String meritInfoDate, String meritInfoContent) {
        this.meritInfoForUserId = meritInfoForUserId;
        this.meritInfoRootId = meritInfoRootId;
        this.meritInfoDate = meritInfoDate;
        this.meritInfoContent = meritInfoContent;
    }

    public MeritInfoDo(int meritInfoId, int meritInfoForUserId, int meritInfoRootId, String meritInfoDate,
                       String meritInfoContent) {
        this.meritInfoId = meritInfoId;
        this.meritInfoForUserId = meritInfoForUserId;
        this.meritInfoRootId = meritInfoRootId;
        this.meritInfoDate = meritInfoDate;
        this.meritInfoContent = meritInfoContent;
    }

    public int getMeritInfoId() {
        return meritInfoId;
    }

    public void setMeritInfoId(int meritInfoId) {
        this.meritInfoId = meritInfoId;
    }

    public int getMeritInfoForUserId() {
        return meritInfoForUserId;
    }

    public void setMeritInfoForUserId(int meritInfoForUserId) {
        this.meritInfoForUserId = meritInfoForUserId;
    }

    public int getMeritInfoRootId() {
        return meritInfoRootId;
    }

    public void setMeritInfoRootId(int meritInfoRootId) {
        this.meritInfoRootId = meritInfoRootId;
    }

    public String getMeritInfoDate() {
        return meritInfoDate;
    }

    public void setMeritInfoDate(String meritInfoDate) {
        this.meritInfoDate = meritInfoDate;
    }

    public String getMeritInfoContent() {
        return meritInfoContent;
    }

    public void setMeritInfoContent(String meritInfoContent) {
        this.meritInfoContent = meritInfoContent;
    }

    @Override
    public String toString() {
        return "MeritInfo{" +
                "meritInfoId=" + meritInfoId +
                ", meritInfoForUserId=" + meritInfoForUserId +
                ", meritInfoRootId=" + meritInfoRootId +
                ", meritInfoDate='" + meritInfoDate + '\'' +
                ", meritInfoContent='" + meritInfoContent + '\'' +
                '}';
    }
}
