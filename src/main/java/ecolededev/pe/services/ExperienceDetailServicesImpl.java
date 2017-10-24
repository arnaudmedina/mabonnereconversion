package ecolededev.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecolededev.pe.domaine.ExperienceDetail;
import ecolededev.pe.domaine.repository.IExperienceDetailRepository;


@Service
public class ExperienceDetailServicesImpl implements IExperienceDetailServices {
	@Autowired
	IExperienceDetailRepository experienceDetailRepository;

	
	@Override
	public void experienceUpdateDetail(ExperienceDetail experienceDetail) {
		experienceDetailRepository.saveAndFlush(experienceDetail);
		
	}

	@Override
	public void experienceDeleteDetail(Long id) {
		experienceDetailRepository.delete(id);		
	}

	@Override
	public ExperienceDetail experienceDetail(Long id) {
		return experienceDetailRepository.findOne(id);	}

}