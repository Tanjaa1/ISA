package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRequestDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineRequest;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IMedicineRequestRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IOrderRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IOrderService;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    IMedicineRequestRepository medicineRequestRepository;

    @Override
    public List<OrderDTO> findAll() {
        ArrayList<Order> orders = orderRepository.findAll();
        List<OrderDTO> result=new ArrayList<>(); 
       for (Order order : orders) {
           result.add(new OrderDTO(order));
       }
        return result;
    }
    
	public ResponseEntity<Order> save(OrderDTO order) throws Exception{
        order.setIsProcessed(false);
		orderRepository.save(new Order(order));
	    return new ResponseEntity<>( HttpStatus.CREATED);
	}

	public ResponseEntity<Order> update(OrderDTO order) throws Exception{
		orderRepository.save(new Order(order));
	    return new ResponseEntity<>( HttpStatus.CREATED);
	}

    public OrderDTO getById(Long id) {
        Order order=orderRepository.getOne(id);
       return new OrderDTO(order);
    }

    public List<OrderDTO> getByPharmacyId(Long id) {
        List<Order> orders = orderRepository.getOrdersByPharmacyId(id);
        List<OrderDTO> retVal =new ArrayList<OrderDTO>();

        for (Order order : orders) {
            retVal.add(new OrderDTO(order));
        }

       return retVal;
    }

    @Override
    public List<MedicineRequestDTO> getRequestByPharmacy(Long id) {
       List<MedicineRequest> requests = medicineRequestRepository.getRequestsByPharmacyId(id);
       List<MedicineRequestDTO> retVal = new ArrayList<MedicineRequestDTO>();
       for (MedicineRequest request : requests) {
           retVal.add(new MedicineRequestDTO(request));
       }
       return retVal;
    }

    public ResponseEntity<MedicineRequestDTO> addRequest(MedicineRequestDTO request) throws Exception{
        MedicineRequest medRequest = new MedicineRequest(request);
        medicineRequestRepository.save(medRequest);
	    return new ResponseEntity<>( HttpStatus.CREATED);
	}

    public MedicineRequest setRequestToSolved(Long id) throws Exception{
        MedicineRequest medRequest = medicineRequestRepository.getOne(id);
        medRequest.setSolved(true);
	    return medicineRequestRepository.save(medRequest);
	}

    
}
