package com.example.web1.controller;

import com.example.web1.pojo.Share;
import com.example.web1.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class ShareController {
    @Autowired
    ShareService shareService;
    //查数据库
    @PostMapping("/share")
    public Map<String, Object> share(@RequestBody Map shareinfo){
        Map result=new HashMap();
        Integer sharetemp=shareService.getShareYhId((Integer) shareinfo.get("yhid"));
        if(sharetemp==null){
            result.put("message","记录不存在");
            return result;
        }else {
            result.put("num",sharetemp);
            return result;
        }
    }

}
