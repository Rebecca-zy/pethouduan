package com.example.web1.controller;

import com.example.web1.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LikeController {
    @Autowired
    LikeService likeService;
    @PostMapping("/likecount")
    public Integer likecount(@RequestParam("jlid") String jlid){
        return likeService.getLikeNumByJlid(Integer.parseInt(jlid));
    }
}
