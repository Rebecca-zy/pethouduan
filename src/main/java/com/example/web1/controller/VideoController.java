package com.example.web1.controller;

import java.util.List;

import com.example.web1.pojo.Video;
import com.example.web1.pojo.userPhotolist;
import com.example.web1.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/getrandomvdid")
    public int  getRandomvdid(){
        int e=videoService.getRandomvdid();
        System.out.println(e);
        return e;
    }

    // 获取他人主页按时间的视频
    @PostMapping("/getuserfbsjvid")
    public List<userPhotolist> getUserFbsjVid(@RequestParam("yhid") int yhid,@RequestParam("cwid") int cwid){
        return videoService.getUserVideolistByYhid(yhid,cwid);
    }
    
    
}
