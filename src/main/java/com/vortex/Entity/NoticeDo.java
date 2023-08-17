package com.vortex.Entity;

public class NoticeDo {
    private int noticeId;//公告ID
    private String noticeTitle;//公告标题
    private String noticeContent;//公告内容
    private String noticeCreateDate;//公告创建日期
    private char noticeState;//公告状态

    public NoticeDo() {
    }

    public NoticeDo(String noticeTitle, String noticeContent, String noticeCreateDate, char noticeState) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateDate = noticeCreateDate;
        this.noticeState = noticeState;
    }

    public NoticeDo(int noticeId, String noticeTitle, String noticeContent, String noticeCreateDate, char noticeState) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateDate = noticeCreateDate;
        this.noticeState = noticeState;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeCreateDate() {
        return noticeCreateDate;
    }

    public void setNoticeCreateDate(String noticeCreateDate) {
        this.noticeCreateDate = noticeCreateDate;
    }

    public char getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(char noticeState) {
        this.noticeState = noticeState;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeCreateDate='" + noticeCreateDate + '\'' +
                ", noticeState=" + noticeState +
                '}';
    }
}
