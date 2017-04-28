package com.thoughtworks.gaia.tableA.service;

import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.tableA.AddressMapper;
import com.thoughtworks.gaia.tableA.dao.AddressDao;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.tableA.entity.Address;
import com.thoughtworks.gaia.tableA.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by haoyuze on 2017/4/25.
 */
@Component
@Transactional
public class AddressService implements Loggable {
    @Autowired
    private AddressMapper mapper;

    @Autowired
    private AddressDao addressDao;

    public AddressModel addAddress(Address address) {
        AddressModel addressModel = mapper.map(address, AddressModel.class);
        addressDao.save(addressModel);

        if (addressDao.idEquals(addressModel.getId()).querySingle() == null) {
            error("Address not found with id: " + addressModel.getId());
            throw new NotFoundException();
        }

        return addressModel;
    }

    public Address getAddress(Long address_id) {
        AddressModel addressModel = addressDao.idEquals(address_id).querySingle();
        if (addressModel == null) {
            error("TableA not found with id: " + address_id);
            throw new NotFoundException();
        }

        return mapper.map(addressModel, Address.class);
    }

    public Address upDataAddress(Address address) {

        if (addressDao.idEquals(address.getId()).querySingle() == null) {
            error("TableA not found with id: " + address.getId());
            throw new NotFoundException();
        }
        return mapper.map(addressDao.update(mapper.map(address, AddressModel.class)), Address.class);
    }


    public void deleteAddress(Long address_Id) {
        AddressModel addressModel = addressDao.idEquals(address_Id).querySingle();
        if (addressModel == null) {
            error("Product not found with id: " + address_Id);
            throw new com.thoughtworks.gaia.common.exception.NotFoundException();
        }

        addressDao.remove(addressModel);
    }
}
