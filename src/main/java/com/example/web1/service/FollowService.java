package com.example.web1.service;

import com.example.web1.pojo.Follow;
import org.apache.ibatis.annotations.Param;

public interface FollowService {
    Integer getFollowZyhId(Integer zyhid);
    Follow JudgeFollowZyhId(Integer zyhid,Integer fsid);
    Follow getIsFollow(Integer zyhid,Integer fsid);
    Integer addFollow( Integer zyhid,Integer fsid,Integer qxgz);
    Integer updateFollow(Integer zyhid,Integer fsid,Integer qxgz);
}
