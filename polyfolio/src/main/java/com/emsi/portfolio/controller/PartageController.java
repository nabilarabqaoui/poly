package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.PartageService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les partages")
@RestController
@RequestMapping("api/partage")
public class PartageController {
	final PartageService partageService ;
	
	public PartageController(PartageService partageService) {
		this.partageService = partageService;
	}
	

}
