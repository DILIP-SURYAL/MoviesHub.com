package com.proj1.Entities;

import java.sql.Timestamp;

public class Post {

    private int pid;
    private String pTitle;
    private String pContent;
    private String pCode;
    private Timestamp pDate;
    private String pPic;
    private int catId;
    private int userId;

    public Post(int pid, String pTitle, String pContent, String pCode, Timestamp pDate, String pPic, int catId,int userId) {
        this.pid = pid;
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pDate = pDate;
        this.pPic = pPic;
        this.catId = catId;
        this.userId = userId;
    }

    public Post(String pTitle, String pContent, String pCode, Timestamp pDate, String pPic, int catId,int userId) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pDate = pDate;
        this.pPic = pPic;
        this.catId = catId;
        this.userId = userId;
    }
    

    public Post() {
    }

    //for getting the value of the data members..
    public int getPid() {
        return pid;
    }

    public String getpTitle() {
        return pTitle;
    }

    public String getpContent() {
        return pContent;
    }

    public String getpCode() {
        return pCode;
    }

    public Timestamp getpDate() {
        return pDate;
    }

    public String getpPic() {
        return pPic;
    }

    public int getCatId() {
        return catId;
    }

    public int getUserId() {
        return userId;
    }
    

    //for setting the value of the data members..
    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    

}
