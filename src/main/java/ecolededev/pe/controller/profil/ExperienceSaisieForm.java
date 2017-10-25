package ecolededev.pe.controller.profil;

import java.util.Date;
import java.util.List;

import ecolededev.pe.account.Account;
import ecolededev.pe.domaine.Metier;

public class ExperienceSaisieForm {

	private String nom;
	private String codeOgr;
	private Date dateDebut;
	private Date dateFin;
	private String commentaire;
	private Metier metier; 
	private List<Metier> listMetiers;
	private Account  account;
	private Long idMetier;
	private Long idDetailExperience;
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCodeOgr() {
		return codeOgr;
	}
	public void setCodeOgr(String codeOgr) {
		this.codeOgr = codeOgr;
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
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Metier getMetier() {
		return metier;
	}
	public void setMetier(Metier metier) {
		this.metier = metier;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getIdMetier() {
		return idMetier;
	}
	public void setIdMetier(Long idMetier) {
		this.idMetier = idMetier;
	}
	public Long getIdDetailExperience() {
		return idDetailExperience;
	}
	public void setIdDetailExperience(Long idDetailExperience) {
		this.idDetailExperience = idDetailExperience;
	}
	public List<Metier> getListMetiers() {
		return listMetiers;
	}
	public void setListMetiers(List<Metier> listMetiers) {
		this.listMetiers = listMetiers;
	}

}


