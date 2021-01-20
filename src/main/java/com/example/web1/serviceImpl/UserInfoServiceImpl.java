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
    public User getUserInfoById(Integer userId) {
        return userMapper.getUserInfoById(userId);
    }

    @Override
    public User getUserInfoByName(String userName) {

        return userMapper.getUserInfoByName(userName);
    }

    @Override
    public int addUser(User User) {
        return userMapper.addUser(User);
    }
}

