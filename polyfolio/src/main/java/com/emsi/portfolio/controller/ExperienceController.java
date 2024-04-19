package com.emsi.portfolio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.emsi.portfolio.model.Experience;
import com.emsi.portfolio.service.impl.ExperienceServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import io.swagger.annotations.Api;

@Api("Cette end-point permet de gérer les experiences")
@RestController
@RequestMapping("api/experience")
public class ExperienceController {
	final ExperienceServiceImpl experienceServiceimpl ;
	
	@Autowired
    public ExperienceController(ExperienceServiceImpl experienceServiceimpl) {
        this.experienceServiceimpl = experienceServiceimpl;
	}
	
	@GetMapping("/")
    public List<Experience> getAllExperiences() {
        return experienceServiceimpl.getAllExperiences();
    }
	
	  @GetMapping("/{id}")
	    public Experience getExperienceById(@PathVariable Long id) {
	        return experienceServiceimpl.getExperienceById(id);
	    }

	 
	 @PostMapping("/")
	    public Experience createExperience(@RequestBody Experience experience) {
	        return experienceServiceimpl.createExperience(experience);
	    }
	 
	 @PutMapping("/{id}")
	    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experienceDetails) {
	        return experienceServiceimpl.updateExperience(id, experienceDetails);
	    }
	 
	 @DeleteMapping("/{id}")
	    public void deleteExperience(@PathVariable Long id) {
	        experienceServiceimpl.deleteExperience(id);
	    }
	

}
