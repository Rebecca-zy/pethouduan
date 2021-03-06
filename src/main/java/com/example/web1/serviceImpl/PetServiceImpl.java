package com.example.web1.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.web1.mapper.PetMapper;
import com.example.web1.mapper.PhotoMapper;
import com.example.web1.pojo.Pet;
import com.example.web1.pojo.petinfo;
import com.example.web1.service.PetService;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetMapper petMapper;
    @Autowired
    PhotoMapper PhotoMapper;
    @Override
    public List<Pet> getPetByYlid( Integer yhid){
        return petMapper.getPetByYlid(yhid);
    }
    @Override
    public List<petinfo> getPetInfoByYhid(Integer yhid){
        List<Pet> a=new ArrayList<Pet>();
        a=getPetByYlid(yhid);
        List<petinfo> temp=new ArrayList<petinfo>();
        for(int i=0;i<a.size();i++){
            petinfo t=new petinfo();
            t.setPet(a.get(i));
            String s[]=PhotoMapper.getPetPicList(a.get(i).getCwid());
            String ss[]=new String[s.length];
            try {
                for(int j=0;j<3;j++){
                    if(s[j]!=null){
                        ss[j]=s[j];
                    } 
                    else
                        break;
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e);
            }
            t.setPetpic(ss);
            temp.add(i, t);
        }
        return temp;
    }
    @Override
    public void renewPet(Integer cwid, String xm, String xb, String pz, String csrq){
        petMapper.renewPet(cwid, xm, xb, pz, csrq);
    }

    @Override
    public void addPet(String zl,Integer yhid, String xm, String xb, String pz, String csrq){
        petMapper.addPet(zl,yhid, xm, xb, pz, csrq);
    }
}
