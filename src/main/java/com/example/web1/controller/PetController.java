package com.example.web1.controller;

import java.util.List;
import java.util.Map;

import com.example.web1.pojo.Pet;
import com.example.web1.pojo.petinfo;
import com.example.web1.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PetController {
    @Autowired
    PetService petService;
    @PostMapping("/petlist")
    public List<Pet> PetListByyhid(@RequestParam("yhid") Integer yhid){
        return petService.getPetByYlid(yhid);
    }
    // 通过用户id获得宠物列表信息和照片
    @PostMapping("/petinfolistbyyhid")
    public List<petinfo> petInfoListByYhid(@RequestParam("yhid") Integer yhid){
        return petService.getPetInfoByYhid(yhid);
    }
    @PostMapping("/renewPet")
    public String renewPet(@RequestBody Map pet){
        try{
            Integer cwid=Integer.parseInt(String.valueOf(pet.get("cwid")));
            String xm=String.valueOf(pet.get("xm"));
            String xb=String.valueOf(pet.get("xb"));
            String pz=String.valueOf(pet.get("pz"));
            String csrq=String.valueOf(pet.get("csrq"));
            petService.renewPet(cwid,xm,xb,pz,csrq);
        }
        catch (Exception e){
            System.out.println(e);
            return "fail";
        }
        return "success";
    }

    @PostMapping("/addPet")
    public String addPet(@RequestBody Map pet){
        try{
            String zl=String.valueOf(pet.get("zl"));
            Integer yhid=Integer.parseInt(String.valueOf(pet.get("yhid")));
            String xm=String.valueOf(pet.get("xm"));
            String xb=String.valueOf(pet.get("xb"));
            String pz=String.valueOf(pet.get("pz"));
            String csrq=String.valueOf(pet.get("csrq"));
            petService.addPet(zl,yhid,xm,xb,pz,csrq);
        }
        catch (Exception e){
            System.out.println(e);
            return "fail";
        }
        return "success";
    }
}
