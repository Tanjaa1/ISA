package rs.ac.uns.ftn.informatika.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import rs.ac.uns.ftn.informatika.jpa.integration.CounselingControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.EPrescriptionControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.ExaminationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.ReservationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.VacationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.unit.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PatientServiceTest.class,
	ExaminationServiceTest.class,
	CounselingServiceTest.class,
	ReservationServiceTest.class,

	ExaminationControlerTest.class,
	ReservationControlerTest.class,
	VacationControlerTest.class,
	EPrescriptionControlerTest.class,
	CounselingControlerTest.class
	
})
public class AllTests {
    
}
