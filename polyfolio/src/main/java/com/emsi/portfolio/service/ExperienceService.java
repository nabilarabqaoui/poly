package com.emsi.portfolio.service;
import com.emsi.portfolio.model.Experience;
import java.util.List;

public interface ExperienceService {
	
		List<Experience> getAllExperiences();
	    Experience getExperienceById(Long id);
	    Experience createExperience(Experience experience);
	    Experience updateExperience(Long id, Experience experienceDetails);
	    void deleteExperience(Long id);


}

