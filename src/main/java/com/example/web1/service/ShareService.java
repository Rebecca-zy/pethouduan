package com.example.web1.service;

import com.example.web1.pojo.Share;
import com.example.web1.pojo.messageinfo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareService {
    Integer getShareYhId(Integer yhid);
    Share getShareByJlid(int jlid);
    Share getLatestShareByYhid(Integer yhid);
    List<Share> getShareInfoBySimilarName(String wz);
    int[] getShareidByStarLike();
    int[] getShareidByyhid(int yhid);
    List<messageinfo> userShareByYhid(int yhid,int zyhid,int cwid);
    int[] getShareidBycwyhid(int yhid,int cwid);
    List<messageinfo> userfollstarShareByyhid(int yhid,int fqh,int follorstar);
    
}
