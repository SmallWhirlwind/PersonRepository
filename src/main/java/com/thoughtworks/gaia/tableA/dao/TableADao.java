package com.thoughtworks.gaia.tableA.dao;

import com.thoughtworks.gaia.common.jpa.BaseDaoWrapper;
import com.thoughtworks.gaia.tableA.model.TableAModel;
import org.springframework.stereotype.Component;

/**
 * Created by haoyuze on 2017/4/24.
 */
@Component
public class TableADao extends BaseDaoWrapper<TableAModel> {
    public TableADao() {
        super(TableAModel.class);
    }
}
