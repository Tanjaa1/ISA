package rs.ac.uns.ftn.informatika.jpa.service.Interface;

import java.util.Collection;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserRequest;

public interface IUserService {
	Collection<User> allUsers();
	User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);
}
