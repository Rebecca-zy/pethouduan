package com.example.web1.controller;

import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import com.example.web1.service.LikeService;
import com.example.web1.service.ShareService;
import com.example.web1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class ShareController {
    @Autowired
    ShareService shareService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    LikeService likeService;
    //查数据库
    @PostMapping("/share")
    public Integer share(@RequestParam(value = "yhid") String yhid){
        System.out.println(yhid);
        Integer sharetemp=Integer.parseInt(yhid);
        return shareService.getShareYhId(sharetemp);
    }
     // http://localhost:8000/getShareByjlid?jlid=1   测试
     @GetMapping("/getShareByjlid")
     public Share getjl(@RequestParam("jlid") String jlid){
         int a=Integer.parseInt(jlid);
         return shareService.getShareByJlid(a);
     }

    

     @PostMapping("/sharesearch")
    public Map searchsearch(@RequestBody Map user) {
         Map<String, List> result = new HashMap();
         List<Share> shareinfo=shareService.getShareInfoBySimilarName(String.valueOf(user.get("wz")));
         //List<User> userinfo=userInfoService.getUserInfoBySimilarName(String.valueOf(user.get("wz")));
         result.put("shareinfo",shareinfo);
         //result.put("userinfo",userinfo);

         return result;
     }
    // 首页热榜排名id
    @GetMapping("/gethotshareid")
    public int[] gethotshareid(){
        return shareService.getShareidByStarLike();
    }

    //首页热榜完整内容
    @GetMapping("/gethotshare")
    public List<Share> gethotshare(){
        int a[]=shareService.getShareidByStarLike();
        List<Share> t=new ArrayList<Share>();
        for(int i=0;i<10;i++)
            t.add(shareService.getShareByJlid(a[i]));
        return t;
    }

}
