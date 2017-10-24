package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Experience;
import ecolededev.pe.domaine.repository.IExperienceRepository;
import ecolededev.pe.services.referentiel.IExperienceServices;

@Service
public class ExperienceServicesImpl implements IExperienceServices {

	@Autowired
	IExperienceRepository iExperienceRepository;

	@Override
	public List<Experience> listeExperience() {
		return iExperienceRepository.findAll();
	}

}
