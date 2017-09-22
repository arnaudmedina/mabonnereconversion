package ecolededev.pe.services.referentiel;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.repository.IMobiliteRepository;

@Service
public class MobiliteServicesImpl implements IMobiliteServices {
	@Autowired
	IMobiliteRepository iMobiliteRepository;

	@PostConstruct
	protected void initialize() {
//		save(new Mobilite("MON","Monde"));
//		save(new Mobilite("EUR","Europe"));
//		save(new Mobilite("AFR","Afrique"));
//		save(new Mobilite("ASI","Asie"));
//		save(new Mobilite("AME","Amérique"));
//		save(new Mobilite("OCE","Océanie"));
//		save(new Mobilite("FRA","France"));
//		save(new Mobilite("REG","Région"));
//		save(new Mobilite("DEP","Département"));
//		save(new Mobilite("COM","Commune"));
//		save(new Mobilite("TES","Test"));
	}

	@Transactional
	public Mobilite save(Mobilite mobilite) {
		iMobiliteRepository.save(mobilite);
		return mobilite;
	}
	
	@Override
	public List<Mobilite> listeMobilite() {
		return iMobiliteRepository.findAll();
	}

	public Mobilite getMobilite(Long idMobilite) {
		return iMobiliteRepository.findOne(idMobilite);
	}

	public Mobilite infoMobilite(String codeMobilite) {
		Mobilite res = iMobiliteRepository.findOneBycode(codeMobilite);
		return res;
	}
}
