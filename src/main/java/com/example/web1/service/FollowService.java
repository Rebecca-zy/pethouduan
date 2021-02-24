package com.example.web1.service;

import com.example.web1.pojo.Follow;
import com.example.web1.pojo.User;

import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface FollowService {
    Integer getFollowZyhId(Integer zyhid);
    Integer getFollowFsId(Integer fsid);
    Follow JudgeFollowZyhId(Integer zyhid,Integer fsid);
    Follow getIsFollow(Integer zyhid,Integer fsid);
    Integer addFollow( Integer zyhid,Integer fsid,Integer qxgz);
    Integer updateFollow(Integer zyhid,Integer fsid,Integer qxgz);
    List<User> getUserFs(Integer zyhid);
    List<User> getUserGz(Integer zyhid);
}
