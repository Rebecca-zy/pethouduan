package com.example.web1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer yhid;
    private String yhm;
    private String mm;


    public Integer getYhid() {
        return yhid;
    }

    public void setYhid(Integer yhid) {
        this.yhid = yhid;
    }

    public String getYhm() {
        return yhm;
    }

    public void setYhm(String yhm) {
        this.yhm = yhm;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }
}


