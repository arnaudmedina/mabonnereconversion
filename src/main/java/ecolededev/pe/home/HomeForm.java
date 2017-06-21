package ecolededev.pe.home;

import java.util.List;

import ecolededev.pe.domaine.Metier;



/**
 * Created by Promo_2 on 20/06/2017.
 */
public class HomeForm
{
	private List<Metier> listeMetiers;
	private String codeMetier;  //stocke le code métier selectionné
    private Metier infoMetier;
    
	public List<Metier> getListeMetiers() {
		return listeMetiers;
	}

	public void setListeMetiers(List<Metier> listeMetiers) {
		this.listeMetiers = listeMetiers;
	}

	public String getCodeMetier() {
		return codeMetier;
	}

	public void setCodeMetier(String codeMetier) {
		this.codeMetier = codeMetier;
	}

	public Metier getInfoMetier() {
		return infoMetier;
	}

	public void setInfoMetier(Metier infoMetier) {
		this.infoMetier = infoMetier;
	}
	

}