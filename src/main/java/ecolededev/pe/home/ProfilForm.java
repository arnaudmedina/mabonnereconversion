package ecolededev.pe.home;

import java.util.List;

import ecolededev.pe.account.Account;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.Situation;



public class ProfilForm
{
	private Account account;
	private String situation;
	private String codeMobilite;
	private List<Situation> listeSituation;
	private List<Commune> listeCommune;
	private List<Mobilite> listeMobilite;
	private String codePostal;  

	public List<Commune> getListeCommune() {
		return listeCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setListeCommune(List<Commune> listeCommune) {
		this.listeCommune = listeCommune;
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

	public String getCodeMobilite() {
		return codeMobilite;
	}

	public void setCodeMobilite(String codeMobilite) {
		this.codeMobilite = codeMobilite;
	}

	public List<Mobilite> getListeMobilite() {
		return listeMobilite;
	}

	public void setListeMobilite(List<Mobilite> listeMobilite) {
		this.listeMobilite = listeMobilite;
	}



}