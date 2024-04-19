package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.CompetenceService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les competences")
@RestController
@RequestMapping("api/competence")
public class CompetenceController {
	final CompetenceService competenceService ;
	
	public CompetenceController(CompetenceService competenceService) {
		this.competenceService = competenceService;
	}
	

}
