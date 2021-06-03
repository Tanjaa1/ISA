package rs.ac.uns.ftn.informatika.jpa.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import rs.ac.uns.ftn.informatika.jpa.dto.ActionOrPromotionsDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PatientDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class PatientServiceTest{
    
    @MockBean
    private IPatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
	public void testPatientsByUsernameOrSurname() 
    {
        List<Patient> patients=new ArrayList<Patient>();
        Patient p1=new Patient();
        p1.setName("Tanja");
        p1.setSurname("Drcelic");
        Patient p2=new Patient();
        p2.setName("Mila");
        p2.setSurname("Enic");
        Collections.addAll(patients,p1,p2);
        
        when(patientRepository.findPatientsByDermatologist(1L)).thenReturn(patients);
        
        List<PatientDTO> patientsd=patientService.findPatientsByNameAndSurnameDermatologist(1L, "anja", "d");
        assertThat(patientsd).hasSize(1);
    }


    @Test
	public void testNotFindPatientsByUsernameOrSurname() 
    {
        List<Patient> patients=new ArrayList<Patient>();
        Patient p1=new Patient();
        p1.setName("Tanja");
        p1.setSurname("Drcelic");
        Patient p2=new Patient();
        p2.setName("Mila");
        p2.setSurname("Enic");
        Collections.addAll(patients,p1,p2);
        
        when(patientRepository.findPatientsByDermatologist(1L)).thenReturn(patients);
        
        List<PatientDTO> patientsd=patientService.findPatientsByNameAndSurnameDermatologist(1L, "anja", "g");
        assertThat(patientsd).hasSize(0);
    }
    
}

