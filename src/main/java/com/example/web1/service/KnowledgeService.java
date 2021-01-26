package com.example.web1.service;

import com.example.web1.pojo.Knowledge;

public interface KnowledgeService {
    Knowledge  getKnowledgePz(String pz);
    Knowledge  getKnowledgeZl(String zl);
    Knowledge  getKnowledgeBm(String bm);
    Knowledge  getKnowledgeXgtz(String xgtz);
    Knowledge getKnowledgeJj(String jj);
    Knowledge getKnowledgePzId(Integer pzid);
}
