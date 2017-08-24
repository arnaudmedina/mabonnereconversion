package ecolededev.pe.account;



import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

<<<<<<< HEAD
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.DetailFormation;
=======
import ecolededev.pe.domaine.AccountFormation;
import ecolededev.pe.domaine.Commune;
>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.Situation;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@Column
	private String prenom;	

	@Column
	private String telephoneFixe;	

	@Column
	private String telephoneMobile;
	
	@Column(unique = true)
	private String email;

<<<<<<< HEAD
	
	@Column
	private String telephone;
		
=======
>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

	@OneToOne
	private Commune commune;
	
	@OneToOne
	private Situation situation;
<<<<<<< HEAD
	
	@OneToOne
	private Mobilite mobilite;
	
	@OneToMany (mappedBy = "account")
    private List<DetailFormation> detailFormations ;

	public List<DetailFormation> getDetailFormations() {
		return detailFormations;
	}

	public void setDetailFormations(List<DetailFormation> detailFormations) {
		this.detailFormations = detailFormations;
	}

=======

	@OneToOne
	private Mobilite mobilite;
	
	@OneToMany (targetEntity=AccountFormation.class)
	private List<AccountFormation> accountFormation;
	
>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
	public Account() {

	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
<<<<<<< HEAD
		
=======

>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
	}

	public Long getId() {
		return id;
	}

<<<<<<< HEAD
    public void setId(Long id) {
		this.id = id;
	}

=======
>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}

<<<<<<< HEAD
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	

	public Mobilite getMobilite() {
		return mobilite;
	}

	public void setMobilite(Mobilite mobilite) {
		this.mobilite = mobilite;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}
	
=======
	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

		public void setId(Long id) {
		this.id = id;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public Mobilite getMobilite() {
		return mobilite;
	}

	public void setMobilite(Mobilite mobilite) {
		this.mobilite = mobilite;
	}

	public List<AccountFormation> getAccountFormation() {
		return accountFormation;
	}

	public void setAccountFormation(List<AccountFormation> accountFormation) {
		this.accountFormation = accountFormation;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}
>>>>>>> branch 'master' of https://github.com/arnaudmedina/mabonnereconversion.git
	
	
}
