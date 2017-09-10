package com.comslin.ezhome.oriUi.http.bean.user;

public class Notification {
    private boolean read;
    private String createTime;
    private NotificationExtra extra;
    private int id;
    private String title;
    private String content;
    private String opinion;

    public boolean getRead() {
        return this.read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public NotificationExtra getExtra() {
        return this.extra;
    }

    public void setExtra(NotificationExtra extra) {
        this.extra = extra;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
