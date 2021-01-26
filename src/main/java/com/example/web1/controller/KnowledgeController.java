package com.example.web1.controller;


import com.example.web1.CheckToken;
import com.example.web1.pojo.Knowledge;
import com.example.web1.pojo.User;
import com.example.web1.service.KnowledgeService;
import com.example.web1.service.TokenService;
import com.example.web1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class KnowledgeController {
    @Autowired
    KnowledgeService knowledgeService;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserInfoService userService;
    @Value("${EXPIRE_TIME}")
    private String EXPIRE_TIME;
    @CheckToken
    @GetMapping("/getUserByName/{userName}")
    public String getUser(@PathVariable("userName") String userName) {
        User userInfoByName = userService.getUserInfoByName(userName);
        return userInfoByName.toString();
    }

    //查数据库
    @CheckToken
    @PostMapping("/knowledge")
    public Map<String, Object> knowledge(@RequestBody Map knowledgeinfo){
        Map result=new HashMap();
        Knowledge knowledgetemp=knowledgeService.getKnowledgePz(String.valueOf(knowledgeinfo.get("pz")));
        if(knowledgetemp==null){
            result.put("message","记录不存在");
            return result;
        }else {
            String pz=knowledgetemp.getPz();
            String bm=knowledgetemp.getJj();
            String xgtz=knowledgetemp.getXgtz();
            String jj=knowledgetemp.getJj();
            result.put("pz",pz);
            result.put("bm",bm);
            result.put("xgtz",xgtz);
            result.put("jj",jj);
            return result;
        }
    }

}
