package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IOrderRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IOrderService;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;

    @Override
    public List<OrderDTO> findAll() {
        ArrayList<Order> orders = orderRepository.findAll();
        List<OrderDTO> result=new ArrayList<>(); 
       for (Order order : orders) {
           result.add(new OrderDTO(order));
       }
        return result;
    }
    
	public ResponseEntity<Order> save(Order order) throws Exception{
		orderRepository.save(order);
	    return new ResponseEntity<>( HttpStatus.CREATED);
	}

    public OrderDTO getById(Long id) {
        Order order=orderRepository.getOne(id);
       return new OrderDTO(order);
    }
}
