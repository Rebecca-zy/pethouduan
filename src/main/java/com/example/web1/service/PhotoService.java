package com.example.web1.service;

import java.util.List;

import com.example.web1.pojo.Photo;
import com.example.web1.pojo.userPhotolist;

import org.apache.ibatis.annotations.Param;

public interface PhotoService {

    public List<Photo> getPhotoByjlid(int jlid);
    public List<Photo> getPhotoByYhid(Integer yhid);
    public int[] getjlidByPhoto(Integer yhid);
    public int[] getRandomptid();
    public String[] getPetPicList(Integer cwid);
    public String[] getPhotoFbsj(Integer yhid);
    public List<userPhotolist> getUserPhotolistByYhid(Integer yhid,Integer cwid);
    public String[] getPhotocwidFbsj(Integer yhid,Integer cwid);
    
}
