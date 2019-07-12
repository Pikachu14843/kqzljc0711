package com.qf.bean;

import java.util.List;

public class District {
    private Integer id;

    private String name;

    private List<Airquality> airqualities;

    public List<Airquality> getAirqualities() {
        return airqualities;
    }

    public void setAirqualities(List<Airquality> airqualities) {
        this.airqualities = airqualities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}