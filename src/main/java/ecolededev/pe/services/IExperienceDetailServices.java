package ecolededev.pe.services;

import ecolededev.pe.domaine.ExperienceDetail;

public interface IExperienceDetailServices {

	void experienceUpdateDetail(ExperienceDetail experienceDetail);

	void experienceDeleteDetail(Long id);
	
	ExperienceDetail experienceDetail(Long id);
		
}
