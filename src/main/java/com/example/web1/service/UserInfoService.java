package com.example.web1.service;
import com.example.web1.pojo.User;

import java.util.List;

public interface UserInfoService {
    User getUserInfoById( Integer yhid);
    User getUserInfoByName( String yhm);
    List<User> getUserInfoBySimilarName(String yhm);
    List<User> getUserInfoByYx(String yx);
    int addUser(User User);
}
