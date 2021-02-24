package com.example.web1.serviceImpl;

import java.util.ArrayList;

import com.example.web1.mapper.FollowMapper;
import com.example.web1.mapper.PetMapper;
import com.example.web1.mapper.UserMapper;
import com.example.web1.pojo.Follow;
import com.example.web1.pojo.User;
import com.example.web1.service.FollowService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowMapper followMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUserFs(Integer zyhid){
        Integer a[]=followMapper.getuserFsZyhId(zyhid);
        List<User> temp=new ArrayList<User>();
        for(int i=0;i<a.length;i++){
            temp.add(userMapper.getUserInfoById(a[i]));
        }
        return temp;
    }
    @Override
    public List<User> getUserGz(Integer zyhid){
        Integer a[]=followMapper.getuserFollowZyhId(zyhid);
        List<User> temp=new ArrayList<User>();
        for(int i=0;i<a.length;i++){
            temp.add(userMapper.getUserInfoById(a[i]));
        }
        return temp;
    }
    @Override
    public Integer getFollowZyhId(Integer zyhid){
        return followMapper.getFollowZyhId(zyhid);
    }
    @Override
    public Integer getFollowFsId(Integer fsid){
        return followMapper.getFollowFsId(fsid);
    }
    @Override
    public Follow JudgeFollowZyhId(Integer zyhid, Integer fsid){return followMapper.JudgeFollowZyhId(zyhid,fsid);}
    @Override
    public Follow getIsFollow(Integer zyhid,Integer fsid){
        return followMapper.getIsFollow(zyhid, fsid);
    }
    @Override
    public Integer addFollow( Integer zyhid,Integer fsid,Integer qxgz){
        return followMapper.addFollow(zyhid, fsid, qxgz);
    }
    @Override
    public Integer updateFollow(Integer zyhid,Integer fsid,Integer qxgz){
        return followMapper.updateFollow(zyhid, fsid,qxgz);
    }
}
