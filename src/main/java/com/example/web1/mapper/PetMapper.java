package com.example.web1.mapper;

import java.util.List;

import com.example.web1.pojo.Pet;

import com.example.web1.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PetMapper {
    @Select("SELECT * FROM pet WHERE yhid=#{yhid} AND sc=0")
    List<Pet> getPetByYlid(@Param("yhid") Integer yhid);

    @Update("update pet set pz=#{pz},xb=#{xb},csrq=#{csrq},xm=#{xm} where cwid=#{cwid}")
    void renewPet(@Param("cwid")Integer cwid,@Param("xm")String xm,@Param("xb")String xb,@Param("pz") String pz,@Param("csrq")String csrq);

    @Insert("INSERT INTO pet (zl, xm, xb, csrq, pz, yhid )   VALUES (#{zl}, #{xm}, #{xb}, #{csrq}, #{pz}, #{yhid}) ")
    @Options(useGeneratedKeys = true)
    int addPet(@Param("zl") String zl,@Param("yhid")Integer yhid,@Param("xm")String xm,@Param("xb")String xb,@Param("pz") String pz,@Param("csrq")String csrq);
}
