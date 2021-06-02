package rs.ac.uns.ftn.informatika.jpa.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.service.CounselingService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CounselingServiceTest {
    
    @MockBean
    private ICounselingRpository counselingRpository;

    @Autowired
    private CounselingService counselingService;

    @Test
	public void testFindFreeCounselingByPharmacist() 
    {
        List<Counseling> counselings=new ArrayList<Counseling>();
        Counseling e1=new Counseling();
        e1.setId(1L);
        e1.setStartTime(LocalDateTime.now().plusDays(1));
        Counseling e2=new Counseling();
        e2.setId(2L);
        e2.setStartTime(LocalDateTime.now().minusDays(1));
        Collections.addAll(counselings, e1,e2);
        when(counselingRpository.getFreeCounselingByPharmacist(1L)).thenReturn(counselings); 
        List<CouncelingDTO> counselingDTO=counselingService.getFreeCounselingByPharmacist(1L);
        assertThat(counselingDTO).hasSize(1);
    }

}

