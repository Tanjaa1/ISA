package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IMedicineService;

@Service
public class MedicineService implements IMedicineService {

	@Autowired
	private IMedicineRepository medicineRepository;
	
	@Autowired
	private IPatientRepository patientRepository;

	@Autowired
	private IMarkRepository markRepository;

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
	public ArrayList<Medicine> findAll() {
		return medicineRepository.findAll();
	}

	public MedicineDTO findMedicine(String name) {
		List<Medicine> medicines = medicineRepository.findAll();
		MedicineDTO medicineFind = new MedicineDTO();
		for (Medicine medicine : medicines) {
			if(medicine.getName().toUpperCase().contains(name.toUpperCase().trim()))
				medicineFind = new MedicineDTO(medicine);
                break;
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


}
