package com.example.web1.service;
import com.example.web1.pojo.User;

public interface UserInfoService {
    User getUserInfoById( Integer yhid);
    User getUserInfoByName( String yhm);
    User getUserInfoByYx(String yx);
    int addUser(User User);
}
