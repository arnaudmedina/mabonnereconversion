package ecolededev.pe.services;



import ecolededev.pe.domaine.DetailCompetence;



public interface IDetailCompetenceServices {
	
	public DetailCompetence detailCompetence(Long id);
	public void updateDetailCompetence(DetailCompetence detailCompetence);
	public void deleteDetailCompetence(Long id);
	}
