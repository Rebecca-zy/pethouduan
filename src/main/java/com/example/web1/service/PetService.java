package com.example.web1.service;

import java.util.List;

import com.example.web1.pojo.Pet;
import com.example.web1.pojo.petinfo;

public interface PetService {
    List<Pet> getPetByYlid(Integer yhid);

    List<petinfo> getPetInfoByYhid(Integer yhid);

    void renewPet(Integer cwid,String xm,String xb,String pz,String csrq);

    void addPet(String zl,Integer yhid, String xm, String xb, String pz, String csrq);
}
