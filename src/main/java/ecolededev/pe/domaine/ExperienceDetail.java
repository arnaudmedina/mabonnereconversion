package ecolededev.pe.domaine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ecolededev.pe.account.Account;

/**
 * @author Utilisateur-SJD
 *
 */
@Entity
@Table(name="DetailExperience")
public class ExperienceDetail {
	@Id
	@GeneratedValue
	private Long id;

	@Column	
	private String nom;
	
	@Column	
	private String codeOgr;

	@Column	
	private Date  dateDebut;

	@Column	
	private Date  dateFin;
	
	// jsonignore pour éviter de rapatrier le account qd on récupère le détailExperience
	@OneToOne
	@JsonIgnore
	private Account account;

	@OneToOne
	private Metier metier;

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


	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeOgr() {
		return codeOgr;
	}

	public void setCodeOgr(String codeOgr) {
		this.codeOgr = codeOgr;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
