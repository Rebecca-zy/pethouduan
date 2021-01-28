package com.example.web1.service;

import com.example.web1.pojo.Share;

public interface ShareService {
    Integer getShareYhId(Integer yhid);
    Share getShareByJlid(int jlid);

}
