package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;

public interface IDermatologistRepository extends JpaRepository<Dermatologist, Long> {

    ArrayList<Dermatologist> findAll();
}
