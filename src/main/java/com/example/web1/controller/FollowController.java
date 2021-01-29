package com.example.web1.controller;


import com.example.web1.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class FollowController {
    @Autowired
    FollowService followService;
    @PostMapping("/follow")
    public Integer follow(@RequestParam(value = "zyhid") String zyhid) {
        System.out.println(zyhid);
        Integer sharetemp=Integer.parseInt(zyhid);
        return followService.getFollowZyhId(sharetemp);
    }
}
