package com.emsi.portfolio.service.impl;

import org.springframework.stereotype.Service;

import com.emsi.portfolio.service.ExperienceService;
import com.emsi.portfolio.model.Experience;
import com.emsi.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


@Service
public class ExperienceServiceImpl implements ExperienceService{
	
	private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
    
    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }
    
    @Override
    public Experience getExperienceById(Long id) {
        Optional<Experience> optionalExperience = experienceRepository.findById(id);
        return optionalExperience.orElse(null);
    }
    
    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }
    
    
    @Override
    public Experience updateExperience(Long id, Experience experienceDetails) {
        Optional<Experience> optionalExperience = experienceRepository.findById(id);
        if (optionalExperience.isPresent()) {
            Experience existingExperience = optionalExperience.get();

            existingExperience.setIntitule(experienceDetails.getIntitule());
            existingExperience.setTypeEmploi(experienceDetails.getTypeEmploi());
            existingExperience.setNomEntreprise(experienceDetails.getNomEntreprise());
            existingExperience.setLieu(experienceDetails.getLieu());
            existingExperience.setTypeLieu(experienceDetails.getTypeLieu());
            existingExperience.setEstEnCours(experienceDetails.getEstEnCours());
            existingExperience.setMoisDebut(experienceDetails.getMoisDebut());
            existingExperience.setMoisFin(experienceDetails.getMoisFin());
            existingExperience.setAnneeDebut(experienceDetails.getAnneeDebut());
            existingExperience.setAnneeFin(experienceDetails.getAnneeFin());
            existingExperience.setSecteur(experienceDetails.getSecteur());
            existingExperience.setDescription(experienceDetails.getDescription());
            existingExperience.setTitreProfil(experienceDetails.getTitreProfil());

            return experienceRepository.save(existingExperience);
        } else {
            return null;
        }
    }
    
    

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
        

}
