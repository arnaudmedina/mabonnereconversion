package ecolededev.pe.services.referentiel;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.repository.INomFormationRepository;

@Service
public class NomFormationServicesImpl implements INomFormationServices {
	@Autowired
	INomFormationRepository iNomFormationRepository;
	
	@PostConstruct
	protected void initialize() {
		// Initialisation des noms de formations pour tests
		// save(new NomFormation("CAP"));
		// save(new NomFormation("Brevet des collèges"));
		// save(new NomFormation("Bac"));
		// save(new NomFormation("DUT"));
		// save(new NomFormation("DEUG"));
		// save(new NomFormation("Master"));
		// save(new NomFormation("Doctorat"));
	}

	@Transactional
	public NomFormation save(NomFormation nomFormation) {
		iNomFormationRepository.save(nomFormation);
		return nomFormation;
	}
	
	@Override
	public List<NomFormation> listeNomFormation() {

		return iNomFormationRepository.findAll();
	}
}
