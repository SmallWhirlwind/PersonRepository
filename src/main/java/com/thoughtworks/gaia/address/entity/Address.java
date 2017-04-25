package com.thoughtworks.gaia.address.entity;

/**
 * Created by haoyuze on 2017/4/25.
 */
public class Address {
    private Long id;

    private Long aid;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid){
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
