package com.thoughtworks.gaia.address.dao;

import com.thoughtworks.gaia.address.model.AddressModel;
import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.tableA.model.TableAModel;
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
