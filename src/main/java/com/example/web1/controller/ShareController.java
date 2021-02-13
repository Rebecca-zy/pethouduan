package com.example.web1.controller;

import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import com.example.web1.pojo.messageinfo;
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

    @PostMapping("/addshare")
    public Integer addshare(@RequestParam(value = "yhid") int yhid,@RequestParam(value = "cwid") int cwid,@RequestParam(value = "yhm") String yhm,@RequestParam(value = "wz") String wz,@RequestParam(value = "fbsj") String fbsj,@RequestParam(value = "fqh") int fqh){    
        return shareService.addShare(yhid,cwid, yhm, fbsj, wz, fqh);
    }
    //查数据库
    @PostMapping("/share")
    public Integer share(@RequestParam(value = "yhid") String yhid){
        // System.out.println(yhid);
        Integer sharetemp=Integer.parseInt(yhid);
        return shareService.getShareYhId(sharetemp);
    }
     // http://localhost:8000/getShareByjlid?jlid=1   测试
     @GetMapping("/getShareByjlid")
     public Share getjl(@RequestParam("jlid") String jlid){
         int a=Integer.parseInt(jlid);
         return shareService.getShareByJlid(a);
     }

    @PostMapping("/getSection")
    public Map getSection(@RequestBody Map info){
        System.out.println(info);
        Map result=new HashMap();
        int a=parseInt(String.valueOf(info.get("jlid")));
        result.put("Section",shareService.getShareByJlid(a).getFqh());
        return result;
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

     //指定分区搜索记录
     @PostMapping("/targetsearch")
     public Map targetSearch(@RequestBody Map user) {
         Map<String, List> result = new HashMap();
         List<Share> shareinfo=shareService.getShareInfoBySection(String.valueOf(user.get("wz")),String.valueOf(user.get("fqh")));
         result.put("shareinfo",shareinfo);
         return result;
     }

    //指定分区搜索记录
    @PostMapping("/animalsearch")
    public Map animalSearch(@RequestBody Map user) {
        Map<String, List> result = new HashMap();
        List<Share> shareinfo=shareService.getShareInfoByKind(String.valueOf(user.get("wz")),String.valueOf(user.get("zl")));
        result.put("shareinfo",shareinfo);
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
        for(int i=0;i<10;i++) {
            t.add(shareService.getShareByJlid(a[i]));
        }
        return t;
    }

    @PostMapping("/usersharebyyhid")
    public List<messageinfo> userShareByYhid(@RequestParam(value = "yhid") int yhid,@RequestParam(value = "zyhid") int zyhid,@RequestParam(value = "cwid") int cwid){
        return shareService.userShareByYhid(yhid, zyhid,cwid);
    }
   
// 用户主页收藏页面/动态的分享记录
    @PostMapping("/userstarsharebyyhid")
    public List<messageinfo> userfollstarShareByYhid(@RequestParam(value = "yhid") int yhid,@RequestParam(value = "fqh") int fqh,@RequestParam(value = "follorstar") int follorstar){
        return shareService. userfollstarShareByyhid(yhid, fqh, follorstar);
    }
}
