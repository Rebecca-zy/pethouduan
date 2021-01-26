package com.example.web1.mapper;

import org.apache.ibatis.annotations.*;
import com.example.web1.pojo.Knowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KnowledgeMapper {
    @Select("SELECT * FROM knowledge WHERE pzid=#{pzid}")
    Knowledge getKnowledgePzId(@Param("pzid") Integer pzid);

    @Select("SELECT * FROM knowledge WHERE pz=#{pz}")
    Knowledge getKnowledgePz(@Param("pz") String pz);

    @Select("SELECT * FROM knowledge WHERE bm=#{bm}")
    Knowledge getKnowledgeBm(@Param("bm") String bm);

    @Select("SELECT * FROM knowledge WHERE xgtz=#{xgtz}")
    Knowledge getKnowledgeXgtz(@Param("xgtz") String xgtz);

    @Select("SELECT * FROM knowledge WHERE jj=#{jj}")
    Knowledge getKnowledgeJj(@Param("jj") String jj);

    @Select("SELECT * FROM knowledge WHERE zl=#{zl}")
    Knowledge getKnowledgeZl(@Param("zl") String zl);
}
