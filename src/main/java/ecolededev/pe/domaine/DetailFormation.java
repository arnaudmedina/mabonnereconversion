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
@Table(name="Detailformation")
public class DetailFormation {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private NomFormation nomFormation;
	
	@OneToOne
	private NomSpecialite nomSpecialite;
	
	@Column(name="ecole")
	private String ecole;
	
	@Column(name="annee")
	private String annee;

	public Long getId() {
		return id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public NomFormation getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(NomFormation nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public NomSpecialite getNomSpecialite() {
		return nomSpecialite;
	}

	public void setNomSpecialite(NomSpecialite nomSpecialite) {
		this.nomSpecialite = nomSpecialite;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
