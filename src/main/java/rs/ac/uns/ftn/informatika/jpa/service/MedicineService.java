package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineForSearch;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.repository.MedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;

@Service
public class MedicineService implements IMedicineService {

	@Autowired
	private IMedicineRepository medicineRepository;
	
	@Autowired
	private IPatientRepository patientRepository;

	@Autowired
	private IMarkRepository markRepository;

	@Autowired
	private PharmacyService pharmacyService;


	@Autowired
	private IPharmacyRepository pharmacyRepository;

	public Medicine findOne(Long id) {
		Medicine medicine = medicineRepository.getOne(id);
		return medicine;
	}

	public ResponseEntity<Medicine> save(Medicine medicine) throws Exception {
		Medicine resultMedicine = new Medicine();
		resultMedicine.setReplacement(medicine.getReplacement());
		resultMedicine.setCode(medicine.getCode());
		resultMedicine.setComposition(medicine.getComposition());
		// resultMedicine.setContraindications(medicine.getContraindications());
		resultMedicine.setDailyDose(medicine.getDailyDose());
		resultMedicine.setForm(medicine.getForm());
		resultMedicine.setManufacturer(medicine.getManufacturer());
		resultMedicine.setName(medicine.getName());
		resultMedicine.setNote(medicine.getNote());
		resultMedicine.setOnPrescription(medicine.getOnPrescription());
		resultMedicine.setType(medicine.getType());

		medicineRepository.save(medicine);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public List<String> getAllCodes() {
		List<Medicine> medicines = medicineRepository.findAll();
		List<String> resultList = new ArrayList<String>();
		for (Medicine s : medicines) {
			resultList.add(s.getCode());
		}
		return resultList;
	}

	public Boolean isUsernameValid(String code) {
		List<String> codes = getAllCodes();
		for (String s : codes) {
			if (s.equals(code))
				return false;
		}
		return true;
	}

	@Override
	public ArrayList<MedicineDTO> findAll() {
		List<Medicine> list=medicineRepository.findAll();
		ArrayList<MedicineDTO> resultList=new ArrayList();
		for (Medicine medicine : list) {
			resultList.add(new MedicineDTO(medicine));
		}
		return resultList;
	}
	public List<MedicineForSearch> findAllSearch(){
		ArrayList<Medicine> list=medicineRepository.findAll();
		List<MedicineForSearch> listR=new ArrayList<>();

		for(Medicine mdto : list){
			List<PharmacyDTO> pharmacys=pharmacyService.findPharmacyByMedicineName(mdto.getName());
			double result =  0;
	        int i = 0;
	        for (Markk m : mdto.getMarks()) {
	            result += m.getMarks();
	            i++;
	        }
			int Grade;
			if(i != 0){
	        	Grade = (int) Math.round(result / i);
			}else{
				Grade=0;
			}

			for(PharmacyDTO p : pharmacys){
				listR.add(new MedicineForSearch( mdto.getName(), mdto.getType().toString(),mdto.getComposition(), p.getName(),String.valueOf(Grade),"250",mdto.getOnPrescription().toString(),mdto.getForm().toString()));
			}

		}
		return listR;
	}

	public MedicineDTO findMedicine(String name) {
		List<Medicine> medicines = medicineRepository.findAll();
		MedicineDTO medicineFind = new MedicineDTO();
		for (Medicine medicine : medicines) {
			if(medicine.getName().toUpperCase().trim().contains(name.toUpperCase().trim()))
				medicineFind = new MedicineDTO(medicine);
            //    break;
		}
        return medicineFind;
	}
	

	public List<MedicineDTO> findAllSearchMedicine(String name) {
		List<Medicine> medicines = medicineRepository.findAll();
		List<MedicineDTO> medicineFind = new ArrayList<>();
		for (Medicine medicine : medicines) {
			if(medicine.getName().toUpperCase().trim().contains(name.toUpperCase().trim()))
				medicineFind.add(new MedicineDTO(medicine));
             
		}
        return medicineFind;
	}
	
	public List<MedicineDTO> getMedicinesAll(Long id){
		List<MedicineDTO> m = new ArrayList<MedicineDTO>();
		List<MedicineDTO> medicineDTOs = getMedicinesFromEprescriptions(id);
		List<MedicineDTO> medicines = getMedicines(id);
		m.addAll(medicines);
		for (MedicineDTO medicineDto : medicineDTOs) {
			boolean pp = false;
			for(MedicineDTO medicine : medicines){
				if(medicine.getId() == medicineDto.getId())
					pp = true;
			}
			if(!pp)
                m.add(medicineDto);
		}
		return m;
	}

	public List<MedicineDTO> getMedicines(Long id){
		List<MedicineDTO> medicineDTOs = new ArrayList<>();
		List<Medicine> medicines = medicineRepository.getMedicines(id);
		for (Medicine medicine : medicines) {
			medicineDTOs.add(new MedicineDTO(medicine));
		}
		
		return medicineDTOs;
	}

	public List<MedicineDTO> getMedicinesFromEprescriptions(Long id){
		Patient patient = patientRepository.getOne(id);
		List<MedicineDTO> medicineDTOs = new ArrayList<MedicineDTO>();
		List<Medicine> medicines = new ArrayList<Medicine>();
		for (EPrescription ePrescription : patient.getEPrescriptions()) {
			if(!medicines.contains(ePrescription.getMedicine().getMedicine()))
				medicines.add(ePrescription.getMedicine().getMedicine());
		}
		medicineDTOs = Convert(medicines,medicineDTOs);
		return medicineDTOs;
	}

	private List<MedicineDTO> Convert(List<Medicine> medicines, List<MedicineDTO> medicineDTOs) {
		for (Medicine medicine : medicines) {
			medicineDTOs.add(new MedicineDTO(medicine));
		}
		return medicineDTOs;
	}

	public MedicineDTO addMark(Medicine medicine, Integer medicinesMark, Long id) {
		Medicine medicine2 = medicineRepository.getOne(medicine.getId());
		Patient patient = patientRepository.getOne(id);
		boolean i = false;
		for (Markk mark : medicine2.getMarks()) {
			if(mark.getPatient().getId() == patient.getId()){
				i = true;
				mark.setMarks(medicinesMark);
				//medicine2.setMarks(marks);
				break;
			}
		}
		if(!i){
			Set<Markk> m = medicine2.getMarks();
			Markk mark = new Markk(medicinesMark, patient);
			m.add(mark);
			markRepository.save(mark);
			medicine2.setMarks(m);
		}
		medicineRepository.save(medicine2);
		return new MedicineDTO(medicine2);
	
	}

    public List<MedicineForSearch> getPharmacyForAvaliableMedicine(String medicineName) {
		List<MedicineDTO> ms=findAllSearchMedicine(medicineName);
		List<MedicineForSearch> result=new ArrayList<>();

		for(MedicineDTO mdto : ms){
			List<PharmacyDTO> pharmacys=pharmacyService.findPharmacyByMedicineName(mdto.getName());
			for(PharmacyDTO p : pharmacys){
				result.add(new MedicineForSearch( mdto.getName(), mdto.getType().toString(),mdto.getComposition(), p.getName(), mdto.getGrade().toString(),"250",mdto.getOnPrescription().toString(),mdto.getForm().toString()));
			}
		}
		return result;
	}

	public List<MedicineForSearch> filtrationMedicineByType(String medicineName, String type) {
		List<MedicineForSearch> medicineDTOs=getPharmacyForAvaliableMedicine(medicineName);
		List<MedicineForSearch> resultList=new ArrayList<>();
		
			for(MedicineForSearch m : medicineDTOs){
				if(m.getType().equals(type)){
					resultList.add(m);
				}
			}
		
		return resultList;
		
	}

    public List<MedicineForSearch> filtrationMedicineByForm(String medicineName, String form) {
		List<MedicineForSearch> medicineDTOs=getPharmacyForAvaliableMedicine(medicineName);
		List<MedicineForSearch> resultList=new ArrayList<>();
		
			for(MedicineForSearch m : medicineDTOs){
				if(m.getForm().equals(form)){
					resultList.add(m);
				}
			}
		
		return resultList;
	}

	public List<MedicineForSearch> filtrationMedicineByMark(String medicineName, String mark) {
		List<MedicineForSearch> medicineDTOs=getPharmacyForAvaliableMedicine(medicineName);
		List<MedicineForSearch> resultList=new ArrayList<>();
		
			for(MedicineForSearch m : medicineDTOs){
				if(m.getMark().equals(mark)){
					resultList.add(m);
				}
			}
		
		return resultList;
	}

	public List<MedicineForSearch> filtrationMedicineOnPrescription(String medicineName) {
		List<MedicineForSearch> medicineDTOs=getPharmacyForAvaliableMedicine(medicineName);
		List<MedicineForSearch> resultList=new ArrayList<>();
		
			for(MedicineForSearch m : medicineDTOs){
				if(m.getOnPrescription().equals("true")){
					resultList.add(m);
				}
			}
		
		return resultList;	
	}

    public List<MedicineForSearch> filtrationMedicineNotOnPrescription(String medicineName) {
		List<MedicineForSearch> medicineDTOs=getPharmacyForAvaliableMedicine(medicineName);
		List<MedicineForSearch> resultList=new ArrayList<>();
		
			for(MedicineForSearch m : medicineDTOs){
				if(m.getOnPrescription().equals("false")){
					resultList.add(m);
				}
			}
		
		return resultList;	
	  }

	public List<MedicineForSearch> combinedSearch(String parameters) {
		String[] pars=parameters.split("x");
		String medicineName=pars[0];
		String type=pars[1];
		String form=pars[2];
		String mark=pars[3];
		String onPresciption=pars[4];

		List<MedicineForSearch> allWithNames=new ArrayList<>();

		List<MedicineForSearch> filtrateByType=new ArrayList<>();
		List<MedicineForSearch> filtrateByForm=new ArrayList<>();
		List<MedicineForSearch> filtrateByMark=new ArrayList<>();
		List<MedicineForSearch> filtrateNotOnPrescription=new ArrayList<>();
		List<MedicineForSearch> filtrateOnPrescription=new ArrayList<>();


		if(medicineName.equals(" ")){
			allWithNames=findAllSearch();
		}else{
			allWithNames=getPharmacyForAvaliableMedicine(medicineName);
		}
		if(type.equals(" ")){
			filtrateByType=findAllSearch();

		}else{
			filtrateByType=filtrationMedicineByType(medicineName,type);
		}
		if(form.equals(" ")){
			filtrateByForm=findAllSearch();

		}else{
			filtrateByForm=filtrationMedicineByForm(medicineName, form);
		}
		if(mark.equals(" ")){
			filtrateByMark=findAllSearch();

		}else{
			filtrateByMark=filtrationMedicineByMark(medicineName, mark);
		}
		if(onPresciption.equals("N")){
			filtrateNotOnPrescription=filtrationMedicineNotOnPrescription(medicineName);
		}else{
			filtrateNotOnPrescription=findAllSearch();
		}

		if(onPresciption.equals("Y")){
			filtrateOnPrescription=filtrationMedicineOnPrescription(medicineName);
		}else{
			filtrateOnPrescription=findAllSearch();
		}
		List<MedicineForSearch> res=new ArrayList<>();
		List<MedicineForSearch> res1=new ArrayList<>();
		List<MedicineForSearch> res2=new ArrayList<>();
		List<MedicineForSearch> res3=new ArrayList<>();
		List<MedicineForSearch> res4=new ArrayList<>();

			for(MedicineForSearch m :allWithNames){
				for(MedicineForSearch m1: filtrateByForm){
					if(m.getName().equals(m1.getName()) && m.getComposition().equals(m1.getComposition()) && m.getForm().equals(m1.getForm()) &&
					m.getMark().equals(m1.getMark()) && m.getOnPrescription().equals(m1.getOnPrescription()) && m.getPharmacy().equals(m1.getPharmacy()) 
					&& m.getPrice().equals(m1.getPrice()) && m.getType().equals(m1.getType())){
						res.add(m);
					}
				}
			}
			for(MedicineForSearch m :filtrateByMark){
				for(MedicineForSearch m1 :filtrateByType){
					if(m.getName().equals(m1.getName()) && m.getComposition().equals(m1.getComposition()) && m.getForm().equals(m1.getForm()) &&
					m.getMark().equals(m1.getMark()) && m.getOnPrescription().equals(m1.getOnPrescription()) && m.getPharmacy().equals(m1.getPharmacy()) 
					&& m.getPrice().equals(m1.getPrice()) && m.getType().equals(m1.getType())){
						res1.add(m);
					}	
				}
			}
			for(MedicineForSearch m :filtrateOnPrescription){
				for(MedicineForSearch m1:filtrateNotOnPrescription){
					if(m.getName().equals(m1.getName()) && m.getComposition().equals(m1.getComposition()) && m.getForm().equals(m1.getForm()) &&
					m.getMark().equals(m1.getMark()) && m.getOnPrescription().equals(m1.getOnPrescription()) && m.getPharmacy().equals(m1.getPharmacy()) 
					&& m.getPrice().equals(m1.getPrice()) && m.getType().equals(m1.getType())){
						res2.add(m);
					}
				}
			}

			for(MedicineForSearch m :res){
				for(MedicineForSearch m1 :res1){
					if(m.getName().equals(m1.getName()) && m.getComposition().equals(m1.getComposition()) && m.getForm().equals(m1.getForm()) &&
					m.getMark().equals(m1.getMark()) && m.getOnPrescription().equals(m1.getOnPrescription()) && m.getPharmacy().equals(m1.getPharmacy()) 
					&& m.getPrice().equals(m1.getPrice()) && m.getType().equals(m1.getType())){
						res3.add(m);
					}
				}
			}

			for(MedicineForSearch m :res2){
				for(MedicineForSearch m1 :res3){
					if(m.getName().equals(m1.getName()) && m.getComposition().equals(m1.getComposition()) && m.getForm().equals(m1.getForm()) &&
					m.getMark().equals(m1.getMark()) && m.getOnPrescription().equals(m1.getOnPrescription()) && m.getPharmacy().equals(m1.getPharmacy()) 
					&& m.getPrice().equals(m1.getPrice()) && m.getType().equals(m1.getType())){
						res4.add(m);
					}
				}
			}
		return res4;
	}
}
