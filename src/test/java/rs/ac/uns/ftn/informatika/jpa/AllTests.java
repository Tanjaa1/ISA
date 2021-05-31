package rs.ac.uns.ftn.informatika.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import rs.ac.uns.ftn.informatika.jpa.unit.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PatientServiceTest.class,
	ExaminationServiceTest.class,
	CounselingServiceTest.class,
	ReservationServiceTest.class
})
public class AllTests {
    
}
