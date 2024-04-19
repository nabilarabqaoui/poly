package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.UtilisateurService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les utilisateurs")
@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurController {
	final UtilisateurService utilisateurService ;
	
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	

}
