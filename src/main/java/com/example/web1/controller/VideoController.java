package com.example.web1.controller;

import com.example.web1.pojo.Video;
import com.example.web1.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VideoController {
    @Autowired
    private  VideoService videoService;
    @GetMapping("/getVideoByjlid")
    public Video getvd(@RequestParam("jlid") String jlid){
        int a=Integer.parseInt(jlid);
        return videoService.getVideoByjlid(a);
    }
    
     // 随机获取视频分享id
    //  http://localhost:8000/getrandomvdid
    @GetMapping("")
    public int  getRandomvdid(){
        return videoService.getRandomvdid();
    }
    
    
}
