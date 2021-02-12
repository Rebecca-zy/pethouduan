package com.example.web1.controller;

import java.util.List;

import com.example.web1.pojo.Pet;
import com.example.web1.pojo.petinfo;
import com.example.web1.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
