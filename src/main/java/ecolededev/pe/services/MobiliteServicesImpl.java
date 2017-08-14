package ecolededev.pe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Mobilite;

@Service
public class MobiliteServicesImpl implements IMobiliteServices {
	  @Autowired
	  IMobiliteRepository iMobiliteRepository;
	  
	@Override
	public List<Mobilite> listeMobilite() {

		return iMobiliteRepository.findAll();
	}
	
	public Mobilite infoMobilite(String codeMobilite){
		
		Mobilite res = iMobiliteRepository.findOneBycode(codeMobilite);
		
		return res;
	}
}
