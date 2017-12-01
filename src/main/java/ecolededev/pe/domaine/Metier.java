package ecolededev.pe.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="metiers")
public class Metier {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;
	
	@Column(name="qualifications")
	private String qualification;
	
	public Metier()
	{
		libelle = "";
		code = "";
		description = "";
		qualification = "";
	}
	
	public Metier(String libelle, String code, String description, String qualification) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.qualification = qualification;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
