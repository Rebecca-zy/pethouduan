package com.example.web1.serviceImpl;

import com.example.web1.mapper.LikeMapper;
import com.example.web1.mapper.PhotoMapper;
import com.example.web1.mapper.ShareMapper;
import com.example.web1.mapper.StarMapper;
import com.example.web1.mapper.UserMapper;
import com.example.web1.mapper.VideoMapper;
import com.example.web1.pojo.Like;
import com.example.web1.pojo.Photo;
import com.example.web1.pojo.Share;
import com.example.web1.pojo.User;
import com.example.web1.pojo.Video;
import com.example.web1.pojo.messageinfo;
import com.example.web1.service.ShareService;
import com.example.web1.service.UserInfoService;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    StarMapper starMapper;
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    PhotoMapper photoMapper;
    @Autowired
    VideoMapper videoMapper; 
    @Autowired
    UserMapper userMapper; 

    @Override
    public Integer addShare(Integer yhid,Integer cwid,String yhm,String fbsj,String wz,Integer fqh){
        return shareMapper.addShare(yhid,cwid, yhm, fbsj, wz, fqh);
    }

    @Override
    public Integer getShareYhId(Integer yhid) {
        return shareMapper.getShareYhId(yhid);
    }

    @Override
    public Share getShareByJlid(int jlid) {
        return shareMapper.getShareByJlid(jlid);
    }

    @Override
    public Share getLatestShareByYhid(Integer yhid) {
        return shareMapper.getLatestShareByYhid(yhid);
    }

    @Override
    public List<Share> getShareInfoBySimilarName(String wz) {
        return shareMapper.getShareInfoBySimilarName(wz);
    }

    @Override
    public List<Share> getShareInfoBySection(String wz,String fqh) {
        return shareMapper.getShareInfoBySection(wz,fqh);
    }

    @Override
    public List<Share> getShareInfoByKind(String wz,String zl) {
        return shareMapper.getShareInfoByKind(wz,zl);
    }

    @Override
    public int[] getShareidByStarLike() {
        return shareMapper.getShareidByStarLike();
    }

    @Override
    public int[] getShareidByyhid(int yhid) {
        return shareMapper.getShareidByyhid(yhid);
    }

    @Override
    public int[] getShareidBycwyhid(int yhid,int cwid){
        return shareMapper.getShareidBycwidyhid(yhid, cwid);
    }

    @Override
    public List<messageinfo> userShareByYhid(int yhid, int zyhid,int cwid) {
        int a[] = new int [getShareidByyhid(yhid).length];
        if(cwid==0){
            a=getShareidByyhid(yhid);
        }
        else{
            a= getShareidBycwyhid(yhid, cwid);
        } 
        List<messageinfo> temp = new ArrayList<messageinfo>();
        for (int i = 0; i < a.length; i++) {
            messageinfo t = new messageinfo();
            Share s = getShareByJlid(a[i]);
            t.setDatatime(s.getFbsj());
            t.setPassage(s.getWz());
            t.setMessagenum(s.getJlid());
            t.setStarnumber(starMapper.getStarNumByJlid(s.getJlid()));
            t.setLovenumber(likeMapper.getLikeNumByJlid(s.getJlid()));
            if (zyhid == 0) {
                
                t.setIslove("喜欢");
                t.setIsstar("收藏");
            } else {
                try {
                    // System.out.println("xihuan");
                    if(likeMapper.getIsLike(zyhid, s.getJlid()).getSc()==0){
                        t.setIslove("已喜欢");
                    }
                    else{
                        t.setIslove("喜欢");
                    }
                } catch (Exception e) {
                    t.setIslove("喜欢");
                }
                try {
                    if(starMapper.getIsStar(zyhid, s.getJlid()).getSc()==0){
                        t.setIsstar("已收藏");
                    }
                    else{
                        t.setIsstar("收藏");
                    }
                } catch (Exception e) {
                    t.setIsstar("收藏");
                }   
            }
            if(photoMapper.getPhotoByjlid(s.getJlid()).toString()=="[]") {
                
                try{
                    Video n=videoMapper.getVideoByjlid(s.getJlid());
                    t.setVdurl(n.getSp());
                    t.setIsphoto("0");
                }catch(Exception e){
                    t.setIsphoto("wu");
                }
            }
            else{
                List<Photo> n=photoMapper.getPhotoByjlid(s.getJlid());
                String r[]=new String[n.size()];
                for(int j=0;j<n.size();j++){
                    r[j]=n.get(j).getZp();
                }
                t.setPhotourl(r);
                t.setIsphoto("1");
            }
            temp.add(i, t);
        }
        return temp;
    }

    @Override
    public List<messageinfo> userfollstarShareByyhid(int yhid,int fqh,int follorstar) {
        Integer a[];
        if(follorstar==1){//收藏
            if(fqh==0){
                a= starMapper.getStarJlid(yhid);
            }   
            else{
                a= starMapper.getStarfqhJlid(yhid,fqh);
            }
        }
        else{
            a=shareMapper.getfollowShareByyhid(yhid);
        }
        List<messageinfo> temp = new ArrayList<messageinfo>();
        for (int i = 0; i < a.length; i++) {
            messageinfo t = new messageinfo();
            Share s = getShareByJlid(a[i]);
            t.setDatatime(s.getFbsj());
            t.setPassage(s.getWz());
            t.setMessagenum(s.getJlid());
            t.setStarnumber(starMapper.getStarNumByJlid(s.getJlid()));
            t.setLovenumber(likeMapper.getLikeNumByJlid(s.getJlid()));
            User u=userMapper.getUserInfoById(s.getYhid());
            t.setUserid(u.getYhid());
            t.setUsername(u.getYhm());
            t.setUserurl(u.getTx());
            try {
                // System.out.println("xihuan");
                if(likeMapper.getIsLike(yhid, s.getJlid()).getSc()==0){
                    t.setIslove("已喜欢");
                }
                else{
                    t.setIslove("喜欢");
                }
            } catch (Exception e) {
                t.setIslove("喜欢");
            }
            try {
                if(starMapper.getIsStar(yhid, s.getJlid()).getSc()==0){
                    t.setIsstar("已收藏");
                }
                else{
                    t.setIsstar("收藏");
                }
            } catch (Exception e) {
                t.setIsstar("收藏");
            }   
            if(photoMapper.getPhotoByjlid(s.getJlid()).toString()=="[]") {    
                try{
                    Video n=videoMapper.getVideoByjlid(s.getJlid());
                    t.setVdurl(n.getSp());
                    t.setIsphoto("0");
                }catch(Exception e){
                    t.setIsphoto("wu");
                }
            }
            else{
                List<Photo> n=photoMapper.getPhotoByjlid(s.getJlid());
                String r[]=new String[n.size()];
                for(int j=0;j<n.size();j++){
                    r[j]=n.get(j).getZp();
                }
                t.setPhotourl(r);
                t.setIsphoto("1");
            }
            temp.add(i, t);
        }
        return temp;
    }
}
