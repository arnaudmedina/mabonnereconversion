package ecolededev.pe.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.home.SaisieFormationForm;


public interface INomFormationServices {

	public List <NomFormation> listeNomFormation();
	
	}
