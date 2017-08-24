package ecolededev.pe.home;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecolededev.pe.account.Account;
import ecolededev.pe.account.AccountService;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.NomFormation;
import ecolededev.pe.domaine.NomSpecialite;
import ecolededev.pe.domaine.Situation;
import ecolededev.pe.services.ICommuneServices;
import ecolededev.pe.services.IMobiliteServices;
import ecolededev.pe.services.INomFormationServices;
import ecolededev.pe.services.INomSpecialiteServices;
import ecolededev.pe.services.ISituationServices;


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
	private INomFormationServices nomFormationService; //mettre le nom de l'interface et pas le nom de l'implémentation
	
	@Autowired
	private INomSpecialiteServices specialiteServices; //mettre le nom de l'interface et pas le nom de l'implémentation
	
	@GetMapping("displayProfil")
	String displayProfil(Principal principal, Model model) {

			
Account account=accountService.loadUserByEmail(principal.getName());
        
		ProfilForm profilForm = (ProfilForm) model.asMap()
				.get("profilForm");
		if (profilForm == null) {
			profilForm = new ProfilForm();
            profilForm.setAccount(account);
            
            List<DetailFormation> formations = accountService.listeFormation(account.getId());
    		
    		model.addAttribute("formations", formations) ;
			
			 model.addAttribute("profilForm", profilForm) ;
			 List<Commune> communeList = communeService.listeCommune();
			 profilForm.setListeCommune(communeList);

			 List<Situation> situationList = situationService.listeSituation();
			 profilForm.setListeSituation(situationList);
			 
			 List<Mobilite> mobiliteList = mobilitesService.listeMobilite();
			 profilForm.setListeMobilite(mobiliteList);
			 
			return "home/profil";
		}
		else
			return "home/profil";
			
	}
	
	@PostMapping("saveEtatCivil") // parametre action balise FORM de la page
	// profil
String saveEtatCivil(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) { // methode saveEtatCivil envoie profilForm vers le
		
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

@PostMapping("defineMobilite") // parametre action balise FORM de la page
// ficheProfilGeographique
String defineMobilite(@Valid @ModelAttribute ProfilForm profilForm, Principal principal) { // methode sInfomer envoie homeForm vers le

Account accountBase = accountService.loadUserByEmail(principal.getName());
Account account = profilForm.getAccount();
accountBase.setMobilite(account.getMobilite());
accountService.save(accountBase); // sauvegarde des informations
  // de accountBase (Mobilité)
return "redirect:/displayProfil"; // redirection vers
// le controleur
// FicheMetierController

}
	

	@GetMapping("ajouterFormationURL")
	String ajouterFormation(Model model){
		
		 SaisieFormationForm saisieFormationForm= new SaisieFormationForm(); 
		 saisieFormationForm.setNomFormations(nomFormationService.listeNomFormation());
		 saisieFormationForm.setNomSpecialites(specialiteServices.nomSpecialites());
		 model.addAttribute("saisieFormationForm", saisieFormationForm) ;
		return "home/ajouterFormation";
	};
	@PostMapping("ajouterFormation") //parametre action balise FORM de la page homeNotSignedIn 
	String ajouterFormation(@Valid @ModelAttribute SaisieFormationForm saisieFormationForm , Principal principal) {   //methode sInfomer envoie homeForm vers le controleur FicheMetierController par l'intermédiare ra)
       
		DetailFormation detailFormation = new DetailFormation();
		detailFormation.setAnnee(saisieFormationForm.getAnnee());
		detailFormation.setEcole(saisieFormationForm.getEcole());
		NomFormation nomFormation = new NomFormation();
		nomFormation.setId(saisieFormationForm.getIdNomFormation());
		detailFormation.setNomFormation(nomFormation);
		NomSpecialite nomSpecialite = new NomSpecialite();
		nomSpecialite.setId(saisieFormationForm.getIdNomSpecialite());
		detailFormation.setNomSpecialite(nomSpecialite);
		
		
		Account account = accountService.loadUserByEmail(principal.getName()); //principal contien l'utilisateur connecté
	
		
		detailFormation.setAccount(account);
		
		accountService.ajouterFormation(detailFormation); //sauve detail formation tout seul et affecte et écrase detailFormation avec l'objet detail formation sauvé contenant l'account
		
		
		return "redirect:/displayProfil"; //redirection vers le controleur FicheMetierController

	}
	
}