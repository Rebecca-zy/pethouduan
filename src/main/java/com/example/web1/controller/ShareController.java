package com.example.web1.controller;

import com.example.web1.pojo.Share;
import com.example.web1.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class ShareController {
    @Autowired
    ShareService shareService;
    //查数据库
    @PostMapping("/share")
    public Integer share(@RequestParam(value = "yhid") String yhid){
        System.out.println(yhid);
        Map result=new HashMap();
        Integer sharetemp=Integer.parseInt(yhid);
        return shareService.getShareYhId(sharetemp);
    }

}
