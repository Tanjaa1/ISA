package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;

public interface ISupplierOfferRepository  extends JpaRepository<SupplierOffer, Long>{


	@Query("SELECT DISTINCT so FROM SupplierOffer so , Order ord WHERE so.Order = ord.Id AND ord.Id = ?1 ")
	List<SupplierOffer> getOffersByOrder(Long orderId);

}
