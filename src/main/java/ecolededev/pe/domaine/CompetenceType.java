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
@Table(name="CompetenceType")
public class CompetenceType {
	@Id
	@GeneratedValue
	private Long id;
	
	// Le SKILL_TYPE_CODE sera fourni par le ROME
    @Column	
    private String skillTypeCode;

	@Column	
    private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillTypeCode() {
		return skillTypeCode;
	}

	public void setSkillTypeCode(String skillTypeCode) {
		this.skillTypeCode = skillTypeCode;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}