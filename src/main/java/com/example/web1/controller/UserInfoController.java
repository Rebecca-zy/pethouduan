package com.example.web1.controller;
import com.example.web1.CheckToken;
import com.example.web1.PassToken;
import com.example.web1.pojo.Follow;
import com.example.web1.pojo.Knowledge;
import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import com.example.web1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userService;
    @Autowired
    ShareService shareService;
    @Autowired
    TokenService tokenService;
    @Autowired
    PhotoService photoService;
    @Autowired
    FollowService followService;
    @Value("${EXPIRE_TIME}")
    private String EXPIRE_TIME;
    @CheckToken
    @GetMapping("/getUserByName/{userName}")
    public String getUser(@PathVariable("userName") String userName) {
        User userInfoByName = userService.getUserInfoByName(userName);
        return userInfoByName.toString();
    }

    // http://localhost:8000/user/getUserByNamelog/用户名1
    @GetMapping("/getUserByNamelog/{userName}")
    public User getUserlog(@PathVariable("userName") String userName) {
        User userInfoByName = userService.getUserInfoByName(userName);
        return userInfoByName;
    }

    //通过用户名找对应用户id、最近动态和照片
    @PostMapping("/search")
    public Map search(@RequestBody Map user) {
        Map<String,List> result=new HashMap();
        List<User>usertmp=new ArrayList<User>();
        usertmp.addAll(userService.getUserInfoBySimilarName(String.valueOf(user.get("username"))));
        result.put("user",usertmp);
        // System.out.println(usertmp);
        List shareinfo=new ArrayList();
        List photoinfo=new ArrayList();
        List followinfo=new ArrayList();
            for (int i = 0; i < usertmp.size(); i++) {
                try {
                    User s = (User) usertmp.get(i);
                    // System.out.println(s.getYhid());
                    shareinfo.add((shareService.getLatestShareByYhid(s.getYhid())).getWz());
                }
                catch (Exception e){
                    shareinfo.add("");
                }

                try{
                    User s = (User) usertmp.get(i);
                    Integer yhid=s.getYhid();
                    photoinfo.add((photoService.getPhotoByYhid(yhid)));
                }
                catch (Exception e){
                    photoinfo.add("");
                }
                //knowledgeService.getKnowledgePz(String.valueOf(knowledgeinfo.get("pz")))
                try{
                    User s = (User) usertmp.get(i);
                    Integer fsid=s.getYhid();
                    Integer zyhid=Integer.parseInt(user.get("zyhid").toString());
                    //Integer zyhid= (Integer) user.get("zyhid");
                    // System.out.println("zyhid:"+zyhid);
                    Follow tmp=followService.JudgeFollowZyhId(zyhid,fsid);
                    if(tmp!=null){
                        followinfo.add(true);
                    }
                    else {
                        followinfo.add(false);
                    }
                }
                catch (Exception e){
                    // System.out.println(e);
                    followinfo.add(false);
                }
            }
        result.put("share",shareinfo);
        result.put("photo",photoinfo);
        result.put("follow",followinfo);
        //Integer yhid=usertemp.getYhid();
        //result.put("yhm",usertemp.getYhm());
        //Share sharetemp= shareService.getLatestShareByYhid(yhid);
        //result.put("share",sharetemp.getWz());
        return result;
    }

    //修改更新用户名、个性签名以及邮箱信息
    @PostMapping("/renew")
    public String renew(@RequestBody Map user) {
        try{
        Integer yhid=Integer.parseInt(String.valueOf(user.get("yhid")));
        String yhm=String.valueOf(user.get("yhm"));
        String yx=String.valueOf(user.get("yx"));
        String gxqm=String.valueOf(user.get("gxqm"));
        return userService.renewUser(yhid,yhm,yx,gxqm);
        }
        catch (Exception e){
            System.out.println(e);
            return "fail";
        }
    }

    //注册
    @PassToken
    @PostMapping("/register")
    public String register(@RequestBody  Map map) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encodePwd = bCryptPasswordEncoder.encode(String.valueOf(map.get("password")));
        User User=new User();
        User.setYhm(String.valueOf(map.get("username")));
        User.setMm(encodePwd);
        User.setYx(String.valueOf(map.get("yx")));
        int i = userService.addUser(User);
        if (i==1){
            return "注册成功";
        }
        return "注册失败";
    }

    //登录
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,Object> user){
        // System.out.println(user);
        Map result=new HashMap();
        User userForBase=userService.getUserInfoByName(String.valueOf(user.get("username")));
        if(userForBase==null){
            result.put("message","登录失败,用户不存在");
            return result;
        }else {
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            String dbPwd=userForBase.getMm();
            boolean matchesResult = bCryptPasswordEncoder.matches(String.valueOf(user.get("password")),dbPwd);
            if (!matchesResult){
                result.put("message","登录失败,密码错误");
                return result;
            }else {
                Date expiresDate = new Date(System.currentTimeMillis()+Integer.valueOf(EXPIRE_TIME)*60*1000);
                String token = tokenService.getToken(userForBase,expiresDate);
                result.put("token", token);
                result.put("expireTime", EXPIRE_TIME);
                result.put("yhid", userForBase.getYhid());
                result.put("yhm", userForBase.getYhm());
                return result;
            }
        }
    }
    @CheckToken
    @GetMapping("/afterLogin")
    public String afterLogin(){
        return "你已通过验证,成功进入系统";
    }

    // 注册前验证用户名唯一性
    @GetMapping("/registercheck")
    public String RegisterNameCheck(@RequestParam("yhm") String yhm) {
        try{
            return userService.getUserInfoByName(yhm).toString();
        }catch (Exception e) {
            return "testusername";
        }   
    }

    // 注册前验证邮箱唯一性
    @GetMapping("/registeryxcheck")
    public String RegisterYxCheck(@RequestParam("yx") String yx) {
        List<User> a=userService.getUserInfoByYx(yx);
        if(a.isEmpty() ){
            return "testmail";
        }
        else{
            return userService.getUserInfoByYx(yx).toString();
        }
    }
    
    // 通过用户id获取关注 粉丝分享数字
    @PostMapping("/gzfsfx")
    public int[] gzFsFx(@RequestParam("yhid") Integer yhid){
        return userService.gz_fs_fx(yhid);
    }

}

