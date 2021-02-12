package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineRepository extends JpaRepository<Medicine, Long> {
	@Override
    public Medicine getOne(Long id);
	@Override
	public <S extends Medicine> S save(S entity);
	@Override
	ArrayList<Medicine> findAll();
	@Query("SELECT m FROM Medicine m WHERE  m.Name like ?1 ")
    public Medicine getMedicinebyName(String d);
	
	@Query("SELECT distinct m FROM Medicine m,Reservation r,MedicinePriceAndQuantity mp,Patient p WHERE r.Medicine=mp.Id and mp.Medicine=m.Id and r.Patient=p.Id and r.IsReceived=true and p.Id=?1")
    public List<Medicine> getMedicines(Long id);

}