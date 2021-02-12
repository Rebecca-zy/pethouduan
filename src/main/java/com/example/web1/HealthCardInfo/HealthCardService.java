package com.example.web1.HealthCardInfo;

import com.example.web1.mapper.HealthCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCardService {
    @Autowired
    HealthCardMapper healthCardMapper;

    public String getKindInfo(Integer yhid,Integer cwid){
        return healthCardMapper.getKindInfo(yhid,cwid);
    }

    public String getGenderInfo(Integer yhid,Integer cwid){
        return healthCardMapper.getGenderInfo(yhid,cwid);
    }

    public String getNameInfo(Integer yhid,Integer cwid){
        return healthCardMapper.getNameInfo(yhid,cwid);
    }

    public String getEmailInfo(Integer yhid){
        return healthCardMapper.getEmailInfo(yhid);
    }

    public String getBirthInfo(Integer yhid,Integer cwid){
        return healthCardMapper.getBirthInfo(yhid,cwid);
    }
}
