package com.thoughtworks.gaia.tableA.model;

import com.thoughtworks.gaia.address.entity.Address;
import com.thoughtworks.gaia.address.model.AddressModel;
import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.List;

/**
 * Created by haoyuze on 2017/4/24.
 */
@Entity
@Table(name = "table_A")
public class TableAModel extends IdBaseModel {
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany
    @JoinColumn(name = "aid")
    private List<AddressModel> addressList;

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
