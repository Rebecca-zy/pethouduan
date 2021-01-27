package com.example.web1.serviceImpl;

import java.util.List;

import com.example.web1.mapper.PhotoMapper;
import com.example.web1.pojo.Photo;
import com.example.web1.service.PhotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public List<Photo> getPhotoByjlid(int jlid){
        return photoMapper.getPhotoByjlid(jlid);
    }
}