package com.thoughtworks.gaia.address.service;

import com.thoughtworks.gaia.common.Loggable;
import com.thoughtworks.gaia.address.AddressMapper;
import com.thoughtworks.gaia.address.dao.AddressDao;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.address.entity.Address;
import com.thoughtworks.gaia.address.model.AddressModel;
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
        AddressModel addressModel =mapper.map(address, AddressModel.class);
        addressDao.save(addressModel);

        if (addressDao.idEquals(addressModel.getId()).querySingle() == null) {
            error("Address not found with id: " + addressModel.getId());
            throw new NotFoundException();
        }

        return addressModel;
    }
}
