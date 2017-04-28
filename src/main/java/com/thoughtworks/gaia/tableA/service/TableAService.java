package com.thoughtworks.gaia.tableA.service;

import com.thoughtworks.gaia.tableA.dao.AddressDao;
import com.thoughtworks.gaia.tableA.entity.Address;
import com.thoughtworks.gaia.tableA.model.AddressModel;
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

    @Autowired
    private AddressDao addressDao;

    

    public TableA getTableA(Long tableA_Id) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if (tableAModel == null) {
            error("TableA not found with id: " + tableA_Id);
            throw new NotFoundException();
        }

        return mapper.map(tableAModel, TableA.class);
    }

    public Address getAddressFromTableA(Long tableA_Id, Long address_Id) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if(tableAModel.getAddressList()!=null) {
            for (AddressModel temp : tableAModel.getAddressList()) {
                if (temp.getId().equals(address_Id)) {
                    return mapper.map(temp, Address.class);
                }
            }
        }
        throw new NotFoundException();
    }

    public void deleteTableA(Long tableA_Id) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if (tableAModel == null) {
            error("Product not found with id: " + tableA_Id);
            throw new NotFoundException();
        }

        tableADao.remove(tableAModel);
    }

    public void deleteAddress(Long address_Id) {
        AddressModel addressModel = addressDao.idEquals(address_Id).querySingle();
        if (addressModel == null) {
            error("Product not found with id: " + address_Id);
            throw new com.thoughtworks.gaia.common.exception.NotFoundException();
        }
        addressDao.remove(addressModel);
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

    public AddressModel addAddressFromTableA(Long tableA_Id, Address address) {
        TableAModel tableAModel = tableADao.idEquals(tableA_Id).querySingle();
        if (tableAModel == null) {
            error("TableA not found with id: " + tableA_Id);
            throw new NotFoundException();
        }
        address.setAid(tableA_Id);
        AddressModel addressModel = mapper.map(address, AddressModel.class);
        addressDao.save(addressModel);

        if (addressDao.idEquals(addressModel.getId()).querySingle() == null) {
            error("TableA not found with id: " + addressModel.getId());
            throw new NotFoundException();
        }
        return addressModel;
    }

    public TableA upDataTableA(TableA tableA) {

        if (tableADao.idEquals(tableA.getId()).querySingle() == null) {
            error("TableA not found with id: " + tableA.getId());
            throw new NotFoundException();
        }
        return mapper.map(tableADao.update(mapper.map(tableA, TableAModel.class)), TableA.class);
    }

    public Address upDataAddress(Address address) {

        if (addressDao.idEquals(address.getId()).querySingle() == null) {
            error("TableA not found with id: " + address.getId());
            throw new NotFoundException();
        }
        return mapper.map(addressDao.update(mapper.map(address, AddressModel.class)), Address.class);
    }
}
