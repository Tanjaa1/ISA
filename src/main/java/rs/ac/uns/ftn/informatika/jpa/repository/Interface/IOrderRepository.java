package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Override
	ArrayList<Order> findAll();
    @Override
    public <S extends Order> S save(S entity);
}
