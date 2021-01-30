package com.example.web1.serviceImpl;

import com.example.web1.mapper.LikeMapper;
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
}
