package ecolededev.pe.services.referentiel;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.repository.IMetiersRepository;

@Service
public class MetiersServicesImpl implements IMetiersServices {
	@Autowired
	IMetiersRepository iMetiersRepository;

	@PostConstruct
	protected void initialize() {
		// Initialisation de la table pour tests
//		save(new Metier("Boulangerie - viennoiserie", "BOU", "Prépare et réalise des produits de boulangerie et de viennoiserie selon les règles d'hygiène et de sécurité alimentaires. Peut effectuer la vente de produits de boulangerie, viennoiserie. Peut gérer un commerce de détail alimentaire (boulangerie, boulangerie-pâtisserie, ...).","Cet emploi/métier est accessible avec un diplôme de niveau CAP/ BEP à Bac (Bac professionnel, Brevet Professionnel) en boulangerie. Il est également accessible sans diplôme ni expérience professionnelle pour le poste d'aide-boulanger."));
//		save(new Metier("Plombier", "PLO", "Description du métier de plombier", "Qualifications du métier de plombier" ));
//		save(new Metier("Programmeur", "PRO", "Description du métier de programmeur", "Qualifications du métier de programmeur" ));
//		save(new Metier("Dentiste", "DEN":, "Description du métier de dentiste", "Qualifications du métier de dentiste" ));
	}

	@Transactional
	public Metier save(Metier metier) {
		iMetiersRepository.save(metier);
		return metier;
	}
	
	@Override
	public List<Metier> listeMetiers() {
		return iMetiersRepository.findAll();
	}

	public Metier infoMetier(String codeMetier) {
		Metier res = iMetiersRepository.findOneBycode(codeMetier);
		return res;
	}
}
