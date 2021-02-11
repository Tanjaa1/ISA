package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;

public interface IActionOrPromotionRepository extends JpaRepository<ActionOrPromotion, Long> {
    @Override
	public <S extends ActionOrPromotion> S save(S entity);
}
