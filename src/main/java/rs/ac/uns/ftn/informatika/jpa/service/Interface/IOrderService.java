package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;

public interface IOrderService {
    List<OrderDTO> findAll();

}
