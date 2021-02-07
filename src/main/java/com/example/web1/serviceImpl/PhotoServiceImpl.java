package com.example.web1.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.web1.mapper.PhotoMapper;
import com.example.web1.pojo.Photo;
import com.example.web1.pojo.userPhotolist;
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
    @Override
    public List<Photo> getPhotoByYhid(Integer yhid){ return photoMapper.getPhotoByYhid(yhid); }
    
    @Override
    public int[] getjlidByPhoto(Integer yhid) {
        return photoMapper.getjlidByPhoto(yhid);
    }

    @Override
    public int[] getRandomptid(){
        return photoMapper.getRandomptid();
    }

    @Override
    public String[] getPetPicList(Integer cwid){
        return photoMapper.getPetPicList(cwid);
    }

    @Override 
    public String[] getPhotoFbsj(Integer yhid){
        return photoMapper.getPhotoFbsj(yhid);
    }

    @Override
    public List<userPhotolist> getUserPhotolistByYhid(Integer yhid){
        List<userPhotolist> temp=new ArrayList<userPhotolist>();
        String s[]=getPhotoFbsj(yhid);
        for(int i=0;i<s.length;i++){
            userPhotolist t=new userPhotolist();
            t.setFbsj(s[i]);
            t.setPhotolist(photoMapper.getUserPhotolistByYhid(yhid,s[i]));
            temp.add(t);
        }
        return temp;
    }
}