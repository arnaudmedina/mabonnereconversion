package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.repository.INomFormationRepository;

@Service
public class NomFormationServicesImpl implements INomFormationServices {
	@Autowired
	INomFormationRepository iNomFormationRepository;

	@Override
	public List<NomFormation> listeNomFormation() {

		return iNomFormationRepository.findAll();
	}
}
