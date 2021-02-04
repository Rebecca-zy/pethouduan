package com.example.web1.controller;

import java.util.List;

import com.example.web1.pojo.Photo;
import com.example.web1.pojo.userPhotolist;
import com.example.web1.service.PhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
public class PhotoController {

    // http://localhost:8000/getPhotoByjlid?jlid=1   测试
    @Autowired
    private PhotoService photoservice;
    @GetMapping("/getPhotoByjlid")
    public List<Photo> getzp(@RequestParam("jlid") String jlid){
        int a=Integer.parseInt(jlid);
        return photoservice.getPhotoByjlid(a);
    }

    @GetMapping("/ishavephoto")
    public String ishavePhoto(@RequestParam("jlid") String jlid){
        int a=Integer.parseInt(jlid);
        if(photoservice.getPhotoByjlid(a).toString()=="[]") {
            return photoservice.getPhotoByjlid(a).toString();
        }
        else{
            return "you";
        }
       
    }

    // 获取随机照片记录值三个
    // http://localhost:8000/getRandomptid
    @GetMapping("/getRandomptid")
    public int[]  getRandptid(){
       return photoservice.getRandomptid();
    }

    // 获取宠物照片
    @PostMapping("/getpetpic")
    public String[] getPetPicList(@RequestParam("cwid") int cwid){
        return photoservice.getPetPicList(cwid);
    }

    // 获取他人主页按时间的照片
    @PostMapping("/getuserfbsjpic")
    public List<userPhotolist> getUserFbsjPic(@RequestParam("yhid") int yhid){
        return photoservice.getUserPhotolistByYhid(yhid);
    }
    
}