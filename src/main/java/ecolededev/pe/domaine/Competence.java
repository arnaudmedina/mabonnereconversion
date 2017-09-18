package ecolededev.pe.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Arnaud
 *
 */

@Entity
@Table(name="Competence")
public class Competence {
	@Id
	@GeneratedValue
	private Long id;
	
    @Column	
    private String codeOGR;

	@Column	
    private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeOGR() {
		return codeOGR;
	}

	public void setCodeOGR(String codeOGR) {
		this.codeOGR = codeOGR;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
