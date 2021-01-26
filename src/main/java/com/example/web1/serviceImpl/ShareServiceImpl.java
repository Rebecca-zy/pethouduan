package com.example.web1.serviceImpl;

import com.example.web1.mapper.ShareMapper;
import com.example.web1.pojo.Share;
import com.example.web1.service.Shareservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShareServiceImpl implements Shareservice{
    @Autowired
    private ShareMapper shareMapper;
    @Override
    public Share getShareByJlid(int jlid){
        return shareMapper.getShareByJlid(jlid);
    }
}
