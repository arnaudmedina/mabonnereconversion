package ecolededev.pe.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nomspecialite")
public class NomSpecialite {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="specialite")
	private String specialite;
	
	public NomSpecialite() {
		super();
	}
	
	public NomSpecialite(String specialite) {
		super();
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
