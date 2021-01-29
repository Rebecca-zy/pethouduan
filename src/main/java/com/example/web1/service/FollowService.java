package com.example.web1.service;

import com.example.web1.pojo.Follow;

public interface FollowService {
    Integer getFollowZyhId(Integer zyhid);
    Follow getIsFollow(Integer zyhid,Integer fsid);
    Integer addFollow( Integer zyhid,Integer fsid,Integer qxgz);
    Integer updateFollow(Integer zyhid,Integer fsid,Integer qxgz);
  
}
