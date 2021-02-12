package com.example.web1.serviceImpl;

import com.example.web1.mapper.KnowledgeMapper;
import com.example.web1.pojo.Knowledge;
import com.example.web1.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    KnowledgeMapper knowledgeMapper;

    @Override
    public Knowledge getKnowledgePz(String pz) {
        return knowledgeMapper.getKnowledgePz(pz);
    }

    @Override
    public Knowledge getKnowledgeBm(String bm) {
        return knowledgeMapper.getKnowledgeBm(bm);
    }

    @Override
    public Knowledge getKnowledgeXgtz(String xgtz) {
        return knowledgeMapper.getKnowledgeXgtz(xgtz);
    }

    @Override
    public Knowledge getKnowledgeJj(String jj) {
        return knowledgeMapper.getKnowledgeJj(jj);
    }

    @Override
    public Knowledge getKnowledgePzId(Integer pzid) { return knowledgeMapper.getKnowledgePzId(pzid); }

    @Override
    public Knowledge getKnowledgeZl(String zl) {
        return knowledgeMapper.getKnowledgeZl(zl);
    }
}

