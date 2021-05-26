package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IEPrescriptionRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
@Transactional(readOnly = true)
public class EPrescriptionService implements IEPrescriptionService {

    @Autowired
    private IEPrescriptionRepository ePrescriotionRepository;

    @Autowired
    private IPharmacyService pharmacyService;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IMedicinePriceAndQuantity medicinePriceAndQUantityRepository;
    @Override
    public EPrescription findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRES_NEW)
    public EPrescription save(EPrescription ePrescriptionDTO,Long id) throws Exception 
    {
        EPrescription ePrescription=new EPrescription();
        ePrescription.setMedicine(ePrescriptionDTO.getMedicine());
        ePrescription.setTherapyDuration(ePrescriptionDTO.getTherapyDuration());
        ePrescription.setIssuingDate(new Date());
        ePrescription.setMedicine(medicinePriceAndQUantityRepository.findById(ePrescription.getMedicine().getId()).get());
        EPrescription ep= ePrescriotionRepository.save(ePrescription);
        Patient patient= patientRepository.findById(id).get();
        try{
             patient.getEPrescriptions().add(ep);
             patientRepository.save(patient);
             pharmacyService.updateQuantity(ePrescriptionDTO.getPharmacy().getId(),ePrescription.getMedicine().getMedicine());
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

	public List<MedicinePriceAndQuantityDTO> findMedicineByPharmacy(Long id) 
    {
        List<MedicinePriceAndQuantityDTO> priceAndQuantityDTOs=new ArrayList<MedicinePriceAndQuantityDTO>();
        for (MedicinePriceAndQuantity m : pharmacyService.getPharmacyMedicines(id))
            priceAndQuantityDTOs.add(new MedicinePriceAndQuantityDTO(m));
        return priceAndQuantityDTOs;
	}
    
}
