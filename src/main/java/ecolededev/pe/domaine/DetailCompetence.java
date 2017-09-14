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
@Table(name="DetailCompetence")
public class DetailCompetence {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private Competence competence;
	
	@OneToOne
	private CompetenceType competenceType;
	
	@Column 
	private Integer niveau;
	
	@Column 
	private Long dureeExperience;
	
    @Column	
    private Integer anneeDerniereExperience;
    
    @Column	
    private String commentaire;
}
