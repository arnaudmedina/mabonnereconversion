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
}
