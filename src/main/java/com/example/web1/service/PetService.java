package com.example.web1.service;

import java.util.List;

import com.example.web1.pojo.Pet;
import com.example.web1.pojo.petinfo;

public interface PetService {
    List<Pet> getPetByYlid(Integer yhid);

    List<petinfo> getPetInfoByYhid(Integer yhid);

}
