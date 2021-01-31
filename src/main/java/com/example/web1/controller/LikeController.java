package com.example.web1.controller;

import com.example.web1.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LikeController {
    @Autowired
    LikeService likeService;
    @PostMapping("/likecount")
    public Integer likecount(@RequestParam("jlid") String jlid){
        return likeService.getLikeNumByJlid(Integer.parseInt(jlid));
    }

    @GetMapping("/islike")
    public String isStar(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        try {
            if(likeService.getIsLike(yhtemp,jltemp).getSc()==0){
                return "0";//已收藏
            }
            else{
                return "1";//收藏过取消了
            }
        } catch (Exception e) {
            return "wu";//从未收藏过
        }
    }

    @GetMapping("/addlike")
    public String addLike(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        int i = likeService.addLike(yhtemp,jltemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/uplike")
    public String upLike(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid,@RequestParam(value = "sc") String sc){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        Integer sctemp=Integer.parseInt(sc);
        int i = likeService.updateLike(yhtemp,jltemp,sctemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }



}
