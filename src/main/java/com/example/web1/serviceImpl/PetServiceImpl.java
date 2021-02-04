package com.example.web1.serviceImpl;

import java.util.List;

import com.example.web1.mapper.PetMapper;
import com.example.web1.pojo.Pet;
import com.example.web1.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetMapper petMapper;
    @Override
    public List<Pet> getPetByYlid( Integer yhid){
        return petMapper.getPetByYlid(yhid);
    }

}
