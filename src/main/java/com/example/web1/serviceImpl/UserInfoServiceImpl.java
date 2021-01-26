package com.example.web1.serviceImpl;

import com.example.web1.pojo.User;

import com.example.web1.mapper.UserMapper;
import com.example.web1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfoById(Integer yhid) {
        return userMapper.getUserInfoById(yhid);
    }

    @Override
    public User getUserInfoByName(String yhm) {
        return userMapper.getUserInfoByName(yhm);
    }

    @Override
    public User getUserInfoByYx(String yx) {
        return userMapper.getUserInfoByYx(yx);
    }


    @Override
    public int addUser(User User) {
        return userMapper.addUser(User);
    }
}

