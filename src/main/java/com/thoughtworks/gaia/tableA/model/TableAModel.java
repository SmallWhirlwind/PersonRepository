package com.thoughtworks.gaia.tableA.model;

import com.thoughtworks.gaia.address.entity.Address;
import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.*;
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
    @JoinColumn(name="aid",referencedColumnName="id")
    private List<Address> addressList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList(){
        return addressList;
    }

    public void setAddressList(List<Address> addressList){
        this.addressList = addressList;
    }
}
