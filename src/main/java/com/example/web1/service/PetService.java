package com.example.web1.service;

import java.util.List;

import com.example.web1.pojo.Pet;

public interface PetService {
    List<Pet> getPetByYlid(Integer yhid);

}
