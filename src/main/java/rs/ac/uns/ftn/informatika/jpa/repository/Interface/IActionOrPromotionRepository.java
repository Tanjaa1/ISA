package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;

public interface IActionOrPromotionRepository extends JpaRepository<ActionOrPromotion, Long> {
    @Override
	public <S extends ActionOrPromotion> S save(S entity);

    @Query("SELECT ap FROM ActionOrPromotion ap ,Pharmacy p WHERE ap.Pharmacy = p.Id and p.Id = ?1  and  ap.StartTime <= CURRENT_DATE and  ap.EndTime >= CURRENT_DATE")
    public List<ActionOrPromotion> getActiveActionsAndPromotionsByPharmacyId(Long pID);
}
