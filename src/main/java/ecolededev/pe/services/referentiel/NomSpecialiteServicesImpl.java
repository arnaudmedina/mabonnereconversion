package ecolededev.pe.services.referentiel;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.domaine.repository.INomSpecialiteRepository;

@Service
public class NomSpecialiteServicesImpl implements INomSpecialiteServices {
	  @Autowired
	  INomSpecialiteRepository iNomSpecialiteRepository;

		@PostConstruct
		protected void initialize() {
// Initialisation de la table pour une base vide
//			 save(new NomSpecialite("Français"));
//			 save(new NomSpecialite("Littérature"));
//			 save(new NomSpecialite("Philosophie"));
//			 save(new NomSpecialite("Mathématiques"));
//			 save(new NomSpecialite("Chimie"));
//			 save(new NomSpecialite("Informatique"));
//			 save(new NomSpecialite("Hôtellerie"));
		}

		@Transactional
		public NomSpecialite save(NomSpecialite nomSpecialite) {
			iNomSpecialiteRepository.save(nomSpecialite);
			return nomSpecialite;
		}
	  
	@Override
	public List<NomSpecialite> nomSpecialites() {
		// TODO Auto-generated method stub
		return iNomSpecialiteRepository.findAll();
	}
}
