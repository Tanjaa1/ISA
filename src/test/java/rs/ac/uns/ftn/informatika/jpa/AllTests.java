package rs.ac.uns.ftn.informatika.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import rs.ac.uns.ftn.informatika.jpa.integration.CounselingControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.EPrescriptionControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.ExaminationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.MedicineServiseTest;
import rs.ac.uns.ftn.informatika.jpa.integration.ReservationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.integration.VacationControlerTest;
import rs.ac.uns.ftn.informatika.jpa.unit.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PatientServiceTest.class,
	ExaminationServiceTest.class,
	CounselingServiceTest.class,
	ReservationServiceTest.class,

	ComplaintsAndAnswerServiceTest.class,
	UserServiceTest.class,
	SupplierOfferServiceTest.class,
	MedicineServiseTest.class,
	UserServiceTest.class,

	ExaminationControlerTest.class,
	ReservationControlerTest.class,
	VacationControlerTest.class,
	EPrescriptionControlerTest.class,
	CounselingControlerTest.class
	
})
public class AllTests {
    
}
