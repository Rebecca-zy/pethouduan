package com.example.web1.controller;
import com.example.web1.CheckToken;
import com.example.web1.PassToken;
import com.example.web1.pojo.User;
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
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userService;
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
                result.put("userId", userForBase.getYhid());
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

