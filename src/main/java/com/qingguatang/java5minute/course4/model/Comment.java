package com.qingguatang.java5minute.course4.model;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;
public class Comment {


    private String id;


    private String icon;
    private String nickName;
    private String content;
    private Date commentTime;
    private int likeNum;
    public String getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public Date setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
        return commentTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
