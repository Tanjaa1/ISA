package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.repository.Interface.IAuthorityRepository;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IAuthorityService;

@Service
public class AuthorityService implements IAuthorityService {

    @Autowired
    private IAuthorityRepository authorityRepository;
  
    @Override
    public List<Authority> findById(Long id) {
      Authority auth = this.authorityRepository.getOne(id);
      List<Authority> auths = new ArrayList<>();
      auths.add(auth);
      return auths;
    }
  
    @Override
    public List<Authority> findByname(String name) {
      Authority auth = this.authorityRepository.findByName(name);
      List<Authority> auths = new ArrayList<>();
      auths.add(auth);
      return auths;
    }
  
  
  }
  