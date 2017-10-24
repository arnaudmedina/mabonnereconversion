package ecolededev.pe.domaine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abdel
 *
 */

	@Entity
	@Table(name="Experience")
	public class Experience {
		@Id
		@GeneratedValue
		private Long id;
		
	    @Column	
	    private String codeOgr;
	    
	    @Column	
	    private Date  dateDebut;
	    
	    @Column	
	    private Date  dateFin;

		@Column	
	    private String nom;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCodeOgr() {
			return codeOgr;
		}

		public void setCodeOgr(String codeOgr) {
			this.codeOgr = codeOgr;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public Date getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}
		
	}


