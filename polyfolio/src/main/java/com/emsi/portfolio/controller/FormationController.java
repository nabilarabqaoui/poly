package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.FormationService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les formations")
@RestController
@RequestMapping("api/formation")
public class FormationController {
	final FormationService formationService ;
	
	public FormationController(FormationService formationService) {
		this.formationService = formationService;
	}
	

}
