package com.example.web1.controller;
import com.example.web1.CheckToken;
import com.example.web1.PassToken;
import com.example.web1.pojo.Knowledge;
import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import com.example.web1.service.ShareService;
import com.example.web1.service.TokenService;
import com.example.web1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    @Value("${EXPIRE_TIME}")
    private String EXPIRE_TIME;
    @CheckToken
    @GetMapping("/getUserByName/{userName}")
    public String getUser(@PathVariable("userName") String userName) {
        User userInfoByName = userService.getUserInfoByName(userName);
        return userInfoByName.toString();
    }

    //通过用户名找对应用户id和最近动态
    @PostMapping("/search")
    public Map search(@RequestBody Map user) {
        Map<String,List> result=new HashMap();
        List<User>usertmp=new ArrayList<User>();
        usertmp.addAll(userService.getUserInfoBySimilarName(String.valueOf(user.get("username"))));
        result.put("user",usertmp);
        System.out.println(usertmp);
        List otherinfo=new ArrayList();
            for (int i = 0; i < usertmp.size(); i++) {
                try {
                    User s = (User) usertmp.get(i);
                    System.out.println(s.getYhid());
                    otherinfo.add((shareService.getLatestShareByYhid(s.getYhid())).getWz());
                }
                catch (Exception e){
                    otherinfo.add("");
                }
            }
        System.out.print(otherinfo);
        result.put("yhm",otherinfo);
        //Integer yhid=usertemp.getYhid();
        //result.put("yhm",usertemp.getYhm());
        //Share sharetemp= shareService.getLatestShareByYhid(yhid);
        //result.put("share",sharetemp.getWz());
        return result;
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
    public Map<String, Object> login(@RequestBody Map user){
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
                return result;
            }
        }
    }
    @CheckToken
    @GetMapping("/afterLogin")
    public String afterLogin(){
        return "你已通过验证,成功进入系统";
    }

}

