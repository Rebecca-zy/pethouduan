package com.example.web1.service;
import com.example.web1.pojo.User;

public interface UserInfoService {
    User getUserInfoById( Integer userId);
    User getUserInfoByName( String userName);
    int addUser( User User);
}
