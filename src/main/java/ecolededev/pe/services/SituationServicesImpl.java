package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.ICommuneRepository;
import ecolededev.pe.domaine.IMetiersRepository;
import ecolededev.pe.domaine.ISituationRepository;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.Situation;

@Service
public class SituationServicesImpl implements ISituationServices {
	  @Autowired 
	  ISituationRepository iSituationRepository;
	  
	@Override
	public List<Situation> listeSituation() {

		return iSituationRepository.findAll();
	}
	
	public Situation infoSituation(String code){
		
		Situation res = iSituationRepository.findOneBycode(code);
		
		return res;
	}
}
