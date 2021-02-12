package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Complaint;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IComplaintRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

    @Autowired
	private IComplaintRepository complaintRepository;

    @Autowired
	private ExaminationService examinationService;

    @Autowired
	private PatientService patientService;

    @Autowired
	private CounselingService counselingService;


    @Override
    public Complaint findOne(Long id) {
        return complaintRepository.getOne(id);
   }

    @Override
    public Complaint update(Complaint complaint) throws Exception {
        
        Complaint complaint1 = findOne(complaint.getId());
        if (complaint1 == null)
            throw new Exception("Trazeni entitet nije pronadjen.");
            complaint1.setId(complaint.getId());
            complaint1.setPatient(complaint.getPatient());
            complaint1.setText(complaint.getText());
            complaint1.setSubject(complaint.getSubject());
        return complaintRepository.save(complaint1);
    }

    @Override
    public List<ComplaintDTO> getAllComplaintsAnswered() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<Complaint> complaints2=new ArrayList<>();
        for (Complaint complaint : complaints) {
            if(complaint.getIsAnswered())
            complaints2.add(complaint);
        }
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints2)
            returnValue.add(complaintDTO.toDTO(complaint));
        if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

    @Override
    public List<ComplaintDTO> getAllComplaintsNotAnswered() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<Complaint> complaints2=new ArrayList<>();
        for (Complaint complaint : complaints) {
            if(!complaint.getIsAnswered())
            complaints2.add(complaint);
        }
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints2)
            returnValue.add(complaintDTO.toDTO(complaint));
            if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

    @Override
    public ComplaintDTO save(Complaint complaint) throws Exception {
        Patient patient =patientService.findById(complaint.getId());
        complaint.setPatient(patient);
        ComplaintDTO complaint2=new ComplaintDTO(complaintRepository.save(complaint));
        return complaint2;
    }

	public ComplaintDTO getById(Long id) {
        ComplaintDTO complaintDTO=new ComplaintDTO(complaintRepository.getOne(id));
        return complaintDTO;
    }

	public List<ComplaintDTO> getAllComplaints() {
        ComplaintDTO complaintDTO = new ComplaintDTO();
        List<Complaint> complaints =complaintRepository.findAll();
        List<ComplaintDTO> returnValue = new ArrayList<ComplaintDTO>();
        for (Complaint complaint : complaints)
            returnValue.add(complaintDTO.toDTO(complaint));
        if (returnValue.isEmpty())
            return null;
        else  return returnValue;
    }

	public Set<String> getAllSubjects(Long id) {
        Set<PharmacyDTO> pharmaciesSubject=examinationService.getPharmaciesByPatientId(id);
        Set<String> resultList=new HashSet<>();
        if(!pharmaciesSubject.isEmpty())
        {
            for (PharmacyDTO p : pharmaciesSubject) {
                resultList.add("pharmacy " + p.getName());
            }
        }
       
        Set<DermatologistDTO> dermatologistSubject=examinationService.getDermatologistByPatientId(id);
        if(!dermatologistSubject.isEmpty())
        {
            for (DermatologistDTO d : dermatologistSubject) {
                resultList.add("dermatologist " + d.getName() + " " + d.getSurname());
            }
        }

        Set<PharmacistDTO> pharmacistSubject=counselingService.getPharmacisstByPatientId(id);
        if(!pharmacistSubject.isEmpty()){
            for (PharmacistDTO d1 : pharmacistSubject) {
                resultList.add("pharmacist " + d1.getName()+ " "  + d1.getSurname());
            }
        }

      
        Set<PharmacyDTO> pharmacies2Subject=counselingService.getPharmaciesByPatientId(id);
        if(!pharmacies2Subject.isEmpty())
        {
            for (PharmacyDTO p2 : pharmacies2Subject) {
                resultList.add("pharmacy " + p2.getName());
            }
        }

        Set<PharmacyDTO> pharmacies3Subject=patientService.getEPharmaciesByPatientIdAndPrescriptions(id);
        if(!pharmacies2Subject.isEmpty())
        {
            for (PharmacyDTO p3 : pharmacies3Subject) {
                resultList.add("pharmacy " + p3.getName());
            }
        }
      
        return resultList;

    }

}
