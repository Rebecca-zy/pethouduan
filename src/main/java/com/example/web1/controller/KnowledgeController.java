package com.example.web1.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.web1.CheckToken;
import com.example.web1.pojo.Knowledge;
import com.example.web1.pojo.User;
import com.example.web1.service.KnowledgeService;
import com.example.web1.service.TokenService;
import com.example.web1.service.UserInfoService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    @PostMapping("/doGetJson")
    public JSONObject doGetJson(@RequestBody Map knowledgeinfo) throws ParseException, UnsupportedEncodingException {
        Map result=new HashMap();
        String jsonText = "&name="+String.valueOf(knowledgeinfo.get("pz"));
        System.out.println("jsontext:"+jsonText);
//        JSONObject json = (JSONObject) JSONObject.parse(jsonText);
//        System.out.println("json:" + json);
        JSONObject sr = doGet(jsonText);
        System.out.println("返回参数：" + sr);
        return sr;
    }
    public static JSONObject doGet(String date) throws UnsupportedEncodingException {
        StringEntity s = new StringEntity(date.toString());
        System.out.println("date:"+date.toString());
        HttpClient client = HttpClients.createDefault();
        // 要调用的接口方法
        String url = "http://api.tianapi.com/txapi/pet/index?";
        StringBuffer sb = new StringBuffer(url);
        sb.append("key=" +"ada564d6f9837fec8d0152c4ead2d275");
        sb.append(date.toString());
        System.out.println("url："+sb);
        // 创建请求对象
        HttpGet httpGet = new HttpGet(sb.toString());
        JSONObject jsonObject = null;
        try {
            httpGet.addHeader("content-type", "application/x-www-form-urlencoded");
            HttpResponse resp = client.execute(httpGet);
            // 判断是否响应成功
            String response1 = EntityUtils.toString(resp.getEntity());
            System.out.println(response1);
            if (resp.getStatusLine().getStatusCode() == 200) {
                String result = response1;// 返回json格式：
                jsonObject = JSONObject.parseObject(result);
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return jsonObject;

    }

}
