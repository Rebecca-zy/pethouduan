package com.example.web1.serviceImpl;

import com.example.web1.mapper.ShareMapper;
import com.example.web1.pojo.Share;
import com.example.web1.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareMapper shareMapper;
    @Override
    public Integer getShareYhId(Integer yhid){ return shareMapper.getShareYhId(yhid); }
    @Override
    public Share getShareByJlid(int jlid){
        return shareMapper.getShareByJlid(jlid);
    }
    @Override
    public Share getLatestShareByYhid(Integer yhid){
        return shareMapper.getLatestShareByYhid(yhid);
    }
//    @Override
//    public Share getUserByYhid(Integer yhid){
//        return shareMapper.getUserByYhid(yhid);
//    }

}
