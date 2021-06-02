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

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IExaminationRpository;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ExaminationServiceTest {
    
     
    @MockBean
    private IExaminationRpository examinatonRepository;

    @Autowired
    private ExaminationService examinationService;

    @Test
	public void testFindFreeExaminationByDermatologist() 
    {
        List<Examination> examinations=new ArrayList<Examination>();
        Examination e1=new Examination();
        e1.setId(1L);
        e1.setStartTime(LocalDateTime.now().plusDays(1));
        e1.setEndTime(LocalDateTime.now().plusDays(1));
        Examination e2=new Examination();
        e2.setId(2L);
        e2.setStartTime(LocalDateTime.now().minusDays(1));
        e2.setEndTime(LocalDateTime.now().minusDays(1));
        Collections.addAll(examinations, e1,e2);
        when(examinatonRepository.getFreeExaminationByDermatologist(1L)).thenReturn(examinations); 
        List<ExaminationDTO> examinationsDTO=examinationService.getFreeExaminationByDermatologist(1L);
        assertThat(examinationsDTO).hasSize(1);
    }

}
