package com.example.web1.service;

import com.example.web1.pojo.Share;
import org.apache.ibatis.annotations.Param;

public interface ShareService {
    Integer getShareYhId(Integer yhid);
    Share getShareByJlid(int jlid);
    Share getLatestShareByYhid(Integer yhid);
//    Share getUserByYhid(Integer yhid);
}
