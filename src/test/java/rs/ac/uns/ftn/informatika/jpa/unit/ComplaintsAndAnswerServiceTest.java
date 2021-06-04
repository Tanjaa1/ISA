package rs.ac.uns.ftn.informatika.jpa.unit;
import java.util.ArrayList;
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

import ch.qos.logback.core.joran.action.Action;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.LoyaltyCategories;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penaltys;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintRepository;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintAnswerService;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")

public class ComplaintsAndAnswerServiceTest {
    @MockBean
    private IComplaintRepository complaintRepository;

    @Autowired
    private ComplaintService complaintService;
    @Test
	public void getAllComplaintsAnsweredTest() {
        List<Complaint> complaints=new ArrayList<Complaint>();
        String da1="amooksicilin";
        List<String>drugList=new ArrayList<>();
        drugList.add(da1);
        Penaltys pe=new Penaltys();
        Set<Penaltys> ps=new HashSet<>();
        ps.add(pe);

        Patient patient1=new Patient(1L,"email","password","Nika","Ninkovic","address","city",
        "country","29652152","desc",true,true,"username",drugList,25,ps,LoyaltyCategories.Gold, new HashSet<Complaint>(),
        new HashSet<Counseling>(),new HashSet<EPrescription>(),new HashSet<>(),new HashSet<>());

        Complaint c1=new Complaint(1L,"Doktor Mika Mikic kasnio na pregled pola sata.","doktor Mika Mikic",patient1,true);
        Complaint c2=new Complaint(2L,"Farmaceut Jankovic bio veoma neljubazan","farmaceut Janko Jankovic",patient1,false);
        Complaint c3=new Complaint(3L,"Dermatolog Perovic bio jako prijatan,zasluzuje povisicu","dermatolog Per Perovic",patient1,true);
        complaints.add(c1);
        complaints.add(c2);
        complaints.add(c3);
        
        when(complaintRepository.findAll()).thenReturn((ArrayList<Complaint>) complaints);
        
        List<ComplaintDTO> complaintsResuList=complaintService.getAllComplaintsAnswered();
        assertThat(complaintsResuList).hasSize(2);
    }
    @Test
	public void getAllComplaintsNotAnsweredTest() {
        List<Complaint> complaints=new ArrayList<Complaint>();
        String da1="amooksicilin";
        List<String>drugList=new ArrayList<>();
        drugList.add(da1);
        Penaltys pe=new Penaltys();
        Set<Penaltys> ps=new HashSet<>();
        ps.add(pe);

        Patient patient1=new Patient(1L,"email","password","Nika","Ninkovic","address","city",
        "country","29652152","desc",true,true,"username",drugList,25,ps,LoyaltyCategories.Gold, new HashSet<Complaint>(),
        new HashSet<Counseling>(),new HashSet<EPrescription>(),new HashSet<>(),new HashSet<>());

        Complaint c1=new Complaint(1L,"Doktor Mika Mikic kasnio na pregled pola sata.","doktor Mika Mikic",patient1,true);
        Complaint c2=new Complaint(2L,"Farmaceut Jankovic bio veoma neljubazan","farmaceut Janko Jankovic",patient1,false);
        Complaint c3=new Complaint(3L,"Dermatolog Perovic bio jako prijatan,zasluzuje povisicu","dermatolog Per Perovic",patient1,true);
        complaints.add(c1);
        complaints.add(c2);
        complaints.add(c3);
        
        when(complaintRepository.findAll()).thenReturn((ArrayList<Complaint>) complaints);
        
        List<ComplaintDTO> complaintsResuList=complaintService.getAllComplaintsNotAnswered();
        assertThat(complaintsResuList).hasSize(1);
    }

}
