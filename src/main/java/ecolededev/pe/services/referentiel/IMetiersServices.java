package ecolededev.pe.services.referentiel;

import java.util.List;

import ecolededev.pe.domaine.Metier;


public interface IMetiersServices {

	public List <Metier> listeMetiers();
	public Metier infoMetier(String codeMetier);
	}
