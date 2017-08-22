package ecolededev.pe.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;


import ecolededev.pe.domaine.Situation;


public interface ISituationServices {

	public List <Situation> listeSituation();
	public Situation infoSituation(String code);
	}
