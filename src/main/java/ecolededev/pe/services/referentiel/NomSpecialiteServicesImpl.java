package ecolededev.pe.services.referentiel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.controller.profil.SaisieFormationForm;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.domaine.repository.INomSpecialiteRepository;

@SuppressWarnings("unused")
@Service
public class NomSpecialiteServicesImpl implements INomSpecialiteServices {
	  @Autowired
	  INomSpecialiteRepository iNomSpecialiteRepository;

	@Override
	public List<NomSpecialite> nomSpecialites() {
		// TODO Auto-generated method stub
		
		return iNomSpecialiteRepository.findAll();
	}
	
	
}
