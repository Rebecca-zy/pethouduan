package com.example.web1.pojo;

public class messageinfo {
    private int userid;
    private String username;
    private String userurl;
    private int messagenum;
    private String datatime;    
    private String passage;
    private int lovenumber;
    private int starnumber;
    private String islove;
    private String isstar;
    private String[] photourl;
    private String vdurl;
    private String isphoto;
    private int cwid;
    private int fqh;

    public int getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(int messagenum) {
        this.messagenum = messagenum;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    public int getLovenumber() {
        return lovenumber;
    }

    public void setLovenumber(int lovenumber) {
        this.lovenumber = lovenumber;
    }

    public int getStarnumber() {
        return starnumber;
    }

    public void setStarnumber(int starnumber) {
        this.starnumber = starnumber;
    }

    public String getIslove() {
        return islove;
    }

    public void setIslove(String islove) {
        this.islove = islove;
    }

    public String getIsstar() {
        return isstar;
    }

    public void setIsstar(String isstar) {
        this.isstar = isstar;
    }

    public String[] getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String[] photourl) {
        this.photourl = photourl;
    }

    public String getIsphoto() {
        return isphoto;
    }

    public void setIsphoto(String isphoto) {
        this.isphoto = isphoto;
    }

    public String getVdurl() {
        return vdurl;
    }

    public void setVdurl(String vdurl) {
        this.vdurl = vdurl;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserurl() {
        return userurl;
    }

    public void setUserurl(String userurl) {
        this.userurl = userurl;
    }

    public int getCwid() {
        return cwid;
    }

    public void setCwid(int cwid) {
        this.cwid = cwid;
    }

    public int getFqh() {
        return fqh;
    }

    public void setFqh(int fqh) {
        this.fqh = fqh;
    }
}
