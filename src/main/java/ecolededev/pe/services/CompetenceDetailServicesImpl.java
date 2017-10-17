package ecolededev.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecolededev.pe.domaine.CompetenceDetail;
import ecolededev.pe.domaine.repository.ICompetenceDetailRepository;


@Service
public class CompetenceDetailServicesImpl implements ICompetenceDetailServices {
	@Autowired
	ICompetenceDetailRepository detailCompetenceRepository;

	@Override
	public void competenceUpdateDetail(CompetenceDetail competenceDetail) {
		detailCompetenceRepository.saveAndFlush(competenceDetail);
	}

	@Override
	public void competenceDeleteDetail(Long id) {
		detailCompetenceRepository.delete(id);
	}

	@Override
	public CompetenceDetail competenceDetail(Long id) {
		return detailCompetenceRepository.findOne(id);
	}

}