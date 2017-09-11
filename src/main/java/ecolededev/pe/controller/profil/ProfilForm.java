package ecolededev.pe.controller.profil;

import java.util.List;

import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.account.Account;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.Situation;

/**
 * Created by phil 21/08/2017
 */
public class ProfilForm {
	private Account account;
	private String situation;
	private List<Long> idsMobilite; // Liste des mobilités sélectionnées
	private List<Situation> listeSituation;
	private List<Commune> listeCommune;
	private List<Mobilite> listeMobilite; // la liste de l'ensemble des
											// mobilités dans la base
	private String codePostal;

	private List<DetailFormation> listeFormation;
	private DetailFormation infoFormation;

	private List<NomFormation> listeNomFormation;

	public List<NomFormation> getListeNomFormation() {
		return listeNomFormation;
	}

	public List<Long> getIdsMobilite() {
		return idsMobilite;
	}

	public void setIdsMobilite(List<Long> idsMobilite) {
		this.idsMobilite = idsMobilite;
	}

	public void setListeNomFormation(List<NomFormation> listeNomFormation) {
		this.listeNomFormation = listeNomFormation;
	}

	public List<DetailFormation> getListeFormation() {
		return listeFormation;
	}

	public void setListeFormation(List<DetailFormation> listeFormation) {
		this.listeFormation = listeFormation;
	}

	public DetailFormation getInfoFormation() {
		return infoFormation;
	}

	public void setInfoFormation(DetailFormation infoFormation) {
		this.infoFormation = infoFormation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public List<Situation> getListeSituation() {
		return listeSituation;
	}

	public void setListeSituation(List<Situation> listeSituation) {
		this.listeSituation = listeSituation;
	}

	public List<Commune> getListeCommune() {
		return listeCommune;
	}

	public void setListeCommune(List<Commune> listeCommune) {
		this.listeCommune = listeCommune;
	}

	public List<Mobilite> getListeMobilite() {
		return listeMobilite;
	}

	public void setListeMobilite(List<Mobilite> listeMobilite) {
		this.listeMobilite = listeMobilite;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}