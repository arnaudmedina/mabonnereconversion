package ecolededev.pe.services;

import ecolededev.pe.domaine.CompetenceDetail;

public interface ICompetenceDetailServices {

	void competenceUpdateDetail(CompetenceDetail competenceDetail);

	void competenceDeleteDetail(Long id);

	CompetenceDetail competenceDetail(Long id);

}
