package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRequestDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OrderDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineRequest;
import rs.ac.uns.ftn.informatika.jpa.model.Order;

public interface IOrderService {
    List<OrderDTO> findAll();

    List<MedicineRequestDTO> getRequestByPharmacy(Long id);
}
