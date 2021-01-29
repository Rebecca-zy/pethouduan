package com.example.web1.service;

import com.example.web1.pojo.Follow;
import org.apache.ibatis.annotations.Param;

public interface FollowService {
    Integer getFollowZyhId(Integer zyhid);
    Follow JudgeFollowZyhId(Integer zyhid,Integer fsid);
}
