package ecolededev.pe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Metier;

@Service
public class MetiersServicesImpl implements IMetiersServices {
	  @Autowired
	  IMetiersRepository iMetiersRepository;
	  
	@Override
	public List<Metier> listeMetiers() {

		return iMetiersRepository.findAll();
	}
	
	public Metier infoMetier(String codeMetier){
		
		Metier res = iMetiersRepository.findOneBycode(codeMetier);
		
		 
		 
		
		return res;
	}
}
