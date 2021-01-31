package com.example.web1.service;


import com.example.web1.pojo.Follow;
import com.example.web1.pojo.Star;

public interface StarService {
    Integer getStarNumByJlid(Integer jlid);
    Star getIsStar(Integer yhid, Integer jlid);
    Integer addStar( Integer yhid,Integer jlid);
    Integer updateStar(Integer yhid,Integer jlid,Integer sc);

}
