package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineQuantityDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.SupplierOfferDTO;
import rs.ac.uns.ftn.informatika.jpa.enums.OfferStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SupplierOffer;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IOrderRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.ISupplierOfferRepository;

@Service
public class SupplierOfferService {
    @Autowired
    private ISupplierOfferRepository supplierOfferRepository;
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SupplierService supplierService;
	@Autowired
	private EmailService emailService;
   
    public List<SupplierOfferDTO> getOfferBySupplierId(Long id) {
    Supplier s=supplierService.findOne(id);
    List<SupplierOfferDTO> result=new ArrayList<>();
    List<SupplierOffer> list=supplierOfferRepository.findAll();
    for(SupplierOffer supplierOffer : list){
        if(supplierOffer.getSupplier().getId()==s.getId()){
            result.add(new SupplierOfferDTO(supplierOffer));
        }
    } 
        return result;
    }

    public List<SupplierOfferDTO> filtrateOfferByStatus(String status,Long supplierId) {
		List<SupplierOfferDTO> list=getOfferBySupplierId(supplierId);
        List<SupplierOfferDTO> result=new ArrayList<>();

        if(list==null){
            result= null;
        }else{
            if(status.equals("All")){
                result=getOfferBySupplierId(supplierId);
            }else{
                for(SupplierOfferDTO s :list){
                    if(s.getStatus().toString().equals(status)){
                        result.add(s);
                    }
                }
            }
        }
       return  result;
	}
    public ResponseEntity<SupplierOffer> save(SupplierOffer offer) throws Exception {
        supplierOfferRepository.save(offer);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    public List<SupplierOfferDTO> getByOrder(Long orderId) throws Exception {
        
        List<SupplierOfferDTO> retVal = new ArrayList<SupplierOfferDTO>();

        for (SupplierOffer offer : supplierOfferRepository.getOffersByOrder(orderId)) {
            retVal.add(new SupplierOfferDTO(offer));
        }

        return retVal;
    }


    public Boolean giveOfferToOrder(Double price,String dueDate, Long orderId,Long supplierId) throws Exception {
        OrderDTO order=orderService.getById(orderId);
        Set<MedicineQuantityDTO> orders=order.getOrders();
        Supplier supplier=supplierService.findOne(supplierId);
        SupplierOffer so=new SupplierOffer();
        Set<MedicineQuantityDTO>stock=supplierService.getAllSuppliersStokcs(supplierId);
        Boolean hasOnStock=false;
        
        for(MedicineQuantityDTO mq : stock){
           for(MedicineQuantityDTO mq1 : orders){
               if(!mq.getMedicine().getId().equals(mq1.getMedicine().getId()) && mq.getQuantity() <mq1.getQuantity()){
                hasOnStock=false;
                break;
               }else{
                   hasOnStock=true;
               }
           }
           Order o=new Order(order);
        if(hasOnStock){
            SupplierOffer s=new SupplierOffer(Long.valueOf('7'),o,supplier,OfferStatus.Waiting_for_answer,price,dueDate);
            save(s);
            break;
        }
        }
        return hasOnStock;        
    }

    public Set<MedicineQuantityDTO> getOrdersByOrderId(Long orderId) {
        OrderDTO orderDTO=orderService.getById(orderId);
        Set<MedicineQuantityDTO> result=orderDTO.getOrders();
        return result;
    }

    public Boolean isOfferGivenToOrder(Long orderId, Long supplierId) {
        List<SupplierOffer> offersList=supplierOfferRepository.findAll();
        Boolean result=false;
        for (SupplierOffer s : offersList) {
            if(s.getOrder().getId()==orderId &&  s.getSupplier().getId()==supplierId){
                result= true;
            }else{
                result= false;
            }
        }
        return result;
    }

    public Boolean acceptOrder(OrderDTO or,Long id){
        
       List<SupplierOffer> so = supplierOfferRepository.getOffersByOrder(or.getId());

        for (SupplierOffer supplierOffer : so) {

            if(supplierOffer.getId() == id.longValue()){
                supplierOffer.setIsAccepted(OfferStatus.Accepted);
                try {
                    String subject="Response to offer \n\n";
                    String text="We are informing you that your offer to our order no. " + or.getId() + " is accepted";
                    emailService.sendNotificaitionAsync(supplierOffer.getSupplier().getEmail(),subject,text);
                }catch( Exception e ){
                }
            
            }
            else{
                supplierOffer.setIsAccepted(OfferStatus.Denided);
                try {
                    String subject="Response to offer \n\n";
                    String text="We are informing you that your offer to our order no. " + or.getId() + " is rejected";
                    emailService.sendNotificaitionAsync(supplierOffer.getSupplier().getEmail(),subject,text);
                }catch( Exception e ){
                }
            
            }
            supplierOfferRepository.save(supplierOffer);
        }

        Order order= orderRepository.getOne(or.getId());
        order.setIsProcessed(true);
        orderRepository.save(order);
        return true;
    }

    public SupplierOfferDTO getOffersById(Long offerId) {
      return new SupplierOfferDTO(supplierOfferRepository.findById(offerId).get());
    }

    public SupplierOffer updateOffer(Long offerId, double price, String dueDate) throws Exception {
        SupplierOffer supplierOffer =supplierOfferRepository.findById(offerId).get();
		if (supplierOffer == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		supplierOffer.setDueDate(dueDate);;
        supplierOffer.setOfferPrice(price);
		SupplierOffer supplierOffer2 = supplierOfferRepository.save(supplierOffer);
		return supplierOffer2;    }
  



    
    }
    

