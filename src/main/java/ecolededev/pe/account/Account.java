package ecolededev.pe.account;

import javax.persistence.*;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ecolededev.pe.domaine.Commune;
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
	private String telephone;	

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

	@OneToOne
	private Commune commune;
	
	@OneToOne
	private Situation situation;

	@Column(name="mobilite")
	private String mobilite;

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

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public String getMobilite() {
		return mobilite;
	}

	public void setMobilite(String mobilite) {
		this.mobilite = mobilite;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
	
}
