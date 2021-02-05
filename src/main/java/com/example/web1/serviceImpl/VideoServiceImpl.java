package com.example.web1.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.web1.mapper.VideoMapper;
import com.example.web1.pojo.Video;
import com.example.web1.pojo.userPhotolist;
import com.example.web1.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public Video getVideoByjlid(int jlid){
        return  videoMapper.getVideoByjlid(jlid);
    }
    @Override
    public int getRandomvdid(){
        return videoMapper.getRandomvdid();
    }

    @Override 
    public String[] getVideoFbsj(Integer yhid){
        return videoMapper.getVideoFbsj(yhid);
    }

    @Override
    public List<userPhotolist> getUserVideolistByYhid(Integer yhid){
        List<userPhotolist> temp=new ArrayList<userPhotolist>();
        String s[]=getVideoFbsj(yhid);
        for(int i=0;i<s.length;i++){
            userPhotolist t=new userPhotolist();
            t.setFbsj(s[i]);
            t.setPhotolist(videoMapper.getUserVideolistByYhid(yhid,s[i]));
            temp.add(t);
        }
        return temp;
    }
}
