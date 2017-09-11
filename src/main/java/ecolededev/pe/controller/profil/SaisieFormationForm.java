package ecolededev.pe.controller.profil;

import java.util.List;

import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;

public class SaisieFormationForm {

	private List<NomFormation> nomFormations ;
	private List<NomSpecialite> nomSpecialites;
	private String annee;
	private String ecole;
	private Long idNomFormation;
	private Long idNomSpecialite;
	
	public List<NomFormation> getNomFormations() {
		return nomFormations;
	}
	public void setNomFormations(List<NomFormation> nomFormations) {
		this.nomFormations = nomFormations;
	}
	public List<NomSpecialite> getNomSpecialites() {
		return nomSpecialites;
	}
	public void setNomSpecialites(List<NomSpecialite> nomSpecialites) {
		this.nomSpecialites = nomSpecialites;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public Long getIdNomFormation() {
		return idNomFormation;
	}
	public void setIdNomFormation(Long idNomFormation) {
		this.idNomFormation = idNomFormation;
	}
	public Long getIdNomSpecialite() {
		return idNomSpecialite;
	}
	public void setIdNomSpecialite(Long idNomSpecialite) {
		this.idNomSpecialite = idNomSpecialite;
	}
}


