package ecolededev.pe.controller.profil;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecolededev.pe.account.Account;
import ecolededev.pe.account.AccountService;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.Competence;
import ecolededev.pe.domaine.CompetenceDetail;
import ecolededev.pe.domaine.CompetenceType;
import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.ExperienceDetail;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.domaine.Situation;
import ecolededev.pe.services.ICompetenceDetailServices;
import ecolededev.pe.services.IDetailFormationServices;
import ecolededev.pe.services.IExperienceDetailServices;
import ecolededev.pe.services.referentiel.ICommuneServices;
import ecolededev.pe.services.referentiel.ICompetenceServices;
import ecolededev.pe.services.referentiel.ICompetenceTypeServices;
import ecolededev.pe.services.referentiel.IMetiersServices;
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
	private INomFormationServices nomFormationService;
	// mettre le nom de l'interface et pas le nom de l'implémentation

	@Autowired
	private INomSpecialiteServices specialiteServices;
	// mettre le nom de l'interface et pas le nom de l'implémentation

	@Autowired
	private ICompetenceServices competence;
	
	@Autowired
	private IMetiersServices metiersServices;

	@Autowired
	private ICompetenceTypeServices competenceTypes;

	@Autowired
	private ICompetenceDetailServices competenceDetailServices;

	@Autowired
	private ICompetenceDetailServices competenceDetailService;
	
	@Autowired
	private IExperienceDetailServices experienceDetailServices;

	@GetMapping("displayProfil")
	String displayProfil(Principal principal, Model model) {
		Account account = accountService.loadUserByEmail(principal.getName());

		ProfilForm profilForm = (ProfilForm) model.asMap().get("profilForm");
		if (profilForm == null) {
			profilForm = new ProfilForm();
			profilForm.setAccount(account);

			List<DetailFormation> formations = accountService.listeFormation(account.getId());
			List<CompetenceDetail> competences = accountService.listeCompetences(account.getId());
			List<ExperienceDetail> experiences = accountService.listeExperiences(account.getId());
			
			model.addAttribute("formations", formations);
			model.addAttribute("competences", competences);
			model.addAttribute("experiences", experiences);

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

	@PostMapping("saveEtatCivil")
	// parametre action balise FORM de la page profil
	// methode saveEtatCivil envoie profilForm vers le

	String saveEtatCivil(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) {
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

		return "redirect:/displayProfil";
		// redirection vers l'écran d'affichage des informations de l'état civil

	}

	@PostMapping("defineMobilite")
	// Paramètre action balise FORM de la page ficheProfilGeographique
	// methode sInfomer envoie homeForm vers le
	String defineMobilite(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) {
		Account accountBase = accountService.loadUserByEmail(principal.getName());
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
		accountService.save(accountBase);
		// sauvegarde des informations de accountBase (Mobilité)
		return "redirect:/displayProfil";
		// redirection vers le contrôleur FicheMetierController
	}

	@GetMapping("formationAjoutURL")
	String ajouterFormation(Model model) {

		SaisieFormationForm saisieFormationForm = new SaisieFormationForm();
		saisieFormationForm.setNomFormations(nomFormationService.listeNomFormation());
		saisieFormationForm.setNomSpecialites(specialiteServices.nomSpecialites());
		model.addAttribute("saisieFormationForm", saisieFormationForm);
		return "profil/formationFormulaire";
	};
/*
	@PostMapping("ajouterFormation")
	// parametre action balise FORM de la page homeNotSignedIn
	// methode sInfomer envoie homeForm vers le controleur FicheMetierController
	// par l'intermédiare ra
	String ajouterFormation(@Valid @ModelAttribute SaisieFormationForm saisieFormationForm, Principal principal) {

		DetailFormation detailFormation = new DetailFormation();
		detailFormation.setAnnee(saisieFormationForm.getAnnee());
		detailFormation.setEcole(saisieFormationForm.getEcole());
		NomFormation nomFormation = new NomFormation();
		nomFormation.setId(saisieFormationForm.getIdNomFormation());
		detailFormation.setNomFormation(nomFormation);
		NomSpecialite nomSpecialite = new NomSpecialite();
		nomSpecialite.setId(saisieFormationForm.getIdNomSpecialite());
		detailFormation.setNomSpecialite(nomSpecialite);

		Account account = accountService.loadUserByEmail(principal.getName());
		// principal contient l'utilisateur connecté

		detailFormation.setAccount(account);

		accountService.ajouterFormation(detailFormation);
		// sauve detail formation tout seul et affecte et écrase detailFormation
		// avec l'objet
		// detail formation sauvé contenant l'account

		return "redirect:/displayProfil";
		// redirection vers le controleur
	}
*/
	@GetMapping("formationConfirmerSuppressionURL")
	String confirmerSuppression(Model model, @RequestParam(value = "idFormation") String idFormation) {

		DetailFormation detailFormation = detailFormationServices.detailFormation(new Long(idFormation));
		model.addAttribute("formationConfirmerSuppression", detailFormation);
		return "profil/formationConfirmerSuppression";
	};

	@PostMapping("formationConfirmerSuppression")
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
		return "profil/formationFormulaire";
	};

	@PostMapping("modifierFormation")
	// parametre action balise FORM de la page homeNotSignedIn
	String modifierFormation(@Valid @ModelAttribute SaisieFormationForm saisieFormationForm, Principal principal,
			HttpServletRequest request) {
		// methode sInfomer envoie homeForm vers le controleur
		// FicheMetierController par l'intermédiare ra)
		// la suppression est faite dans la page modifierFormation via le bouton
		// supprimer qui
		// le javascript suppFormation qui se trouve dans fiche formation (même
		// contexte HTML)

		Account account = accountService.loadUserByEmail(principal.getName());
		// principal contient l'utilisateur connecté

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
	
	@GetMapping("competenceConfirmerSuppressionURL")
	String competenceConfirmerSuppression(Model model, @RequestParam(value = "idCompetence") String idCompetence) {

		CompetenceDetail competenceDetail = competenceDetailService.competenceDetail(new Long(idCompetence));
		model.addAttribute("competenceConfirmerSuppression", competenceDetail);
		return "profil/competenceConfirmerSuppression";
	};

	@PostMapping("competenceConfirmerSuppression")
	String competenceConfirmerSuppressionValide(@Valid @ModelAttribute CompetenceDetail competenceDetail,
			Principal principal) {
		competenceDetailService.competenceDeleteDetail(competenceDetail.getId());
		return "redirect:/displayProfil";
	};

	@GetMapping("competenceAjoutURL")
	String competenceAjout(Model model) {
		CompetenceSaisieForm competenceSaisieForm = new CompetenceSaisieForm();
		competenceSaisieForm.setCompetences(competence.listeCompetence());
		competenceSaisieForm.setCompetenceTypes(competenceTypes.listeCompetenceType());
		model.addAttribute("competenceSaisieForm", competenceSaisieForm);
//		return "profil/competenceAjout";
		return "profil/competenceFormulaire";
	};
/*
	@PostMapping("competenceAjout")
	String competenceAjout(@Valid @ModelAttribute CompetenceSaisieForm competenceSaisieForm, Principal principal) {

		CompetenceDetail competenceDetail = new CompetenceDetail();
		competenceDetail.setNiveau(competenceSaisieForm.getNiveau());
		competenceDetail.setDureeExperience(competenceSaisieForm.getDureeExperience());
		competenceDetail.setAnneeDerniereExperience(competenceSaisieForm.getAnneeDerniereExperience());
		competenceDetail.setCommentaire(competenceSaisieForm.getCommentaire());
		Competence competence = new Competence();
		competence.setId(competenceSaisieForm.getIdCompetence());
		competenceDetail.setCompetence(competence);
		CompetenceType competenceType = new CompetenceType();
		competenceType.setId(competenceSaisieForm.getIdCompetenceType());
		competenceDetail.setCompetenceType(competenceType);

		Account account = accountService.loadUserByEmail(principal.getName()); // principal
		competenceDetail.setAccount(account);
		accountService.ajouterCompetenceDetail(competenceDetail); 
		// sauve detail
		return "redirect:/displayProfil"; // redirection vers le controleur
	};
*/
	@GetMapping("competenceModificationURL")
	String competenceModificationURL(Model model, @RequestParam(value = "idCompetence") String idCompetence) {

		CompetenceDetail competenceDetail = competenceDetailServices.competenceDetail(new Long(idCompetence));
		CompetenceSaisieForm competenceSaisieForm = new CompetenceSaisieForm();
		competenceSaisieForm.setIdDetailCompetence(competenceDetail.getId());
		competenceSaisieForm.setIdCompetence(competenceDetail.getCompetence().getId());
		competenceSaisieForm.setIdCompetenceType(competenceDetail.getCompetenceType().getId());
		competenceSaisieForm.setNiveau(competenceDetail.getNiveau());
		competenceSaisieForm.setDureeExperience(competenceDetail.getDureeExperience());
		competenceSaisieForm.setAnneeDerniereExperience(competenceDetail.getAnneeDerniereExperience());
		competenceSaisieForm.setCommentaire(competenceDetail.getCommentaire());
		competenceSaisieForm.setCompetences(competence.listeCompetence());
		competenceSaisieForm.setCompetenceTypes(competenceTypes.listeCompetenceType());

		model.addAttribute("competenceSaisieForm", competenceSaisieForm);
		return "profil/competenceFormulaire";
	};

	@PostMapping("competenceFormulaire")
	String competenceModification(@Valid @ModelAttribute CompetenceSaisieForm competenceSaisieForm, Principal principal,
			HttpServletRequest request) {

		CompetenceDetail competenceDetail = new CompetenceDetail();
		competenceDetail.setId(competenceSaisieForm.getIdDetailCompetence());
		competenceDetail.setNiveau(competenceSaisieForm.getNiveau());
		competenceDetail.setDureeExperience(competenceSaisieForm.getDureeExperience());
		competenceDetail.setAnneeDerniereExperience(competenceSaisieForm.getAnneeDerniereExperience());
		competenceDetail.setCommentaire(competenceSaisieForm.getCommentaire());
		
		Competence competence = new Competence();
		competence.setId(competenceSaisieForm.getIdCompetence());
		competenceDetail.setCompetence(competence);
		
		CompetenceType competenceTypes = new CompetenceType();
		competenceTypes.setId(competenceSaisieForm.getIdCompetenceType());
		competenceDetail.setCompetenceType(competenceTypes);

		Account account = accountService.loadUserByEmail(principal.getName()); // principal
		competenceDetail.setAccount(account);
		competenceDetailServices.competenceUpdateDetail(competenceDetail);
		return "redirect:/displayProfil"; // redirection vers le controleur
	}
	
	
	@GetMapping("experienceAjoutURL")
	String experienceAjout(Model model) {
		ExperienceSaisieForm experienceSaisieForm = new ExperienceSaisieForm();
		experienceSaisieForm.setMetiers(metiersServices.listeMetiers());
		model.addAttribute("experienceSaisieForm", experienceSaisieForm);
		return "profil/experienceAjout";
	};
	
	@GetMapping("experienceModificationURL")
	String experienceModificationURL(Model model, @RequestParam(value = "idDetailExperience") String idExperience) {

		ExperienceDetail experienceDetail = experienceDetailServices.experienceDetail(new Long(idExperience));
		ExperienceSaisieForm experienceSaisieForm = new ExperienceSaisieForm();
		experienceSaisieForm.setIdDetailExperience(experienceDetail.getId());
		experienceSaisieForm.setNom(experienceDetail.getNom());
		experienceSaisieForm.setDateDebut(new SimpleDateFormat("dd/MM/yyyy").format(experienceDetail.getDateDebut())); //voir format de la date.
		experienceSaisieForm.setDateFin(new SimpleDateFormat("dd/MM/yyyy").format(experienceDetail.getDateFin())); //voir format de la date
		experienceSaisieForm.setCommentaire(experienceDetail.getCommentaire());
		experienceSaisieForm.setMetier(experienceDetail.getMetier());
		experienceSaisieForm.setMetiers(metiersServices.listeMetiers());
		
		model.addAttribute("experienceSaisieForm", experienceSaisieForm);
		return "profil/experienceAjout";
	};
	
	@PostMapping("experienceAjout")
	// parametre action balise FORM de la page homeNotSignedIn
	// methode sInfomer envoie homeForm vers le controleur FicheMetierController
	// par l'intermédiare ra
	String ajouterExperience(@Valid  @ModelAttribute  ExperienceSaisieForm experienceSaisieForm, Errors errors, Principal principal, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {

		//-----------------
		// BKN
		// Ici on test s'il y a eu des erreurs levées par le validateur de Spring (ex. champ vide), par rapport aux annotations posées sur chaquue champs
		if (errors.hasErrors()) {
			// Avant de renvoyer le fragment HTML, on s'assure que la liste déroulante des métiers soit remplie
			experienceSaisieForm.setMetiers(metiersServices.listeMetiers());
			// on position dans le header de la réponse un indicateur d'erreur
			response.addHeader("MBR-header", "error");
			// puis on renvoie le fragment HTML correspondant à la boîte modale.
			// lorsqu'elle arrivera au navigateur, elle sera enrichie des erreurs
			return "profil/experienceAjout";
		}
		ExperienceDetail experienceDetail = new ExperienceDetail();

		// Pour les dates : transformation du String dateDébut et fin en des objets Date
		try
		{
			experienceDetail.setDateDebut(new SimpleDateFormat("dd/MM/yyyy").parse(experienceSaisieForm.getDateDebut()));
		}
		catch (ParseException e)
		{
			// TODO : Mettre ici ce qu'il faut pour signater les erreurs de format de date à la place du printStackTrace
			// exemple si après
			errors.rejectValue("dateDebut","format.date.invalide");
		}
		try
		{
			experienceDetail.setDateFin(new SimpleDateFormat("dd/MM/yyyy").parse(experienceSaisieForm.getDateFin()));
		}
		catch (ParseException e)
		{
			// TODO : Mettre ici ce qu'il faut pour signater les erreurs de format de date à la place du printStackTrace
			// exemple si après
			errors.rejectValue("dateFin","format.date.invalide");
		}

		// On re contrôle s'il y a eu des erreurs (tout ceci pourrai être factorisé pou mutualiser avec le début des contrôles)
		if (errors.hasErrors())
		{
			// Avant de renvoyer le fragment HTML, on s'assure que la liste déroulante des métiers soit remplie
			experienceSaisieForm.setMetiers(metiersServices.listeMetiers());
			// on position dans le header de la réponse un indicateur d'erreur
			response.addHeader("MBR-header", "error");
			// puis on renvoie le fragment HTML correspondant à la boîte modale.
			// lorsqu'elle arrivera au navigateur, elle sera enrichie des erreurs
			return "profil/experienceAjout";
		}

		experienceDetail.setId(experienceSaisieForm.getIdDetailExperience());
		experienceDetail.setNom(experienceSaisieForm.getNom());
		experienceDetail.setCommentaire(experienceSaisieForm.getCommentaire());


		Metier  metier = new Metier();
		metier.setId(experienceSaisieForm.getIdMetier());
		experienceDetail.setMetier(metier);

		Account account = accountService.loadUserByEmail(principal.getName());
		// principal contient l'utilisateur connecté

		experienceDetail.setAccount(account);
		experienceDetailServices.experienceUpdateDetail(experienceDetail);		
		// sauve detail experience tout seul et affecte et écrase detailExperience
		// avec l'objet
		// detail experience sauvé contenant l'account

		//----------------
		// BKN
		// Dans le cas où tout va bien, il faut se rediriger vers la page principale :
		// On positionne le chemin absolu de cette page dans le header de la réponse
		// Attention, le code suivant calcule la base de l'URL puis ajoute le l'URI /displayProfil à la fin.
		response.setHeader("MBR-header", httpServletRequest.getRequestURL().substring(0,httpServletRequest.getRequestURL().indexOf(httpServletRequest.getServletPath()))+"/displayProfil");
		// Pas besoint de renvoyer un résultat. la requête AJAX exploitera le header pour se diriger vers displayProfil
		return null;
		// redirection vers le controleur
	}
	
	@GetMapping("experienceConfirmerSuppressionURL")
	String experienceConfirmerSuppression(Model model, @RequestParam(value = "idDetailExperience") String idExperience) {

		ExperienceDetail experienceDetail = experienceDetailServices.experienceDetail(new Long(idExperience));
		model.addAttribute("experienceConfirmerSuppression", experienceDetail);
		return "profil/experienceConfirmerSuppression";
		
	};
	@PostMapping("experienceConfirmerSuppression")
	String experienceConfirmerSuppressionValide(@Valid @ModelAttribute ExperienceDetail experienceDetail,
			Principal principal) {
		experienceDetailServices.experienceDeleteDetail(experienceDetail.getId());
		return "redirect:/displayProfil";
	};
}