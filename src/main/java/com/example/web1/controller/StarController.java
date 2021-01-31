package com.example.web1.controller;
import com.example.web1.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StarController {
    @Autowired
    StarService starService;
    @PostMapping("starcount")
    public Integer getLikeNum(@RequestParam("jlid") String jlid){ return starService.getStarNumByJlid(Integer.parseInt(jlid)); }
    @GetMapping("/isstar")
    public String isStar(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        try {
            if(starService.getIsStar(yhtemp,jltemp).getSc()==0){
                return "0";//已收藏
            }
            else{
                return "1";//收藏过取消了
            }
        } catch (Exception e) {
            return "wu";//从未收藏过
        }
    }

    @GetMapping("/addstar")
    public String addStar(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        int i = starService.addStar(yhtemp,jltemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/upstar")
    public String upStar(@RequestParam(value = "yhid") String yhid,@RequestParam(value = "jlid") String jlid,@RequestParam(value = "sc") String sc){
        Integer yhtemp=Integer.parseInt(yhid);
        Integer jltemp=Integer.parseInt(jlid);
        Integer sctemp=Integer.parseInt(sc);
        int i = starService.updateStar(yhtemp,jltemp,sctemp);
        if (i==1){
            return "success";
        }
        return "fail";
    }

}
