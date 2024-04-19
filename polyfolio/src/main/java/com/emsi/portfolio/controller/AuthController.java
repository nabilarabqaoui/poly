package com.emsi.portfolio.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.payload.response.JwtResponse;
import com.emsi.portfolio.payload.response.MessageResponse;
import com.emsi.portfolio.repository.RoleRepository;
import com.emsi.portfolio.repository.UtilisateurRepository;
import com.emsi.portfolio.security.jwt.JwtUtils;
import com.emsi.portfolio.model.ERole;
import com.emsi.portfolio.model.Role;
import com.emsi.portfolio.model.Utilisateur;
import com.emsi.portfolio.payload.request.*;
import com.emsi.portfolio.payload.response.*;
import com.emsi.portfolio.security.services.UtilisateurDetailsImpl;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UtilisateurRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	  Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		
    UtilisateurDetailsImpl userDetails = (UtilisateurDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getNom(), 
                         userDetails.getPrenom(),
                         userDetails.getEmail(),
                         userDetails.getTelephone(),
                         userDetails.getDateNaissance(),
                         userDetails.getPays(),
                         userDetails.getVille(),
                         userDetails.getEstEtudiant(),
                         userDetails.getEcole(),
                         userDetails.getAnneeDebut(),
                         userDetails.getAnneeFin(),
                         userDetails.getPosteOccupe(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	//Error when email is already in use
			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Email is already in use!"));
			}
			
			 //Error when telephone is already in use!
			if(userRepository.existsByTelephone(signUpRequest.getTelephone())){
			return ResponseEntity.badRequest().body(new MessageResponse("Erorr: N° Telephone est déjà utilisé!"));
			}

    // Create new user's account
    Utilisateur user = new Utilisateur(signUpRequest.getNom(),
    		signUpRequest.getPrenom(),
    		signUpRequest.getEmail(),
    		signUpRequest.getDateNaissance(),
    		encoder.encode(signUpRequest.getPassword()),
    		signUpRequest.getTelephone(),
    		signUpRequest.getEstEtudiant(),
    		signUpRequest.getEcole(),
    		signUpRequest.getAnneeDebut(),
    		signUpRequest.getAnneeFin(),
    		signUpRequest.getPosteOccupe(),
    		signUpRequest.getPays(),
    		signUpRequest.getVille()
              );

    Set<String> strRoles = signUpRequest.getRole();
	Set<Role> roles = new HashSet<>();

	if (strRoles == null) {
		Role userRole = roleRepository.findByName(ERole.ROLE_USER);//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
	} else {
		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(adminRole);
				break;
			
			default:
				Role userRole = roleRepository.findByName(ERole.ROLE_USER);//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			}
		});
	}

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}