package com.example.web1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HealthCardMapper {
    @Select("Select pz From pet Where yhid=#{yhid} and cwid=#{cwid}")
    String getKindInfo(@Param("yhid")Integer yhid,@Param("cwid")Integer cwid);

    @Select("Select xm From pet Where yhid=#{yhid} and cwid=#{cwid}")
    String getNameInfo(@Param("yhid")Integer yhid,@Param("cwid")Integer cwid);

    @Select("Select xb From pet Where yhid=#{yhid} and cwid=#{cwid}")
    String getGenderInfo(@Param("yhid")Integer yhid,@Param("cwid")Integer cwid);

    @Select("Select csrq From pet Where yhid=#{yhid} and cwid=#{cwid}")
    String getBirthInfo(@Param("yhid")Integer yhid,@Param("cwid")Integer cwid);

    @Select("Select yx From user Where yhid=#{yhid}")
    String getEmailInfo(@Param("yhid")Integer yhid);

}
