package com.example.web1.serviceImpl;

import com.example.web1.mapper.VideoMapper;
import com.example.web1.pojo.Video;
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
}
