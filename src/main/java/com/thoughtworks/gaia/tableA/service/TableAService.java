package com.thoughtworks.gaia.tableA.service;

import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.tableA.TableAMapper;
import com.thoughtworks.gaia.tableA.dao.TableADao;
import com.thoughtworks.gaia.tableA.entity.TableA;
import com.thoughtworks.gaia.tableA.model.TableAModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by haoyuze on 2017/4/24.
 */
@Component
@Transactional
public class TableAService implements Loggable {
    @Autowired
    private TableAMapper mapper;

    @Autowired
    private TableADao tableADao;

    public TableA getTableA(Long tableA_Id) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if (tableAModel == null) {
            error("TableA not found with id: " + tableA_Id);
            throw new NotFoundException();
        }

        return mapper.map(tableAModel, TableA.class);
    }

    public void deleteTableA(Long tableA_Id) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if (tableAModel == null) {
            error("Product not found with id: " + tableA_Id);
            throw new NotFoundException();
        }

        tableADao.remove(tableAModel);
    }

    public TableAModel addTableA(TableA tableA) {
        TableAModel tableAModel = mapper.map(tableA, TableAModel.class);
        tableADao.save(tableAModel);

        if (tableADao.idEquals(tableAModel.getId()).querySingle() == null) {
            error("TableA not found with id: " + tableAModel.getId());
            throw new NotFoundException();
        }

        return tableAModel;
    }

    public TableA upDataTableA(TableA tableA) {

        if (tableADao.idEquals(tableA.getId()).querySingle() == null) {
            error("TableA not found with id: " + tableA.getId());
            throw new NotFoundException();
        }
        return mapper.map(tableADao.update(mapper.map(tableA, TableAModel.class)), TableA.class);
    }
}
