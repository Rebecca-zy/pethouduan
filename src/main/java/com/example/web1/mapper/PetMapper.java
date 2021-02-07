package com.example.web1.mapper;

import java.util.List;

import com.example.web1.pojo.Pet;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetMapper {
    @Select("SELECT * FROM pet WHERE yhid=#{yhid} AND sc=0")
    List<Pet> getPetByYlid(@Param("yhid") Integer yhid);

}
