package rs.ac.uns.ftn.informatika.jpa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.CouncelingDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.ICounselingService;

@Service
public class CounselingService implements ICounselingService {

    @Autowired
	private ICounselingRpository counselingRepository;

	public List<Counseling> findPastCounselingsByPatientId(Long id) {
        List<Counseling> patientCounselings = new ArrayList<>();
        List<Counseling> counselings = counselingRepository.findAll();
        for (Counseling counseling : counselings) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now());
           if(id == counseling.getPatient().getId() && counseling.getIsDone() && i < 0){
                patientCounselings.add(counseling);
            }
       }
       return patientCounselings;
	}

    public List<Counseling> findFutureCounselingsByPatientId(Long id) {
        List<Counseling> patientCounselings = new ArrayList<>();
        List<Counseling> counselings = counselingRepository.findAll();
        for (Counseling counseling : counselings) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now());
           if(id == counseling.getPatient().getId() && i > 0){
                patientCounselings.add(counseling);
            }
       }
       return patientCounselings;
	}

	public Counseling update(long id)throws Exception 
    {
            Counseling e=counselingRepository.getOne(id);
            e.setIsDone(true);
            return counselingRepository.save(e);
	}

	public List<CouncelingDTO> getAllCounselings() {
        List<Counseling> counselings=counselingRepository.findAll();
		List<CouncelingDTO> councelingDTOs = new ArrayList<CouncelingDTO>();
        for (Counseling counseling : counselings) {
            councelingDTOs.add(new CouncelingDTO(counseling));
        }
           return councelingDTOs;
	}

	public Counseling updateCounseling(Counseling counseling) {
        int i = counseling.getStartTime().compareTo(LocalDateTime.now().plusDays(1));
		Counseling e=counselingRepository.getOne(counseling.getId());
        if(i > 0){
            e.setIsCanceled(true);
        }
            return counselingRepository.save(e);
    }
	public Set<PharmacistDTO> getPharmacisstByPatientId(Long patientId) {
		Set<PharmacistDTO> pharmacistDTOs= new HashSet();
		List<CouncelingDTO> councelingDTOs=getAllCounselings();

		for (CouncelingDTO councelingDTO : councelingDTOs) {
			if(patientId==councelingDTO.getPatient().getId()){
				pharmacistDTOs.add(councelingDTO.getPharmacist());
			}
		}	
        if(pharmacistDTOs.isEmpty()) return null;
        else return pharmacistDTOs;
	}

	public Set<PharmacyDTO> getPharmaciesByPatientId(Long patientId) {
        Set<PharmacyDTO> pharmaciesDTOs= new HashSet();
		List<CouncelingDTO> councelingDTOs=getAllCounselings();

		for (CouncelingDTO councelingDTO : councelingDTOs) {
			if(patientId==councelingDTO.getPatient().getId()){
				pharmaciesDTOs.add(councelingDTO.getPharmacy());
			}
		}	
        return pharmaciesDTOs;
	}


}
