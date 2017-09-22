package ecolededev.pe.services.referentiel;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.repository.ICommuneRepository;

@Service
public class CommuneServicesImpl implements ICommuneServices {
	@Autowired
	ICommuneRepository iCommuneRepository;

	@PostConstruct
	protected void initialize() {
//		save(new Commune("Bayonne", "64100"));
//		save(new Commune("Paris", "75000"));
//		save(new Commune("Montreuil", "93100"));
//		save(new Commune("Fontenay Sous Bois", "94120"));
	}

	@Transactional
	public Commune save(Commune commune) {
		iCommuneRepository.save(commune);
		return commune;
	}

	@Override
	public List<Commune> listeCommune() {
		return iCommuneRepository.findAll();
	}

	public Commune infoCommune(String codePostal) {
		Commune res = iCommuneRepository.findOneBycodePostal(codePostal);
		return res;
	}
}
