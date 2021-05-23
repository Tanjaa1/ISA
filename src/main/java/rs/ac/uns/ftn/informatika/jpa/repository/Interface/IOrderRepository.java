package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Override
	ArrayList<Order> findAll();
    @Override
    public <S extends Order> S save(S entity);

    @Query("SELECT distinct o FROM Order o, PharmacyAdmin p , Pharmacy pm WHERE o.PharmacyAdmin = p.Id and p.Pharmacy like pm.Name and pm.Id = ?1")
    public List<Order>  getOrdersByPharmacyId(Long pId);

    
}
