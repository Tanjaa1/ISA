package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Authority;

public interface IAuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}