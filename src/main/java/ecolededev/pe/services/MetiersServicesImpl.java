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
	
	public Metier infoMetier(String codeMetier){
		
		Metier res = new Metier();
		
		switch (codeMetier) {
		
		case "BOU":
			res.setCode(codeMetier);
			res.setLibelle("Boulangerie - viennoiserie");
			res.setDescription("Prépare et réalise des produits de boulangerie et de viennoiserie selon les règles d'hygiène et de sécurité alimentaires. Peut effectuer la vente de produits de boulangerie, viennoiserie. Peut gérer un commerce de détail alimentaire (boulangerie, boulangerie-pâtisserie, ...).");
			res.setQualification("Cet emploi/métier est accessible avec un diplôme de niveau CAP/ BEP à Bac (Bac professionnel, Brevet Professionnel) en boulangerie. Il est également accessible sans diplôme ni expérience professionnelle pour le poste d'aide-boulanger.");
			break;
		case "FAC":
			res.setCode(codeMetier);
			res.setLibelle("Distribution de documents");
			res.setDescription("Prépare et effectue la distribution de documents (courriers, colis, catalogues, journaux, prospectus, publicité, ...) auprès de particuliers, d'entreprises selon des consignes et des impératifs de délais. Peut effectuer des opérations monétaires (encaissements contre remboursement, ...). "
					+ "Peut réaliser des opérations de collecte et d'expédition d'objets. Peut coordonner une équipe.");
			res.setQualification("Cet emploi/métier est accessible sans diplôme ni expérience professionnelle. Un diplôme de niveau fin de cycle secondaire (Brevet des collèges, ...) est requis pour l'emploi de facteur.Un permis (A1, A, B, bateau) peut être demandé selon le type de véhicule utilisé.La possession du Brevet de Sécurité Routière -BSR- est obligatoire pour la conduite des véhicules deux roues motorisés de moins de 50 cm3.");
			break;
			
		case "DEV":
			res.setCode(codeMetier);
			res.setLibelle("Études et développement informatique");
			res.setDescription("Conçoit, développe et met au point un projet d'application informatique, de la phase d'étude à son intégration, pour un client ou une entreprise selon des besoins fonctionnels et un cahier des charges. Peut conduire des projets de développement....");
			res.setQualification("Cet emploi/métier est accessible avec un diplôme de niveau Bac+2 (BTS, DUT) à Master (MIAGE, diplôme d'ingénieur, Master professionnel, ...) en informatique. Il est également accessible avec une expérience professionnelle en informatique, système...");
			break;
			
		}
		
		
		
		return res;
	}
}
