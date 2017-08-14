package ecolededev.pe.home;

import java.util.List;

import ecolededev.pe.domaine.Mobilite;


/**
 * Created by Arnaud 11/08/2017
 */
public class FicheProfilGeographiqueForm
{
	private List<Mobilite> listeMobilites;
	private String codeMobilite;  //stocke le code mobilite selectionné
    private Mobilite infoMobilite;
    
	public List<Mobilite> getListeMobilites() {
		return listeMobilites;
	}

	public void setListeMetiers(List<Mobilite> listeMobilites) {
		this.listeMobilites = listeMobilites;
	}

	public String getCodeMobilite() {
		return codeMobilite;
	}

	public void setCodeMobilite(String codeMobilite) {
		this.codeMobilite = codeMobilite;
	}

	public Mobilite getInfoMobilite() {
		return infoMobilite;
	}

	public void setInfoMobilite(Mobilite infoMobilite) {
		this.infoMobilite = infoMobilite;
	}
	

}