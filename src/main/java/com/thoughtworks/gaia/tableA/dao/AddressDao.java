package com.thoughtworks.gaia.tableA.dao;

import com.thoughtworks.gaia.tableA.model.AddressModel;
import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import org.springframework.stereotype.Component;

/**
 * Created by haoyuze on 2017/4/25.
 */
@Component
public class AddressDao extends BaseDaoWrapper<AddressModel> {
    public AddressDao() {
        super(AddressModel.class);
    }
}
