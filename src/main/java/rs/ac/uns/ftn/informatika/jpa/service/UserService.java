package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IUserService;

@Service
public class UserService implements IUserService{

	@Override
	public Collection<User> allUsers() {
		return null;
	}

}
