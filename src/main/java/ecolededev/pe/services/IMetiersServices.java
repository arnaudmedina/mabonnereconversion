package ecolededev.pe.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import ecolededev.pe.domaine.Metier;


public interface IMetiersServices {

	public List <Metier> listeMetiers();
	public Metier infoMetier(String codeMetier);
	}
