package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IEPrescriptionRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class EPrescriptionService implements IEPrescriptionService {

    @Autowired
    private IEPrescriptionRepository ePrescriotionRepository;

    @Autowired
    private IPharmacyService pharmacyService;

    @Override
    public EPrescription findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EPrescription save(EPrescriptionDTO ePrescriptionDTO) throws Exception 
    {
        EPrescription ePrescription=new EPrescription();
        ePrescription.setMedicine(ePrescriptionDTO.getMedicine());
        ePrescription.setTherapyDuration(ePrescriptionDTO.getTherapyDuration());
        ePrescription.setIssuingDate(new Date());
        return ePrescriotionRepository.save(ePrescription);
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
