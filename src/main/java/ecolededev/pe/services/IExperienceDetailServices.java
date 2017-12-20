package ecolededev.pe.services;

import ecolededev.pe.domaine.ExperienceDetail;
import ecolededev.pe.domaine.UploadFile;

public interface IExperienceDetailServices {

	ExperienceDetail experienceUpdateDetail(ExperienceDetail experienceDetail);

	void experienceDeleteDetail(Long id);
	
	ExperienceDetail experienceDetail(Long id);
	
	void uploadFileSave(UploadFile uploadFile);
		
}
