package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.dto.*;

public interface IActionOrPromotionService {
    
    public List<ActionOrPromotion> getAll();
    public ActionOrPromotionsDTO save(ActionOrPromotion actionOrPromotion) throws Exception;

}
