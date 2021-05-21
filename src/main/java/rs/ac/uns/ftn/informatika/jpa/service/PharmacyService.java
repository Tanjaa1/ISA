package rs.ac.uns.ftn.informatika.jpa.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPriceAndQuantityRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyAdminService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class PharmacyService implements IPharmacyService {

 
    @Autowired
    private IPharmacyRepository pharmacyRepository;
    @Autowired
    private IMedicineRepository medicineRepository;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IPriceAndQuantityRepository priceAndQuantityRepository;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IMarkRepository markRepository;
    @Autowired
    private MedicineService madicineService;
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private EmailService emailService;
    private Logger logger = LoggerFactory.getLogger(ResrvationService.class);

    



    
    public List<Pharmacy> findAll(){
        return pharmacyRepository.findAll();
    }

    public List<Pharmacy> findPharmacyByNameAndPlace(String name,String place) {	
		List<Pharmacy> pharmaciesFind = new ArrayList<Pharmacy>();
        List<Pharmacy> pharmacies = findAll();
		for (Pharmacy pharmacy : pharmacies) {
			if(pharmacy.getName().toUpperCase().contains(name.toUpperCase().trim()) && isContainPlace(pharmacy,place))
				pharmaciesFind.add(pharmacy);
		}
		return pharmaciesFind;
	}

    public Boolean isContainPlace(Pharmacy pharmacy, String place){
        String[] p = pharmacy.getAddress().split(",");
        if(p[1].toUpperCase().contains(place.toUpperCase().trim())){
            return true;
        }else{
            return false;
        }
    } 

    public ResponseEntity<Pharmacy> save(Pharmacy pharmacy) throws Exception {
        pharmacy.setCounselingPrice(1000.00);
        pharmacyRepository.save(pharmacy);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    public List<Pharmacy> getAll() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
           return pharmacies;
   }
   public Pharmacy findOne(Long id) {
    Pharmacy pharmacy = pharmacyRepository.getOne(id);
       return pharmacy;
    }
    public Pharmacy findOneById(Long id) {
        Pharmacy pharmacy = pharmacyRepository.findById(id).get();
           return pharmacy;
        }

    public List<String> getAllPharmacyNames() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        List<String> resultList=new ArrayList<String>();
        for (Pharmacy s : pharmacies) {
            resultList.add(s.getName());
        }
        return resultList;
    }

    public Boolean isNameValid(String name) {
        List<String> names=getAllPharmacyNames();
        for (String s : names) {
            if(s.equals(name))
                return false;
        }
        return true;
    }
    

    
    public Set<MedicinePriceAndQuantity> getPharmacyMedicines(Long id) {
        return findOne(id).getPricelist();
    }

    public Pharmacy update(Pharmacy pharmacy){
        Pharmacy forUpdate = pharmacyRepository.getOne(pharmacy.getId());
        forUpdate.setId(pharmacy.getId());
        forUpdate.setMarks(pharmacy.getMarks());
        forUpdate.setName(pharmacy.getName());
        forUpdate.setPricelist(pharmacy.getPricelist());
        forUpdate.setAddress(pharmacy.getAddress());
        return pharmacyRepository.save(forUpdate);
    }


	public Pharmacy getByName(String name) {
        List<Pharmacy> pharmacies=findAll();
        Pharmacy result=new Pharmacy();
        for (Pharmacy s : pharmacies) {
            if(s.getName().equals(name)){
                result=s;
                return result;
            }
        }
        return null;
	}

    public Boolean subscribeUser(PharmacyDTO pharmacy,Long patientId) {
        Pharmacy p = pharmacyRepository.getById(pharmacy.getId());
        Set<Patient> su = p.getSubscribedUsers();
        for (Patient patient : su) {
            if(patient.getId().longValue() == patientId.longValue())
                return false;
        }
            su.add(patientRepository.getOne(patientId));
            p.setSubscribedUsers(su);
            pharmacyRepository.save(p);
            return true;
	}

    private Medicine findMedicine(String name){
        List<Medicine> medicines = medicineRepository.findAll();
        Medicine medicineFind = new Medicine();
		for (Medicine medicine : medicines) {
			if(medicine.getName().toUpperCase().contains(name.toUpperCase().trim()))
				medicineFind = medicine;
                break;
		}
        return medicineFind;
    }

	public List<PharmacyDTO> findPharmacyByMedicineName(String name) {
        
        List<MedicineDTO> medicineFind =madicineService.findAllSearchMedicine(name);
        List<PharmacyDTO> pharmacyList = new ArrayList<PharmacyDTO>();
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        for (Pharmacy pharmacy : pharmacies) {
            for (MedicinePriceAndQuantity medicine : pharmacy.getPricelist()) {
                for(MedicineDTO mddd : medicineFind){
                    if(medicine.getMedicine().getName().toUpperCase().trim().contains(mddd.getName().toUpperCase().trim()) && medicine.getQuantity()>0){
                        pharmacyList.add(new PharmacyDTO(pharmacy));
                        break;
                    }
                }
            }
        }

		return pharmacyList;
	}

    public List<PharmacyDTO> findPharmacyByMedicineNameAndQuantity(String name,Integer quantity) {
        
        List<MedicineDTO> medicineFind =madicineService.findAllSearchMedicine(name);
        List<PharmacyDTO> pharmacyList = new ArrayList<PharmacyDTO>();
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        for (Pharmacy pharmacy : pharmacies) {
            for (MedicinePriceAndQuantity medicine : pharmacy.getPricelist()) {
                for(MedicineDTO mddd : medicineFind){
                    if(medicine.getMedicine().getName().toUpperCase().trim().contains(mddd.getName().toUpperCase().trim()) && medicine.getQuantity()>=quantity){
                        pharmacyList.add(new PharmacyDTO(pharmacy));
                        break;
                    }
                }
            }
        }
        return pharmacyList;

    }

        public List<PharmacyDTO> findPharmacyBzListMedicines(Map<String,Integer> mapOfMedicines) {
       
            Set<MedicineDTO> medicineFindSet =new HashSet();
            for (String name : mapOfMedicines.keySet()) {
                medicineFindSet.add(new MedicineDTO(findMedicine(name)));
        }
            List<PharmacyDTO> pharmacyList = new ArrayList<PharmacyDTO>();
            List<Pharmacy> pharmacies = pharmacyRepository.findAll();
            for (Pharmacy pharmacy : pharmacies) {
                for (MedicinePriceAndQuantity medicine : pharmacy.getPricelist()) {
                    for (Map.Entry<String, Integer> entry1 : mapOfMedicines.entrySet()) {
                        if(medicine.getMedicine().getName().toUpperCase().trim().contains(entry1.getKey().toUpperCase().trim()) &&
                         medicine.getQuantity()>=entry1.getValue()){
                            pharmacyList.add(new PharmacyDTO(pharmacy));
                        }else{
                            continue;
                        }
                    }
                }
            }

		return pharmacyList;
	}

	public Pharmacy updateQuantity(Long id,Medicine medicine) {
        int quantity=100;
        Pharmacy pharmacy=pharmacyRepository.getOne(id);
        for (MedicinePriceAndQuantity m : pharmacy.getPricelist()) {
            if(m.getMedicine().getId()==medicine.getId()){
                m.setQuantity(m.getQuantity()-1);
                quantity=m.getQuantity();
                priceAndQuantityRepository.save(m);
                break;
            }
        }
        Pharmacy p=update(pharmacy);
            try{
                if(quantity<2)
                    pharmacyAdminService.sendingMail(pharmacy.getName(), medicine);
            }catch(Exception e){
            }
            finally{
                return p;
            }
        }
	
	 public List<PharmacyDTO> getPharmacies(Long id){
	        List<PharmacyDTO> pharmacies = convert(pharmacyRepository.getPharmaciesFromCounseling(id));
	        List<PharmacyDTO> pharmacies2 = convert(pharmacyRepository.getPharmaciesFromExamination(id));
	        List<PharmacyDTO> pharmacies3 = convert(pharmacyRepository.getPharmaciesFromReservation(id));
	        Patient patient = patientRepository.getOne(id);
	        List<PharmacyDTO> pharmacyDTOs = compareLists(pharmacies,pharmacies2);
	        pharmacyDTOs = compareLists(pharmacyDTOs, pharmacies3);
	        pharmacyDTOs = compareListsFromPatient(pharmacyDTOs, patient);
	        return pharmacyDTOs;
	        //return convert(pharmacyDTOs);
	    }

	    private List<PharmacyDTO> compareListsFromPatient(List<PharmacyDTO> pharmacyDTOs, Patient patient) {
	        List<PharmacyDTO> p = new ArrayList<>(); 
	        p.addAll(pharmacyDTOs);
	        for (EPrescription ePrescription : patient.getEPrescriptions()) {
	            boolean pp = false;
	            for (PharmacyDTO pharmacy : pharmacyDTOs) {
	                if(pharmacy.getId() == ePrescription.getPharmacy().getId())
	                    pp = true;
	            }
	            if(!pp)
	                p.add(new PharmacyDTO(ePrescription.getPharmacy()));
	        }
	        return p;
	    }

	    private List<PharmacyDTO> compareLists(List<PharmacyDTO> pharmacies, List<PharmacyDTO> pharmacies2) {
	        List<PharmacyDTO> p = new ArrayList<>();
	        p.addAll(pharmacies2);
	        for (PharmacyDTO pharmacy : pharmacies) {
	            boolean pp = false;
	             for (PharmacyDTO pharmacy2 : pharmacies2) {
	                 if(pharmacy.getId() == pharmacy2.getId()){
	                     pp = true;
	                     break;
	                 }
	             }
	             if(!pp)
	                p.add(pharmacy);
	        }
	        return p;
	    }

	    private List<PharmacyDTO> convert(List<Pharmacy> pharmacies) {
	        List<PharmacyDTO> pharmacyDTOs = new ArrayList<PharmacyDTO>();
	        for(Pharmacy pharmacy : pharmacies){
	            pharmacyDTOs.add(new PharmacyDTO(pharmacy));
	        }
	        return pharmacyDTOs;
	    }

		public PharmacyDTO addMark(Pharmacy pharmacy, Integer medicinesMark, Long id) {
			Pharmacy pharmacy2 = pharmacyRepository.getOne(pharmacy.getId());
			Patient patient = patientRepository.getOne(id);
			boolean i = false;
			for (Markk mark : pharmacy2.getMarks()) {
				if(mark.getPatient().getId() == patient.getId()){
					i = true;
					mark.setMarks(medicinesMark);
					//medicine2.setMarks(marks);
					break;
				}
			}
			if(!i){
				Set<Markk> m = pharmacy2.getMarks();
				Markk mark = new Markk(medicinesMark, patient);
				m.add(mark);
				markRepository.save(mark);
				pharmacy2.setMarks(m);
			}
			pharmacyRepository.save(pharmacy2);
			return new PharmacyDTO(pharmacy2);
		}

        public List<MedicinePriceAndQuantityDTO> getPharmaciesPriceLists() {
            Set<MedicinePriceAndQuantity> resultList=new HashSet();
                        List<Pharmacy> pharmaciesList=findAll();
            for (Pharmacy pharmacyDTO : pharmaciesList) {
                resultList.addAll(pharmacyDTO.getPricelist());
            }
           List<MedicinePriceAndQuantityDTO>newSet=new ArrayList();
           for (MedicinePriceAndQuantity medicinePriceAndQuantityDTO : resultList) {
               newSet.add(new MedicinePriceAndQuantityDTO(medicinePriceAndQuantityDTO));
           }
           return newSet;
        }

        public PharmacyDTO getPharmacyByPriceListId(Long id) {
            List<MedicinePriceAndQuantityDTO> pharmaciesList=getPharmaciesPriceLists();
            MedicinePriceAndQuantityDTO pp=new MedicinePriceAndQuantityDTO();
            for (MedicinePriceAndQuantityDTO medicinePriceAndQuantityDTO : pharmaciesList) {
                if(medicinePriceAndQuantityDTO.getId()==id){
                    pp=medicinePriceAndQuantityDTO;
                }
            }
            MedicinePriceAndQuantity mk=new MedicinePriceAndQuantity(pp);
            Pharmacy resultPharmacy=new Pharmacy();
            List<Pharmacy> pList=findAll();
            for (Pharmacy m : pList) {
                for (MedicinePriceAndQuantity pharmacy : m.getPricelist()) {
                    if( pharmacy.getId().equals(mk.getId())){
                        resultPharmacy=m;
                    }
                }
            }
            return new PharmacyDTO(resultPharmacy);
        }
        private void emailSender(Patient patient) {
            try {
                String subject = "Patient " + patient.getFullName();
                String text = "Dear " + patient.getFullName()
                        + ",\n We would like to inform you that you have successfully purchased drugs from ePrescription";
                emailService.sendNotificaitionAsync(patient.getEmail(), subject, text);
            } catch (Exception e) {
                logger.info("Error sending email: " + e.getMessage());
            }
        }
        
            public PharmacyDTO changePharmacySupplies(Long id,String path,Long patientId) throws Exception {
                String ePrescriptionContent=madicineService.uploadQR(path);    
                String [] partsMedicineAndQuantity=ePrescriptionContent.split(",");
                Map<String,Integer> qrMedicines=new HashMap<>();
                Pharmacy pharmacy=findOneById(id);
         
                for (int i=0;i<partsMedicineAndQuantity.length;i++) {
                    String nameMedicine=partsMedicineAndQuantity[i].split("-")[0];
                    String quantityMedicine=partsMedicineAndQuantity[i].split("-")[1];
                    qrMedicines.put(nameMedicine.trim().toLowerCase(), Integer.valueOf(quantityMedicine));
                }
                Integer bonusPoints=0;
                for (MedicinePriceAndQuantity m : pharmacy.getPricelist()) {
                    Integer quantity=m.getQuantity();
                    for (Map.Entry<String, Integer> entry1 : qrMedicines.entrySet()) {
                        if(m.getMedicine().getName().trim().toLowerCase().equals(entry1.getKey())){
                            m.setQuantity(quantity-entry1.getValue());
                            bonusPoints+=m.getMedicine().getPoints();
                            priceAndQuantityRepository.save(m);
                            break;
                        }
                }
            }
            
                Patient patient =patientRepository.findById(patientId).get();
                patient.setPoints(patient.getPoints()+bonusPoints);
                patientService.update(patient);
                Pharmacy p=update(pharmacy);
                emailSender(patient);
                return new PharmacyDTO(p);
        }
        
            
}
