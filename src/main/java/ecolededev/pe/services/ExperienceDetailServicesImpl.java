package ecolededev.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecolededev.pe.domaine.ExperienceDetail;
import ecolededev.pe.domaine.UploadFile;
import ecolededev.pe.domaine.repository.IExperienceDetailRepository;
import ecolededev.pe.domaine.repository.IUploadFileRepository;


@Service
public class ExperienceDetailServicesImpl implements IExperienceDetailServices {
	@Autowired
	IExperienceDetailRepository experienceDetailRepository;

	@Autowired
	IUploadFileRepository uploadFileRepository; 
	
	@Override
	public ExperienceDetail  experienceUpdateDetail(ExperienceDetail experienceDetail) {
		return experienceDetailRepository.saveAndFlush(experienceDetail);
		
	}

	@Override
	public void experienceDeleteDetail(Long id) {
		experienceDetailRepository.delete(id);		
	}

	@Override
	public ExperienceDetail experienceDetail(Long id) {
		return experienceDetailRepository.findOne(id);	}

	@Override
	public void uploadFileSave(UploadFile uploadFile) {
		uploadFileRepository.saveAndFlush(uploadFile);
		
	}

}