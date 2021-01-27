package com.example.web1.controller;
import static org.mockito.Answers.valueOf;

import com.example.web1.pojo.Share;
import com.example.web1.service.Shareservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 跨域
// @ResponseBody和@Controller的组合注解  @Controller 处理http请求
@CrossOrigin
@RestController
public class ShareController {
    
    // 自动装载
    // http://localhost:8050/getShareByjlid?jlid=1   测试
    @Autowired
    private Shareservice shareservice;
    @GetMapping("/getShareByjlid")
    public Share getjl(@RequestParam("jlid") String jlid){
        int a=Integer.parseInt(jlid);
        return shareservice.getShareByJlid(a);
    }
    
}
