package com.thoughtworks.gaia.tableA.entity;

import com.thoughtworks.gaia.address.model.AddressModel;

import java.util.List;

/**
 * Created by haoyuze on 2017/4/24.
 */
public class TableA {
    private Long id;

    private String name;

    private List<AddressModel> addressList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressModel> addressList) {
        this.addressList = addressList;
    }
}
