package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
   User findByUsername( String username );
}
