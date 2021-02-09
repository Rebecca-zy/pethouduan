package com.example.web1.service;

import java.util.List;

import com.example.web1.pojo.Video;
import com.example.web1.pojo.userPhotolist;


public interface VideoService {
    Video getVideoByjlid(int jlid);
    int getRandomvdid();
    String[] getVideoFbsj(Integer yhid);
    String[] getVideocwidFbsj(Integer yhid,Integer cwid);
    List<userPhotolist> getUserVideolistByYhid(Integer yhid,Integer cwid);
}
