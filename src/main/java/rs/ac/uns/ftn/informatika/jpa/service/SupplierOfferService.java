package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.RealmRuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierOfferRepository;

@Service
public class SupplierOfferService {
    @Autowired
    private ISupplierOfferRepository supplierOfferRepository;
    @Autowired
    private SupplierService supplierService;

   
    public List<SupplierOffer> getOfferBySupplierId(Long id) {
    Supplier s=supplierService.findOne(id);
    List<SupplierOffer> result=new ArrayList<>();
    List<SupplierOffer> list=supplierOfferRepository.findAll();
    for(SupplierOffer supplierOffer : list){
        if(supplierOffer.getSupplier().equals(s)){
            result.add(supplierOffer);
        }
    }
    if(result.isEmpty())
        return null;
    else    
        return result;
    }

    public List<SupplierOffer> filtrateOfferByStatus(String status,Long supplierId) {
		List<SupplierOffer> list=getOfferBySupplierId(supplierId);
        List<SupplierOffer> result=new ArrayList<>();

        for(SupplierOffer s :list){
            if(s.getStatus().toString().equals(status)){
                result.add(s);
            }
        }
       return  result;
	}
    
    }
    

