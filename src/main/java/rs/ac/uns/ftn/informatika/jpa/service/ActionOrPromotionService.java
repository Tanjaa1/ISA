package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IActionOrPromotionRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IActionOrPromotionService;

@Service
public class ActionOrPromotionService implements IActionOrPromotionService {
    
    @Autowired
	private IActionOrPromotionRepository actionOrPromotionRepository;

    public List<ActionOrPromotion> getAll(){
        return null;
    }
}
