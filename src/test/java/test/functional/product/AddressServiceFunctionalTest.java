package test.functional.product;

import com.thoughtworks.gaia.GaiaApplication;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import com.thoughtworks.gaia.common.exception.NotFoundException;
import com.thoughtworks.gaia.tableA.AddressMapper;
import com.thoughtworks.gaia.tableA.dao.AddressDao;
import com.thoughtworks.gaia.tableA.dao.TableADao;
import com.thoughtworks.gaia.tableA.entity.Address;
import com.thoughtworks.gaia.tableA.model.AddressModel;
import com.thoughtworks.gaia.tableA.service.TableAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by haoyuze on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GaiaApplication.class)
@Rollback
@Transactional
@ActiveProfiles({EnvProfile.TEST})
public class AddressServiceFunctionalTest {
    @Autowired
    private AddressMapper mapper;

    @Autowired
    private TableAService tableAService;

    @Autowired
    private TableADao tableADao;

    @Autowired
    private AddressDao addressDao;

    @Test
    public void should_get_Address_with_tableA_id_and_address_id() throws Exception {
        AddressModel addressModel = new AddressModel();
        addressModel.setAddress("hei");
        addressModel.setAid(4L);
        addressDao.save(addressModel);

//        Address address = tableAService.getAddressFromTableA();

//        assertThat(8L==address.getId());
    }
    @Test(expected = NullPointerException.class)
    public void should_throw_exception_when_not_found() {
        tableAService.getAddressFromTableA(1L,1L);
    }

}
