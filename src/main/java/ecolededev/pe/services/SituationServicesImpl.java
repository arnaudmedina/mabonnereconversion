package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Situation;
import ecolededev.pe.domaine.repository.ISituationRepository;

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
