package rs.ac.uns.ftn.informatika.jpa.controller;

import rs.ac.uns.ftn.informatika.jpa.dto.*;
import rs.ac.uns.ftn.informatika.jpa.model.ActionOrPromotion;
import rs.ac.uns.ftn.informatika.jpa.service.ActionOrPromotionService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IActionOrPromotionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/actionOrPromotion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActionOrPromotionController {

    @Autowired
    IActionOrPromotionService actionOrPromotionService; 
    
    @PostMapping(value = "/add")
    public ResponseEntity<ActionOrPromotionsDTO> newExamination(@RequestBody ActionOrPromotion actionOrPromotion)
		throws Exception 
	{
		return ResponseEntity.ok(actionOrPromotionService.save(actionOrPromotion));
	}

	@GetMapping(value = "/getAll")
	public List<ActionOrPromotion> getAllComplaintsAnswered() {
		List<ActionOrPromotion> codes =actionOrPromotionService.getAll();
		return codes;
	}

}
