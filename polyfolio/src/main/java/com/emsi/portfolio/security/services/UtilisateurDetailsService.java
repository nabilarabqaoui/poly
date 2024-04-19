package com.emsi.portfolio.security.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.emsi.portfolio.Exception.EmailNotFoundException;
import com.emsi.portfolio.Exception.UsernameNotFoundException;

public interface UtilisateurDetailsService {
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	UserDetails loadUserByEmail(String email) throws EmailNotFoundException;

}
