package ecolededev.pe.controller.profil;

import java.util.List;

import javax.persistence.Column;

import ecolededev.pe.domaine.Competence;
import ecolededev.pe.domaine.CompetenceTypes;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;

public class CompetenceSaisieForm {

	private List<Competence> competences ;
	private List<CompetenceTypes> competenceTypes;
	private Integer niveau;
	private Long dureeExperience;
	private Integer anneeDerniereExperience;   
	private String commentaire;
	private Long idCompetence;
	private Long idCompetenceType;
	private Long idDetailCompetence;
	
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	public List<CompetenceTypes> getCompetenceTypes() {
		return competenceTypes;
	}
	public void setCompetenceTypes(List<CompetenceTypes> competenceTypes) {
		this.competenceTypes = competenceTypes;
	}
	public Integer getNiveau() {
		return niveau;
	}
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	public Long getDureeExperience() {
		return dureeExperience;
	}
	public void setDureeExperience(Long dureeExperience) {
		this.dureeExperience = dureeExperience;
	}
	public Integer getAnneeDerniereExperience() {
		return anneeDerniereExperience;
	}
	public void setAnneeDerniereExperience(Integer anneeDerniereExperience) {
		this.anneeDerniereExperience = anneeDerniereExperience;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Long getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(Long idCompetence) {
		this.idCompetence = idCompetence;
	}
	public Long getIdCompetenceType() {
		return idCompetenceType;
	}
	public void setIdCompetenceType(Long idCompetenceType) {
		this.idCompetenceType = idCompetenceType;
	}
	public Long getIdDetailCompetence() {
		return idDetailCompetence;
	}
	public void setIdDetailCompetence(Long idDetailCompetence) {
		this.idDetailCompetence = idDetailCompetence;
	}

	


}


