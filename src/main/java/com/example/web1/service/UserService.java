package com.example.web1.service;

import com.example.web1.bean.UserBean;

//对一个或多个DAO进行的再次封装，封装成一个服务
public interface UserService {
    UserBean loginIn(String name, String password);
}
