package com.example.web1.service;
import com.example.web1.pojo.User;
import java.util.Date;


public interface TokenService {

    public  String getToken(User user, Date date);
}

