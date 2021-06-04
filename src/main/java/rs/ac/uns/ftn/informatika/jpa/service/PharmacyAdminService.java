package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Counseling;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdmin;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ICounselingRpository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IPharmacyAdminService;
import rs.ac.uns.ftn.informatika.jpa.util.MapLocation;
import rs.ac.uns.ftn.informatika.jpa.util.MedicineGraphInfo;

@Service
public class PharmacyAdminService implements IPharmacyAdminService {
    @Autowired
    private IPharmacyAdminRepository pharmacyAdminRepository;
    @Autowired
   private IPharmacyRepository pharmacyRepository;
	@Autowired
	private EmailService emailService;
    @Autowired
	private ICounselingRpository counselingRpository;

	private Logger logger = LoggerFactory.getLogger(ResrvationService.class);
	
    public ResponseEntity<PharmacyAdmin> save(PharmacyAdmin systemAdmin) throws Exception {
		systemAdmin.setLastPasswordResetDate(new Date());
        pharmacyAdminRepository.save(systemAdmin);
		List<PharmacyAdmin> patients=pharmacyAdminRepository.findAll();
		Long patientId=0L;
		for (PharmacyAdmin patient2 : patients) {
			if(patient2.getUsername().equals(systemAdmin.getUsername()))
			    patientId=patient2.getId();
		}
		systemAdmin.setId(patientId);
		emailSender(systemAdmin);       
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public String updateAdmin(PharmacyAdminDTO Admin) throws Exception {
      PharmacyAdmin pAdmin = new PharmacyAdmin(Admin);
      PharmacyAdmin pa = pharmacyAdminRepository.getOne(pAdmin.getId());
      if(pa.getEmail().equalsIgnoreCase(pAdmin.getEmail()) && pa.getUsername().equals(pAdmin.getUsername())){
            pharmacyAdminRepository.save(pAdmin);
            return "OK";
      }
      else if(pa.getEmail().equalsIgnoreCase(pAdmin.getEmail()) && !pa.getUsername().equals(pAdmin.getUsername())){
        List<PharmacyAdmin> admins =  pharmacyAdminRepository.getAll();
        for (PharmacyAdmin pharmacyAdmin : admins) {
            if(pAdmin.getUsername().equals(pharmacyAdmin.getUsername()))
                return "USERNAME";
        }
         pharmacyAdminRepository.save(pAdmin);
         return "OK";
      }
      else if(!pa.getEmail().equalsIgnoreCase(pAdmin.getEmail()) && pa.getUsername().equals(pAdmin.getUsername())){
        List<PharmacyAdmin> admins =  pharmacyAdminRepository.getAll();
        for (PharmacyAdmin pharmacyAdmin : admins) {
            if(pAdmin.getEmail().equals(pharmacyAdmin.getEmail()))
                return "EMAIL";
        }
         pharmacyAdminRepository.save(pAdmin);
         return "OK";
      }
      else if(!pa.getEmail().equalsIgnoreCase(pAdmin.getEmail()) && !pa.getUsername().equals(pAdmin.getUsername())){
        List<PharmacyAdmin> admins =  pharmacyAdminRepository.getAll();
        for (PharmacyAdmin pharmacyAdmin : admins) {
            if(pAdmin.getEmail().equals(pharmacyAdmin.getEmail()) || pAdmin.getUsername().equals(pharmacyAdmin.getUsername()) )
                return "EMAILUSERNAME";
        }
        pharmacyAdminRepository.save(pAdmin);
        return "OK";
      }
      return "IDK";
    }

    public List<PharmacyAdmin> getAll() {
        List<PharmacyAdmin> systemAdmins = pharmacyAdminRepository.findAll();
        return systemAdmins;
    }

    public PharmacyAdmin findOne(Long id) {
        PharmacyAdmin systemAdmin = pharmacyAdminRepository.getOne(id);
        return systemAdmin;
    }

    public List<String> getAllSystemAdminUsernames() {
        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminRepository.findAll();
        List<String> resultList = new ArrayList<String>();
        for (PharmacyAdmin s : pharmacyAdmins) {
            resultList.add(s.getUsername());
        }
        return resultList;
    }

    public Boolean isUsernameValid(String username) {
        List<String> usernames = getAllSystemAdminUsernames();
        for (String s : usernames) {
            if (s.equals(username))
                return false;
        }
        return true;
    }
    
    public Boolean sendingMail(String pharmacyName,Medicine medicine)
    {
        try{
            PharmacyAdmin pharmacyAdmin = pharmacyAdminRepository.findPharmacyAdminByPharmacyName(pharmacyName);
            String subject="medicine for procurement";
            String text="Dear "+ pharmacyAdmin.getName()+" "+pharmacyAdmin.getSurname()+ ",\n\nA "
                                +medicine.getName()+" should be ordered!";
            emailService.sendNotificaitionAsync(pharmacyAdmin.getEmail(), subject, text);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public PharmacyAdmin update(PharmacyAdmin pharmacyAdmin) throws Exception {
        PharmacyAdmin pharmacyAdmin1 = findOne(pharmacyAdmin.getId());
        if (pharmacyAdmin1 == null) {
            throw new Exception("Trazeni entitet nije pronadjen.");
		}
		pharmacyAdmin1.setId(pharmacyAdmin.getId());
		pharmacyAdmin1.setName(pharmacyAdmin.getName());
		pharmacyAdmin1.setSurname(pharmacyAdmin.getSurname());
		pharmacyAdmin1.setEmail(pharmacyAdmin.getEmail());
		pharmacyAdmin1.setPassword(pharmacyAdmin.getPassword());
		pharmacyAdmin1.setAddress(pharmacyAdmin.getAddress());
		pharmacyAdmin1.setCity(pharmacyAdmin.getCity());
		pharmacyAdmin1.setCountry(pharmacyAdmin.getCountry());
		pharmacyAdmin1.setPhoneNumber(pharmacyAdmin.getPhoneNumber());
		pharmacyAdmin1.setEmailComfirmed(pharmacyAdmin.getEmailComfirmed());
		pharmacyAdmin1.setFirstTimeLogin(pharmacyAdmin.getFirstTimeLogin());
		pharmacyAdmin1.setDescription(pharmacyAdmin.getDescription());
        pharmacyAdmin1.setPharmacy(pharmacyAdmin.getPharmacy());
        PharmacyAdmin pharmacyAdmin2 = pharmacyAdminRepository.save(pharmacyAdmin1);
        return pharmacyAdmin2;
    }


    private void emailSender(PharmacyAdmin pharmacyAdmin)
	{

		try {
			String subject="Patient "+ pharmacyAdmin.getName() + pharmacyAdmin.getSurname();
			Long encriptId=IdEncryption(pharmacyAdmin.getId());
			String text="Dear "+ pharmacyAdmin.getName() + pharmacyAdmin.getSurname() +",\n Please click on link below to activate your profile \n <a href=\"http://localhost:8090/#/emailConfirmationPharmacyAdmin?id=" + encriptId + "\">link</a>!";
			emailService.sendNotificaitionAsync(pharmacyAdmin.getEmail(),subject,text);
		}catch( Exception e ){
			logger.info("Error sending email: " + e.getMessage());
		}
	}

	private Long IdEncryption(Long patientId)
	{
		return (patientId + 6789 + 23 * 33);          
	}

	private Long IdDecryption(Long patientId)
	{
		return (patientId - 23 * 33 - 6789);
	}

	public Boolean confirmationEmail(Long Id) throws Exception {
		Long decriptId=IdDecryption(Id);
		PharmacyAdmin pharmacyAdmnToUpdate=findOne(decriptId);
		if(pharmacyAdmnToUpdate.getEmailComfirmed()) return false;
		pharmacyAdmnToUpdate.setEmailComfirmed(true);
		update(pharmacyAdmnToUpdate);
		return true;
	}

    public PharmacyAdmin getPharmacyAdminByCredentials(String username) {
        List<PharmacyAdmin>list=pharmacyAdminRepository.findAll();
		PharmacyAdmin patieResult=new PharmacyAdmin();
		for (PharmacyAdmin patient : list) {
			if(patient.getUsername().equals(username)){
				patieResult=patient;
			}
		}
		return patieResult;
		}
    
    
        public List<MedicineGraphInfo> revenueDaily(Long pharmacyId, int month , int year) throws Exception {

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
    
            List<Reservation> reservations = pharmacyRepository.getConsumedMeds(pharmacyId);
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                for(int i = 0 ; i < 31 ; i++){
                    for(Reservation r : reservations){
                        if(Integer.parseInt(r.getExpirationDate().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getExpirationDate().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getExpirationDate().toString().split("-")[2].split(" ")[0]) == i+1){
                            retVal.get(i).addToY((int)r.getMedicine().getPrice());
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
                            retVal.get(i).addToY((int)r.getMedicine().getPrice());
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
                            retVal.get(i).addToY((int)r.getMedicine().getPrice());
                        }
                    }
                }
            }


            List<Examination> examinations = pharmacyRepository.getFinishedExaminations(pharmacyId);
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                for(int i = 0 ; i < 31 ; i++){
                    for(Examination r : examinations){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11){
                for(int i = 0 ; i < 30 ; i++){
                    for(Examination r : examinations){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }
            else if(month == 2){
                for(int i = 0 ; i < 29 ; i++){
                    for(Examination r : examinations){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }

            
            List<Counseling> counselings = pharmacyRepository.getCounselngsFinished(pharmacyId);
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                for(int i = 0 ; i < 31 ; i++){
                    for(Counseling r : counselings){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11){
                for(int i = 0 ; i < 30 ; i++){
                    for(Counseling r : counselings){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }
            else if(month == 2){
                for(int i = 0 ; i < 29 ; i++){
                    for(Counseling r : counselings){
                        if(Integer.parseInt(r.getEndTime().toString().split("-")[0]) == year 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[1]) == month 
                        && Integer.parseInt(r.getEndTime().toString().split("-")[2].split("T")[0]) == i+1){
                            retVal.get(i).addToY(r.getPrice().intValue());
                        }
                    }
                }
            }

            return retVal;
        }

        public MapLocation getMapLocation(Long id) {
            return pharmacyAdminRepository.getMapLocation(id);
        }
    

}