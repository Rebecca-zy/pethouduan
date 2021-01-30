package com.example.web1.serviceImpl;

import com.example.web1.mapper.StarMapper;
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

}
