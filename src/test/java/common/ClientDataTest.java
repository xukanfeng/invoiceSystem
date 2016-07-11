package common;

import com.cane.model.ClientDataEntity;
import com.cane.repository.ClientDataDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xu_kanfeng on 16/1/23.
 */
public class ClientDataTest extends AbstractTest{
//    @Autowired
//    ClientRepository clientRepository;
//
//    @Autowired
//    UserRepository userRepository;

    @Autowired
    ClientDataDao clientDataDao;

    @Test
    public void clientTest(){
        ClientDataEntity client = clientDataDao.getClientDataByTaxpayerId("");
        client.setAccountName("");

        ClientDataEntity newClient = clientDataDao.getClientDataByTaxpayerId("11111111111");
        newClient.getBankName();
    }
}
