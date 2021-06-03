package rs.ac.uns.ftn.informatika.jpa.unit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.enums.OfferStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.repository.SupplierOfferRepoitory;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierOfferRepository;
import rs.ac.uns.ftn.informatika.jpa.service.SupplierOfferService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class SupplierOfferServiceTest {
      
    @MockBean
    private ISupplierOfferRepository supplierOfferRepository;

    @Autowired
    private SupplierOfferService supplierOfferService;

    @Test
	public void isOfferGiven() 
    {
        Order order=new Order();
        order.setId(25L);
       Supplier supplier=new Supplier(1L,"email", "password", "name", "surname", "address", "city", "country", "05253259", "description");
       SupplierOffer so1=new SupplierOffer(1L,new Order(), supplier, OfferStatus.Waiting_for_answer, 2545.00, "date");
       
       List<SupplierOffer> result=new ArrayList<SupplierOffer>();
        result.add(so1);
        when(supplierOfferRepository.findAll()).thenReturn(result);
        Boolean rt=supplierOfferService.isOfferGivenToOrder(supplier.getId(),order.getId());
        assertFalse(rt);
    }


}
