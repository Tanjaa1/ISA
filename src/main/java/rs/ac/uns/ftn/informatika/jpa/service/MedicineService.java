package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

import rs.ac.uns.ftn.informatika.jpa.dto.LoyaltyProgrammeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineForQRDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineForSearch;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicinePriceAndQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyQRDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.LoyaltyProgramme;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.MedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMarkRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicinePriceAndQuantity;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPatientRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IReservationRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyService;
import rs.ac.uns.ftn.informatika.jpa.util.MedicineGraphInfo;

import java.io.File;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
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
	private LoyaltyProgrammeService loyaltyProgrammeService;

	@Autowired
	private IPharmacyRepository pharmacyRepository;

	@Autowired
	private IMedicinePriceAndQuantity medPriceAndQuantityRepository;

	@Autowired
	private IReservationRepository reservationRepository;

	public Medicine findOne(Long id) {
		Medicine medicine = medicineRepository.findById(id).get();
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
		Patient patient = patientRepository.findById(id).get();
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
		Medicine medicine2 = medicineRepository.findById(medicine.getId()).get();
		Patient patient = patientRepository.findById(id).get();
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
				Integer grade=mdto.getGrade();
				if(grade==null){
					grade=1;
				}
				result.add(new MedicineForSearch( mdto.getName(), mdto.getType().toString(),mdto.getComposition(), p.getName(), grade.toString(),"250",mdto.getOnPrescription().toString(),mdto.getForm().toString()));
			}
		}
		return result;
	}
	public List<MedicineForSearch> getPharmacyForAvaliableMedicineAndQuantity(String medicineName,Integer quantity) {
		List<MedicineDTO> ms=findAllSearchMedicine(medicineName);
		List<MedicineForSearch> result=new ArrayList<>();

		for(MedicineDTO mdto : ms){
			List<PharmacyDTO> pharmacys=pharmacyService.findPharmacyByMedicineNameAndQuantity(mdto.getName(),quantity);
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

	public Set<MedicineForSearch> combinedSearch(String parameters) {
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
		Set<MedicineForSearch> res=new HashSet<>();
		Set<MedicineForSearch> res1=new HashSet<>();
		Set<MedicineForSearch> res2=new HashSet<>();
		Set<MedicineForSearch> res3=new HashSet<>();
		Set<MedicineForSearch> res4=new HashSet<>();

			for(MedicineForSearch m :allWithNames){
				for(MedicineForSearch m1: filtrateByForm){
					if(m.getName().equals(m1.getName())  ){
						res.add(m);
					}
				}
			}
			for(MedicineForSearch m :filtrateByType ){
				for(MedicineForSearch m1 :filtrateByMark){
					if(m.getName().equals(m1.getName()) ){
						res1.add(m);
					}	
				}
			}
			for(MedicineForSearch m :filtrateOnPrescription){
				for(MedicineForSearch m1:filtrateNotOnPrescription){
					if(m.getName().equals(m1.getName()) ){
						res2.add(m);
					}
				}
			}

			for(MedicineForSearch m :res){
				for(MedicineForSearch m1 :res1){
					if(m.getName().equals(m1.getName())){
						res3.add(m);
					}
				}
			}

			for(MedicineForSearch m :res2){
				for(MedicineForSearch m1 :res3){
					if(m.getName().equals(m1.getName()) ){
						res4.add(m);
					}
				}
			}
		return res4;
	}
	public static String readQR(String path, String charset, Map hashMap)throws FileNotFoundException, IOException,NotFoundException
	{
		BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
		ImageIO.read(
			new FileInputStream(path)))));
		Result result
		= new MultiFormatReader().decode(binaryBitmap);
		return result.getText();
	}

    public String uploadQR(String path)throws FileNotFoundException, IOException,NotFoundException {
         
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        String result= readQR(path, "UTF-8", hashMap);  
	
	return result;
}

public Set<PharmacyQRDTO> getPharmaciesByQR(String path,Long patientIdd) throws FileNotFoundException, NotFoundException, IOException {
	String ePrescriptionContent=uploadQR(path);
	String [] partsMedicineAndQuantity=ePrescriptionContent.split(",");
	Map<String,Integer> mapMedicineInPharmacy=new HashMap<>();
	Map<String,Integer> qrMedicines=new HashMap<>();
	Map<String,Double> pricePerPharmacies=new HashMap<>();

	List<Pharmacy> allPharmacies=pharmacyRepository.findAll();
	Set<Pharmacy> resultList=new HashSet();
	Set<PharmacyDTO> resultListDTOS=new HashSet();
	Set<PharmacyQRDTO> resultF=new HashSet();

	for (int i=0;i<partsMedicineAndQuantity.length;i++) {
		String nameMedicine=partsMedicineAndQuantity[i].split("-")[0];
		String quantityMedicine=partsMedicineAndQuantity[i].split("-")[1];
		qrMedicines.put(nameMedicine.trim().toLowerCase(), Integer.valueOf(quantityMedicine));
	}
	Integer indikator=0;
		for (Pharmacy pharmacy : allPharmacies) {
			Set<MedicinePriceAndQuantity> m=pharmacy.getPricelist();
			mapMedicineInPharmacy.clear();
			for (MedicinePriceAndQuantity medicineInPharmacy : m) {
			mapMedicineInPharmacy.put(medicineInPharmacy.getMedicine().getName().trim().toLowerCase(),medicineInPharmacy.getQuantity());
			}
			if(mapMedicineInPharmacy.keySet().containsAll(qrMedicines.keySet())) {
				for (Map.Entry<String, Integer> entry1 : qrMedicines.entrySet()) {
					if(entry1.getValue()<=mapMedicineInPharmacy.get(entry1.getKey())){
						indikator+=1;
					}else{
						break;
					}
					if(indikator==qrMedicines.size()){
						resultList.add(pharmacy);
						indikator=0;
						mapMedicineInPharmacy.clear();
					}
				}
				
			}
		}
	
	
	for (Pharmacy p : resultList) {
		resultListDTOS.add(new PharmacyDTO(p));
	}

		for (PharmacyDTO pharmacyDTO : resultListDTOS) {
			Double pricePerPharmacy=0.0;
			for (Map.Entry<String, Integer> entry1 : qrMedicines.entrySet()) {
			Set<MedicinePriceAndQuantityDTO> m=pharmacyDTO.getPricelist();
			for (MedicinePriceAndQuantityDTO medicineInPharmacy : m) {
				if(entry1.getKey().equals(medicineInPharmacy.getMedicine().getName().trim().toLowerCase())){
					pricePerPharmacy+=medicineInPharmacy.getPrice()*entry1.getValue();
				}
			}
		}
		pricePerPharmacies.put(pharmacyDTO.getName(), pricePerPharmacy);
	}

	for (PharmacyDTO pharmacyDTO : resultListDTOS) {
		Double price=pricePerPharmacies.get(pharmacyDTO.getName());
		Double grade;
		if(pharmacyDTO.getGrade()==null){
			grade=0.0;
		}else{
			grade=pharmacyDTO.getGrade();
		}
		Double priceWithDiscount=Discount(price, patientIdd);
		resultF.add(new PharmacyQRDTO(pharmacyDTO.getId(), pharmacyDTO.getName(),pharmacyDTO.getAddress(), grade, price,priceWithDiscount));
	}

	return resultF;
}
public Double Discount(Double price,Long patientId){
	List<LoyaltyProgrammeDTO> lp=loyaltyProgrammeService.getAll();
	Patient patient=patientRepository.findById(patientId).get();
	LoyaltyProgrammeDTO lpp= lp.get(0);
	Integer regular=lpp.getRegular();
	Integer silver=lpp.getSilver();
	Integer gold=lpp.getGold();
	Double regularDiscount=lpp.getGoldDiscount();
	Double silverDiscount=lpp.getSilverDiscount();
	Double goldDiscount=lpp.getGoldDiscount();

	Double priceWithDiscount=0.0;

	if(patient.getPoints()<=regular){
		priceWithDiscount=price;
	}
	else if(patient.getPoints()>regular && patient.getPoints()<=silver){
		priceWithDiscount=price-(price*regularDiscount);
	}else if(patient.getPoints()>silver && patient.getPoints()<=gold){
		priceWithDiscount=price-(price*silverDiscount);
	}else{
		priceWithDiscount=price-(price*goldDiscount);
	}
	return priceWithDiscount;
}

public List<PharmacyQRDTO> sortByPharmacyGradeQR(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getGrade().compareTo(e2.getGrade())).collect(Collectors.toList());
	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyPriceQR(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getPriceofMedicines().compareTo(e2.getPriceofMedicines())).collect(Collectors.toList());
	
	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyNameQR(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
	
	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyAddressQR(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getAddress().compareTo(e2.getAddress())).collect(Collectors.toList());
	
	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyGradeQRDESC(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getGrade().compareTo(e2.getGrade())).collect(Collectors.toList());
	Collections.reverse(phaList);

	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyPriceQRDESC(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getPriceofMedicines().compareTo(e2.getPriceofMedicines())).collect(Collectors.toList());

	Collections.reverse(phaList);
	
	return phaList;}

public List<PharmacyQRDTO> sortByPharmacyNameDESC(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
	Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
	List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
	e1.getAddress().compareTo(e2.getAddress())).collect(Collectors.toList());
	Collections.reverse(phaList);
	return phaList;
}

public List<PharmacyQRDTO> sortByPharmacyAddressQRDESC(String path, Long patientId) throws FileNotFoundException, NotFoundException, IOException {
		Set<PharmacyQRDTO> toSort=getPharmaciesByQR(path,patientId);
		List<PharmacyQRDTO> phaList = toSort.stream().sorted((e1, e2) -> 
		e1.getAddress().compareTo(e2.getAddress())).collect(Collectors.toList());
		Collections.reverse(phaList);
		return phaList;
	}

	public List<MedicineDTO> getAllAR() {
		List<Medicine> medicines = medicineRepository.findAll();
		List<MedicineDTO> retVal = new ArrayList<MedicineDTO>();
		for (Medicine medicine : medicines) {
			medicine.setMarks(new HashSet<Markk>());
			retVal.add(new MedicineDTO(medicine));
		}

		return retVal;
	}

	public boolean deleteMedicineFromPricelist(Long ID,Long pID){

		Pharmacy pharmacy = pharmacyRepository.findById(pID).get();
		List<Reservation> reservations;
		MedicinePriceAndQuantity med = medPriceAndQuantityRepository.findById(ID).get();

		reservations = reservationRepository.getReservationByPharmacyAndMedicine(pharmacy, med);
		if(reservations.isEmpty()){
			Set<MedicinePriceAndQuantity> newPricelist = new HashSet<MedicinePriceAndQuantity>();

			for (MedicinePriceAndQuantity mpq : pharmacy.getPricelist()) {
				if(mpq.getId() != ID){
					newPricelist.add(mpq);
				}
			}

			pharmacy.setPricelist(newPricelist);
			pharmacyRepository.save(pharmacy);

			return true;
		}	
		return false;
	}

	public ResponseEntity<MedicinePriceAndQuantity> addToPricelist( MedicinePriceAndQuantity MPQ ,Long PharmacyId) throws Exception {

		Pharmacy pharmacy = pharmacyRepository.findById(PharmacyId).get();
		Set<MedicinePriceAndQuantity> pricelist= pharmacy.getPricelist();
		pricelist.add(MPQ);
		pharmacy.setPricelist(pricelist);
		pharmacyRepository.save(pharmacy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<MedicinePriceAndQuantity> savePriceAndQuantity(MedicinePriceAndQuantity medicine) throws Exception {

		medPriceAndQuantityRepository.save(medicine);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public List<MedicineGraphInfo> medicineConsumptionDaily(Long medicineId ,Long pharmacyId, int month , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			for(int i = 0 ; i < 31 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			for(int i = 0 ; i < 30 ; i++){
				retVal.add(new MedicineGraphInfo(i,0));	
			}
		}
		else if(month == 2){
			for(int i = 0 ; i < 29 ; i++){
				retVal.add(new MedicineGraphInfo(i,0));	
			}
		}

		List<Reservation> reservations = pharmacyRepository.getMedicineConsumptionReportMonth(pharmacyId, medicineId);
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			for(int i = 0 ; i < 31 ; i++){
				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[2].split(" ")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			for(int i = 0 ; i < 30 ; i++){
				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[2].split(" ")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		else if(month == 2){
			for(int i = 0 ; i < 29 ; i++){
				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == month 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[2].split(" ")[0]) == i+1){
						retVal.get(i).incrementY();
					}
				}
			}
		}
		return retVal;
	}

	public List<MedicineGraphInfo> medicineConsumptionQuartal(Long medicineId ,Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		for(int i = 0 ; i < 4 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
		}


		List<Reservation> reservations = pharmacyRepository.getMedicineConsumptionReportMonth(pharmacyId, medicineId);

				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& ( Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 1 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 2 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 3 )
					){
						retVal.get(0).incrementY();
					}
					else if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& (Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 4 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 5 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 6 )
					){
						retVal.get(1).incrementY();
					}
					else if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& (Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 7 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 8 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 9 )
					){
						retVal.get(2).incrementY();
					}
					else if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&&( Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 10 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 11 
					|| Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == 12 )
					){
						retVal.get(3).incrementY();
					}
				}
			
		return retVal;
	}

	public List<MedicineGraphInfo> medicineConsumptionMonthly(Long medicineId ,Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
	
		for(int i = 0 ; i < 12 ; i++){
				retVal.add(new MedicineGraphInfo(i+1,0));	
		}


		List<Reservation> reservations = pharmacyRepository.getMedicineConsumptionReportMonth(pharmacyId, medicineId);
		for(int i = 0 ; i < 12 ; i++){
				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
					&& Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == i+1 
					){
						retVal.get(i).incrementY();
					}
				}
			}
			
		return retVal;
	}
	
	public List<MedicineGraphInfo> medicineConsumptionYearly(Long medicineId ,Long pharmacyId , int year) throws Exception {

		List<MedicineGraphInfo> retVal = new ArrayList<MedicineGraphInfo>();
		year = year- 4;

		for(int i = 0 ; i < 5 ; i++){
				retVal.add(new MedicineGraphInfo(year+i,0));	
		}


		List<Reservation> reservations = pharmacyRepository.getMedicineConsumptionReportMonth(pharmacyId, medicineId);
		for(int i = 0 ; i < 5 ; i++){
				for(Reservation r : reservations){
					if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year + i 
					){
						retVal.get(i).incrementY();
					}
				}
			}
			
		return retVal;
	}
	
}
		