
package rs.ac.uns.ftn.informatika.jpa.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import antlr.collections.List;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.ResourcesConflictExeption;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserRequest;
import rs.ac.uns.ftn.informatika.jpa.model.UserTokenState;
import rs.ac.uns.ftn.informatika.jpa.securitySecurityAuth.JwtAuthenticationRequest;
import rs.ac.uns.ftn.informatika.jpa.securitySecurityAuth.TokenUtils;
import rs.ac.uns.ftn.informatika.jpa.service.CustomUserDetailsService;
import rs.ac.uns.ftn.informatika.jpa.service.PatientService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;
import rs.ac.uns.ftn.informatika.jpa.service.Interface.IUserService;
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;


	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private IUserService userService;
	@Autowired
	private PatientService patientService;

    
    
	@Autowired
	private AuthenticationManager authenticationManager;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {

		// 
        try {
			Authentication authentication = authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
					authenticationRequest.getPassword()));

	// Ubaci korisnika u trenutni security kontekst
	SecurityContextHolder.getContext().setAuthentication(authentication);

	// Kreiraj token za tog korisnika
	User user = (User) authentication.getPrincipal();
	Collection<? extends GrantedAuthority> auts=user.getAuthorities();
	ArrayList<String> autss=new ArrayList<>();
	for (GrantedAuthority string : auts) {
		autss.add(string.getAuthority());
	}
//	Patient patient=patientService.getPatientByCredentials(user.getUsername());
	String jwt = tokenUtils.generateToken(user.getUsername(),autss);
	int expiresIn = tokenUtils.getExpiredIn();
	ArrayList<String> role=new ArrayList<>();
	role=(ArrayList<String>) tokenUtils.getRoleFromToken(jwt);
// Vrati token kao odgovor na uspesnu autentifikaciju
return ResponseEntity.ok(new UserTokenState(jwt, expiresIn,role,user.getUsername(),user.getId(),user.getFirstTimeLogin().toString()));
		} catch (Exception e) {
			return null;	
		}
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getUsername());
		if (existUser != null) {
			throw new ResourcesConflictExeption(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.save(userRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	// U slucaju isteka vazenja JWT tokena, endpoint koji se poziva da se token osvezi
	@PostMapping(value = "/refresh")
	public ResponseEntity<UserTokenState> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
		User user = (User) this.userDetailsService.loadUserByUsername(username);

		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}