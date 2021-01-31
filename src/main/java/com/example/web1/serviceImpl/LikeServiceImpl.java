package com.example.web1.serviceImpl;

import com.example.web1.mapper.LikeMapper;
import com.example.web1.pojo.Like;
import com.example.web1.pojo.Star;
import com.example.web1.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeMapper likeMapper;
    @Override
    public Integer getLikeNumByJlid(Integer jlid){
        return likeMapper.getLikeNumByJlid(jlid);
    }
    @Override
    public Like getIsLike(Integer yhid, Integer jlid){
        return likeMapper.getIsLike(yhid, jlid);
    }
    @Override
    public Integer addLike(Integer yhid,Integer jlid){ return likeMapper.addLike(yhid, jlid); }
    @Override
    public Integer updateLike(Integer zyhid,Integer jlid,Integer sc){
        return likeMapper.updateLike(zyhid, jlid, sc);
    }
}
