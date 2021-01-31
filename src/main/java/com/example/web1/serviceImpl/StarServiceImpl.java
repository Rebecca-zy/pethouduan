package com.example.web1.serviceImpl;

import com.example.web1.mapper.StarMapper;
import com.example.web1.pojo.Follow;
import com.example.web1.pojo.Star;
import com.example.web1.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarServiceImpl implements StarService {
    @Autowired
    StarMapper starMapper;
    @Override
    public Integer getStarNumByJlid(Integer jlid){
        return starMapper.getStarNumByJlid(jlid);
    }

    @Override
    public Star getIsStar(Integer yhid, Integer jlid){
        return starMapper.getIsStar(yhid, jlid);
    }
    @Override
    public Integer addStar( Integer yhid,Integer jlid){
        return starMapper.addStar(yhid, jlid);
    }
    @Override
    public Integer updateStar(Integer zyhid,Integer jlid,Integer sc){
        return starMapper.updateStar(zyhid, jlid, sc);
    }


}
