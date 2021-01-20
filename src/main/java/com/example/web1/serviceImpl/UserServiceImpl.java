package com.example.web1.serviceImpl;


import com.example.web1.bean.UserBean;
import com.example.web1.mapper.UserMapper;
import com.example.web1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired //@Autowired 将寻找与之匹配的bean来创建（类名）
    private UserMapper userMapper;

    @Override // @Override是伪代码,表示重写
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }


}

