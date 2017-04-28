package com.thoughtworks.gaia.tableA.model;

import com.thoughtworks.gaia.common.jpa.IdBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by haoyuze on 2017/4/25.
 */
@Entity
@Table(name = "address")
public class AddressModel extends IdBaseModel {

    @Column(name = "aid", nullable = false)
    private Long aid;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
