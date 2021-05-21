package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.dto.*;

public interface IActionOrPromotionService {
    
    public List<ActionOrPromotionsDTO> getAll();
    public ActionOrPromotionsDTO save(ActionOrPromotion actionOrPromotion) throws Exception;
    public List<ActionOrPromotionsDTO> getByPharmacyId(String id);
    public ActionOrPromotionsDTO findById(Long Id);
    public List<ActionOrPromotionsDTO> getAllUnsubscribed(Long id);
    List<ActionOrPromotionsDTO> getCurrentActionsAndPromotions(Long pId);
}
