package com.example.web1.controller;
import com.example.web1.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StarController {
    @Autowired
    StarService starService;
    @PostMapping("starcount")
    public Integer getLikeNum(@RequestParam("jlid") String jlid){
        return starService.getStarNumByJlid(Integer.parseInt(jlid));
    }

}
