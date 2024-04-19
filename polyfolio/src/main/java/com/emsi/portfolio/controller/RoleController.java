package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.portfolio.service.RoleService;

import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les roles")
@RestController
@RequestMapping("api/role")
public class RoleController {
	final RoleService roleService ;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	

}
