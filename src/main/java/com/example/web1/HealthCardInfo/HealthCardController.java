package com.example.web1.HealthCardInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class HealthCardController {
    @Autowired HealthCardService healthCardService;
    @PostMapping("/HealthCard")
    public Map<String,Object>getHealthInfo(@RequestBody Map HealthInfo){
        Map result=new HashMap();
        Integer yhid=Integer.parseInt(String.valueOf( HealthInfo.get("yhid")));
        Integer cwid=Integer.parseInt(String.valueOf(HealthInfo.get("cwid")));
        result.put("Name",healthCardService.getNameInfo(yhid,cwid));
        result.put("Kind",healthCardService.getKindInfo(yhid,cwid));
        result.put("Gender",healthCardService.getGenderInfo(yhid,cwid));
        result.put("Birth",healthCardService.getBirthInfo(yhid,cwid));
        result.put("Email",healthCardService.getEmailInfo(yhid));
        return result;
    }
}
