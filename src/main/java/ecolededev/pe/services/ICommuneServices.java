package ecolededev.pe.services;

import java.util.List;

import ecolededev.pe.domaine.Commune;


public interface ICommuneServices {

	public List <Commune> listeCommune();
	public Commune infoCommune(String codePostal);
	}
