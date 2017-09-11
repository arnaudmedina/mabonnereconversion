package ecolededev.pe.domaine;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nomformation")
public class NomFormation {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="diplome")
	private String diplome;
	
	
	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
