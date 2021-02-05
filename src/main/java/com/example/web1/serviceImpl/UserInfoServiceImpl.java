package com.example.web1.serviceImpl;

import com.example.web1.pojo.User;
import com.example.web1.mapper.FollowMapper;
import com.example.web1.mapper.ShareMapper;
import com.example.web1.mapper.UserMapper;
import com.example.web1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FollowMapper followMapper;
    @Autowired
    ShareMapper shareMapper;

    @Override
    public User getUserInfoById(Integer yhid) {
        return  userMapper.getUserInfoById(yhid);
    }

    @Override
    public User getUserInfoByName(String yhm) {
        return  userMapper.getUserInfoByName(yhm);
    }

    @Override
    public List<User> getUserInfoBySimilarName(String yhm) {
        return  userMapper.getUserInfoBySimilarName(yhm);
    }

    @Override
    public List<User> getUserInfoByYx(String yx) {
        return  userMapper.getUserInfoByYx(yx);
    }


    @Override
    public int addUser(User User) {
        return userMapper.addUser(User);
    }

    @Override
    public int[] gz_fs_fx( Integer yhid ){
        int[] a=new int[3];
        a[0]=followMapper.getFollowFsId(yhid);
        a[1]=followMapper.getFollowZyhId(yhid);
        a[2]=shareMapper.getShareYhId(yhid);
        return a;
    }

}


