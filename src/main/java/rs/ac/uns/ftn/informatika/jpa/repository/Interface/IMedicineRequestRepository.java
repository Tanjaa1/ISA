package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineRequest;

public interface IMedicineRequestRepository extends JpaRepository<MedicineRequest, Long> {
	
	@Query("SELECT distinct mr FROM MedicineRequest mr,Pharmacy p WHERE mr.Pharmacy = p.Id AND p.id = ?1 AND mr.Solved = false")
    public List<MedicineRequest> getRequestsByPharmacyId(Long pID);

}