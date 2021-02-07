package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IEPrescriptionRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPatientService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class EPrescriptionService implements IEPrescriptionService {

    @Autowired
    private IEPrescriptionRepository ePrescriotionRepository;

    @Autowired
    private IPharmacyService pharmacyService;

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public EPrescription findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EPrescription save(EPrescription ePrescriptionDTO,Long id) throws Exception 
    {
        EPrescription ePrescription=new EPrescription();
        ePrescription.setMedicine(ePrescriptionDTO.getMedicine());
        ePrescription.setTherapyDuration(ePrescriptionDTO.getTherapyDuration());
        ePrescription.setIssuingDate(new Date());
        EPrescription ep= ePrescriotionRepository.save(ePrescription);
        Patient patient= patientRepository.getOne(id);
        try{
             patient.getEPrescriptions().add(ep);
             patientRepository.save(patient);
        }catch(Exception ex){
            throw new Exception("Error.");
        }
        return ep;
    }

    @Override
    public List<EPrescription> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

	public Set<MedicinePriceAndQuantity> findMedicineByPharmacy(Long id) 
    {
        return pharmacyService.getPharmacyMedicines(id);
	}
    
}
