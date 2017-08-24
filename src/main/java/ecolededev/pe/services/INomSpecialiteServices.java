package ecolededev.pe.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.home.SaisieFormationForm;


public interface INomSpecialiteServices {

	public List <NomSpecialite> nomSpecialites();
	
	}
