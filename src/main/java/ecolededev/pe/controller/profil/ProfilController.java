package ecolededev.pe.controller.profil;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecolededev.pe.account.Account;
import ecolededev.pe.account.AccountService;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.DetailCompetence;
import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.domaine.Situation;
import ecolededev.pe.services.IDetailFormationServices;
import ecolededev.pe.services.referentiel.ICommuneServices;
import ecolededev.pe.services.referentiel.IMobiliteServices;
import ecolededev.pe.services.referentiel.INomFormationServices;
import ecolededev.pe.services.referentiel.INomSpecialiteServices;
import ecolededev.pe.services.referentiel.ISituationServices;

@Controller
class ProfilController {

	@Autowired
	private ICommuneServices communeService;

	@Autowired
	private ISituationServices situationService;

	@Autowired
	private IMobiliteServices mobilitesService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private IDetailFormationServices detailFormationServices;

	@Autowired
	private IDetailFormationServices detailCompetenceServices;

	@Autowired
	private INomFormationServices nomFormationService; // mettre le nom de
														// l'interface et pas le
														// nom de
														// l'implémentation

	@Autowired
	private INomSpecialiteServices specialiteServices; // mettre le nom de
														// l'interface et pas le
														// nom de
														// l'implémentation

	@GetMapping("displayProfil")
	String displayProfil(Principal principal, Model model) {
		Account account = accountService.loadUserByEmail(principal.getName());

		ProfilForm profilForm = (ProfilForm) model.asMap().get("profilForm");
		if (profilForm == null) {
			profilForm = new ProfilForm();
			profilForm.setAccount(account);

			List<DetailFormation> formations = accountService.listeFormation(account.getId());
			List<DetailCompetence> competences = accountService.listeCompetences(account.getId());

			model.addAttribute("formations", formations);
			model.addAttribute("competences", competences);

			model.addAttribute("profilForm", profilForm);
			List<Commune> communeList = communeService.listeCommune();
			profilForm.setListeCommune(communeList);

			List<Situation> situationList = situationService.listeSituation();
			profilForm.setListeSituation(situationList);

			List<Mobilite> mobiliteList = mobilitesService.listeMobilite();
			profilForm.setListeMobilite(mobiliteList);

			// Alimenter la liste des mobilités choisies
			List<Long> listeIdsMobilite = new ArrayList<>();
			for (Mobilite maMobilite : accountService.listeMobilites(account.getId())) {
				listeIdsMobilite.add(maMobilite.getId());
			}
			profilForm.setIdsMobilite(listeIdsMobilite);

			return "profil/profil";
		} else
			return "profil/profil";

	}

	@PostMapping("saveEtatCivil") // parametre action balise FORM de la page
	// profil
	String saveEtatCivil(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) { // methode
																								// saveEtatCivil
																								// envoie
																								// profilForm
																								// vers
																								// le

		Account accountBase = accountService.loadUserByEmail(principal.getName());
		Account account = profilForm.getAccount();
		accountBase.setNom(account.getNom());
		accountBase.setPrenom(account.getPrenom());
		accountBase.setTelephoneFixe(account.getTelephoneFixe());
		accountBase.setTelephoneMobile(account.getTelephoneMobile());
		accountBase.setCommune(account.getCommune());
		accountBase.setSituation(account.getSituation());
		accountService.save(accountBase); // sauvegarde des informations
		// de accountBase (Nom, Prenom ...)

		return "redirect:/displayProfil"; // redirection vers
		// l'écran d'affichage des informations
		// de l'état civil

	}

	@PostMapping("defineMobilite") // Paramètre action balise FORM de la page
	// ficheProfilGeographique
	String defineMobilite(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) { // methode
																								// sInfomer
																								// envoie
																								// homeForm
																								// vers
																								// le

		Account accountBase = accountService.loadUserByEmail(principal.getName());
		// Account account = profilForm.getAccount();

		List<Long> idsMobilite = profilForm.getIdsMobilite();

		// On prépare une liste d'objets mobilité
		List<Mobilite> mesMobilites = new ArrayList<>();
		Mobilite uneMobilite;
		for (Long idMobilite : idsMobilite) {
			uneMobilite = new Mobilite();
			uneMobilite.setId(idMobilite);
			// Seul l'id est utile, on ne renseigne pas les autres attributs
			mesMobilites.add(uneMobilite);
		}
		accountBase.setListeMobilites(mesMobilites);
		accountService.save(accountBase); // sauvegarde des informations
		// de accountBase (Mobilité)
		return "redirect:/displayProfil"; // redirection vers
		// le contrôleur
		// FicheMetierController

	}

	@GetMapping("ajouterFormationURL")
	String ajouterFormation(Model model) {

		SaisieFormationForm saisieFormationForm = new SaisieFormationForm();
		saisieFormationForm.setNomFormations(nomFormationService.listeNomFormation());
		saisieFormationForm.setNomSpecialites(specialiteServices.nomSpecialites());
		model.addAttribute("saisieFormationForm", saisieFormationForm);
		return "profil/ajouterFormation";
	};

	@PostMapping("ajouterFormation") // parametre action balise FORM de la page
										// homeNotSignedIn
	String ajouterFormation(@Valid @ModelAttribute SaisieFormationForm saisieFormationForm, Principal principal) { // methode
																													// sInfomer
																													// envoie
																													// homeForm
																													// vers
																													// le
																													// controleur
																													// FicheMetierController
																													// par
																													// l'intermédiare
																													// ra)

		DetailFormation detailFormation = new DetailFormation();
		detailFormation.setAnnee(saisieFormationForm.getAnnee());
		detailFormation.setEcole(saisieFormationForm.getEcole());
		NomFormation nomFormation = new NomFormation();
		nomFormation.setId(saisieFormationForm.getIdNomFormation());
		detailFormation.setNomFormation(nomFormation);
		NomSpecialite nomSpecialite = new NomSpecialite();
		nomSpecialite.setId(saisieFormationForm.getIdNomSpecialite());
		detailFormation.setNomSpecialite(nomSpecialite);

		Account account = accountService.loadUserByEmail(principal.getName()); // principal
																				// contien
																				// l'utilisateur
																				// connecté

		detailFormation.setAccount(account);

		accountService.ajouterFormation(detailFormation); // sauve detail
															// formation tout
															// seul et affecte
															// et écrase
															// detailFormation
															// avec l'objet
															// detail formation
															// sauvé contenant
															// l'account

		return "redirect:/displayProfil"; // redirection vers le controleur
	}

	@GetMapping("confirmerSuppressionURL")
	String confirmerSuppression(Model model, @RequestParam(value = "idFormation") String idFormation) {

		DetailFormation detailFormation = detailFormationServices.detailFormation(new Long(idFormation));
		model.addAttribute("confirmerSuppression", detailFormation);
		return "profil/confirmerSuppression";
	};

	@PostMapping("confirmerSuppression")
	String suppressionValide(@Valid @ModelAttribute DetailFormation detailFormation, Principal principal) {
		detailFormationServices.deleteDetailFormation(detailFormation.getId());
		return "redirect:/displayProfil";
	};

	@GetMapping("editFormationURL")
	String editFormation(Model model, @RequestParam(value = "idFormation") String idFormation) {

		DetailFormation detailFormation = detailFormationServices.detailFormation(new Long(idFormation));
		SaisieFormationForm saisieFormationForm = new SaisieFormationForm();
		saisieFormationForm.setIdDetailFormation(detailFormation.getId());
		saisieFormationForm.setNomFormations(nomFormationService.listeNomFormation());
		saisieFormationForm.setNomSpecialites(specialiteServices.nomSpecialites());
		saisieFormationForm.setEcole(detailFormation.getEcole());
		saisieFormationForm.setAnnee(detailFormation.getAnnee());
		saisieFormationForm.setIdNomFormation(detailFormation.getNomFormation().getId());
		saisieFormationForm.setIdNomSpecialite(detailFormation.getNomSpecialite().getId());
		model.addAttribute("saisieFormationForm", saisieFormationForm);
		return "profil/modifierFormation";
	};

	@PostMapping("modifierFormation") // parametre action balise FORM de la page
										// homeNotSignedIn
	String modifierFormation(@Valid @ModelAttribute SaisieFormationForm saisieFormationForm, Principal principal,
			HttpServletRequest request) { // methode sInfomer envoie homeForm
											// vers le controleur
											// FicheMetierController par
											// l'intermédiare ra)
		// la suppression est faite dans la page modifierFormation via le bouton
		// supprimer qui le javascript suppFormation qui se trouve dans fiche
		// formation (même contexte HTML)

		Account account = accountService.loadUserByEmail(principal.getName()); // principal
																				// contien
																				// l'utilisateur
																				// connecté

		DetailFormation detailFormation = new DetailFormation();
		detailFormation.setAccount(account);
		detailFormation.setId(saisieFormationForm.getIdDetailFormation());
		detailFormation.setAnnee(saisieFormationForm.getAnnee());
		detailFormation.setEcole(saisieFormationForm.getEcole());
		NomFormation nomFormation = new NomFormation();
		nomFormation.setId(saisieFormationForm.getIdNomFormation());
		detailFormation.setNomFormation(nomFormation);
		NomSpecialite nomSpecialite = new NomSpecialite();
		nomSpecialite.setId(saisieFormationForm.getIdNomSpecialite());
		detailFormation.setNomSpecialite(nomSpecialite);

		detailFormationServices.updateDetailFormation(detailFormation);
		return "redirect:/displayProfil"; // redirection vers le controleur
	}
}