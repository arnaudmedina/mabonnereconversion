package ecolededev.pe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Metier;

@Service
public class MetiersServicesImpl implements IMetiersServices {

	@Override
	public List<Metier> listeMetiers() {

		List<Metier> listeMetiers = new ArrayList<>();

		Metier boulanger = new Metier();
		boulanger.setLibelle("Boulanger");
		boulanger.setCode("BOU");

		Metier facteur = new Metier();
		facteur.setLibelle("Facteur");
		facteur.setCode("FAC");

		Metier developpeur = new Metier();
		developpeur.setLibelle("Developpeur");
		developpeur.setCode("DEV");

		listeMetiers.add(boulanger);
		listeMetiers.add(facteur);
		listeMetiers.add(developpeur);

		return listeMetiers;
	}

}
