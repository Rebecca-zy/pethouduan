package com.example.web1.controller;

import java.util.List;

import com.example.web1.pojo.Photo;
import com.example.web1.service.PhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    
}