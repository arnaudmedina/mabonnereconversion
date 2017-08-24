package ecolededev.pe.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.Metier;


public interface ICommuneServices {

	public List <Commune> listeCommune();
	public Commune infoCommune(String codePostal);
	}
