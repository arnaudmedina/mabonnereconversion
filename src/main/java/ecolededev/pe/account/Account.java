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

import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.DetailFormation;
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

	
	@Column
	private String telephone;
		
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

	@OneToOne
	private Commune commune;
	
	@OneToOne
	private Situation situation;
	
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

	public Account() {

	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
		
	}

	public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

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
	
	
}
