package ecolededev.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecolededev.pe.domaine.DetailCompetence;
import ecolededev.pe.domaine.repository.IDetailCompetenceRepository;

@Service
public class DetailCompetenceServicesImpl implements IDetailCompetenceServices {
	@Autowired
	IDetailCompetenceRepository detailCompetenceRepository;

	@Override
	public DetailCompetence detailCompetence(Long id) {
		return detailCompetenceRepository.findOne(id);
	}

	@Override
	public void updateDetailCompetence(DetailCompetence detailCompetence) {
		detailCompetenceRepository.saveAndFlush(detailCompetence);
	}

	@Override
	public void deleteDetailCompetence(Long id) {
		detailCompetenceRepository.delete(id);
	}
}