package ecolededev.pe.controller.profil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecolededev.pe.account.AccountController;
import ecolededev.pe.domaine.Competence;
import ecolededev.pe.domaine.CompetenceType;

public class CompetenceSaisieForm {

    static final Logger logger = LoggerFactory.getLogger(CompetenceSaisieForm.class);

	private List<Competence> competences ;
	private List<CompetenceType> competenceTypes;
	private Integer niveau;
	private Long dureeExperience;
	private Integer anneeDerniereExperience;   
	private String commentaire;
	private Long idCompetence;
	private Long idCompetenceType;
	private Long idDetailCompetence;
	
	public List<Competence> getCompetences() {
		logger.info("Passage dans la méthode getCompetences !");
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		logger.info("Passage dans la méthode setCompetences !");
		this.competences = competences;
	}
	public List<CompetenceType> getCompetenceTypes() {
		logger.info("Passage dans la méthode getCompetencesTypes !");
		return competenceTypes;
	}
	public void setCompetenceTypes(List<CompetenceType> competenceTypes) {
		logger.info("Passage dans la méthode setCompetencesTypes !");
		this.competenceTypes = competenceTypes;
	}
	public Integer getNiveau() {
		logger.info("Passage dans la méthode getNiveau !");
		return niveau;
	}
	public void setNiveau(Integer niveau) {
		logger.info("Passage dans la méthode setNiveau !");
		this.niveau = niveau;
	}
	public Long getDureeExperience() {
		logger.info("Passage dans la méthode getDureeExperience !");
		return dureeExperience;
	}
	public void setDureeExperience(Long dureeExperience) {
		logger.info("Passage dans la méthode setDureeExperience !");
		this.dureeExperience = dureeExperience;
	}
	public Integer getAnneeDerniereExperience() {
		logger.info("Passage dans la méthode getAnneeDerniereExperience !");
		return anneeDerniereExperience;
	}
	public void setAnneeDerniereExperience(Integer anneeDerniereExperience) {
		logger.info("Passage dans la méthode setAnneeDerniereExperience !");
		this.anneeDerniereExperience = anneeDerniereExperience;
	}
	public String getCommentaire() {
		logger.info("Passage dans la méthode getCommentaire !");
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		logger.info("Passage dans la méthode setCommentaire !");
		this.commentaire = commentaire;
	}
	public Long getIdCompetence() {
		logger.info("Passage dans la méthode getIdCompetence !");
		return idCompetence;
	}
	public void setIdCompetence(Long idCompetence) {
		logger.info("Passage dans la méthode setIdCompetence !");
		this.idCompetence = idCompetence;
	}
	public Long getIdCompetenceType() {
		logger.info("Passage dans la méthode getIdCompetenceType !");
		return idCompetenceType;
	}
	public void setIdCompetenceType(Long idCompetenceType) {
		logger.info("Passage dans la méthode setIdCompetenceType !");
		this.idCompetenceType = idCompetenceType;
	}
	public Long getIdDetailCompetence() {
		logger.info("Passage dans la méthode getIdDetailCompetence !");
		return idDetailCompetence;
	}
	public void setIdDetailCompetence(Long idDetailCompetence) {
		logger.info("Passage dans la méthode setIdDetailCompetence !");
		this.idDetailCompetence = idDetailCompetence;
	}

	
}


