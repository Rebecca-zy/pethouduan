package com.example.web1.serviceImpl;

import com.example.web1.mapper.FollowMapper;
import com.example.web1.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowMapper followMapper;
    @Override
    public Integer getFollowZyhId(Integer zyhid){
        return followMapper.getFollowZyhId(zyhid);
    }
}
