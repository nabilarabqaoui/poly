package com.emsi.portfolio.security.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emsi.portfolio.Exception.EmailNotFoundException;
import com.emsi.portfolio.model.Utilisateur;
import com.emsi.portfolio.repository.UtilisateurRepository;


@Service
public class UtilisateurDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UtilisateurRepository utilisateurRepository;

	/*@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = utilisateurRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec le username: " + username));
		
		return UtilisateurDetailsImpl.build(utilisateur);
	}*/
	 @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Utilisateur user = utilisateurRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + username));

	    return UtilisateurDetailsImpl.build(user);
	  }
}
