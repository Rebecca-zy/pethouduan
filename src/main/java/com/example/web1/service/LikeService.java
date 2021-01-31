package com.example.web1.service;

import com.example.web1.pojo.Like;
import com.example.web1.pojo.Star;

public interface LikeService {
    Integer getLikeNumByJlid(Integer jlid);
    Like getIsLike(Integer yhid, Integer jlid);
    Integer addLike( Integer yhid,Integer jlid);
    Integer updateLike(Integer yhid,Integer jlid,Integer sc);
}
