package com.example.web1.controller;


import com.example.web1.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class FollowController {
    @Autowired
    FollowService followService;
    @PostMapping("/follow")
    public Integer follow(@RequestParam(value = "zyhid") String zyhid) {
        // System.out.println(zyhid);
        Integer sharetemp=Integer.parseInt(zyhid);
        return followService.getFollowZyhId(sharetemp);
    }
    @PostMapping("/fsfollow")
    public Integer fsfollow(@RequestParam(value = "fsid") String fsid) {
        // System.out.println(fsid);
        Integer sharetemp=Integer.parseInt(fsid);
        return followService.getFollowFsId(sharetemp);
    }
    @GetMapping("/isfollow")
    public String isFollow(@RequestParam(value = "zyhid") String zyhid,@RequestParam(value = "fsid") String fsid){
        // System.out.println("cha");
        // System.out.println(zyhid);
        Integer zyhtemp=Integer.parseInt(zyhid);
        // System.out.println(fsid);
        Integer fstemp=Integer.parseInt(fsid);
        try {
            if(followService.getIsFollow(zyhtemp,fstemp).getQxgz()==0){
                return "0";//已关注
            }
            else{
                return "1";//关注过取消了
            }
        } catch (Exception e) {
            return "wu";//从未关注过
        }
    }

    @GetMapping("/addfollow")
    public String addFollow(@RequestParam(value = "zyhid") String zyhid,@RequestParam(value = "fsid") String fsid,@RequestParam(value = "qxgz") String qxgz){
        // System.out.println("add");
        // System.out.println(zyhid);
        Integer zyhtemp=Integer.parseInt(zyhid);
        // System.out.println(fsid);
        Integer fstemp=Integer.parseInt(fsid);
        // System.out.println(qxgz);
        Integer qxgztemp=Integer.parseInt(qxgz);
        int i = followService.addFollow(zyhtemp,fstemp,qxgztemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/upfollow")
    public String upFollow(@RequestParam(value = "zyhid") String zyhid,@RequestParam(value = "fsid") String fsid,@RequestParam(value = "qxgz") String qxgz){
        // System.out.println("up");
        // System.out.println(zyhid);
        Integer zyhtemp=Integer.parseInt(zyhid);
        // System.out.println(fsid);
        Integer fstemp=Integer.parseInt(fsid);
        // System.out.println(qxgz);
        Integer qxgztemp=Integer.parseInt(qxgz);
        int i = followService.updateFollow(zyhtemp,fstemp,qxgztemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }
}
