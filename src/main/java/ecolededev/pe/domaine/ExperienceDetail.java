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
@Table(name="DetailExperience")
public class ExperienceDetail {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private Experience experience;
	
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

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
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
   
}
