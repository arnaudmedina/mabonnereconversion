package ecolededev.pe.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ecolededev.pe.account.Account;

/**
 * @author Utilisateur-SJD
 *
 */
@Entity
@Table(name="DetailCompetence")
public class CompetenceDetail {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private Competence competence;
	
	@OneToOne
	private CompetenceType competenceType;
	
	@Column 
	private Integer niveau;
	
	@Column 
	private Long dureeExperience;
	
    @Column	
    private Integer anneeDerniereExperience;
    
    @Column	
    private String commentaire;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public CompetenceType getCompetenceType() {
		return competenceType;
	}

	public void setCompetenceType(CompetenceType competenceType) {
		this.competenceType = competenceType;
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
    
    
}
