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
import ecolededev.pe.account.AccountRepository;
import ecolededev.pe.account.AccountService;
import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.domaine.Situation;
import ecolededev.pe.services.ICommuneServices;
import ecolededev.pe.services.IMetiersServices;
import ecolededev.pe.services.IMobiliteServices;
import ecolededev.pe.services.ISituationServices;

@Controller
class ProfilController {

	@Autowired
	private ICommuneServices communeService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ISituationServices situationService;
	
	@ModelAttribute("module")
	String module() {
		return "home";
	}

	@GetMapping("displayProfil")
	String displayProfil(Principal principal, Model model) {
        Account account=accountService.loadUserByEmail(principal.getName());
        
		ProfilForm profilForm = (ProfilForm) model.asMap()
				.get("profilForm");
		if (profilForm == null) {
			profilForm = new ProfilForm();
            profilForm.setAccount(account);
			
			 model.addAttribute("profilForm", profilForm) ;
			 List<Commune> communeList = communeService.listeCommune();
			 profilForm.setListeCommune(communeList);

			 List<Situation> situationList = situationService.listeSituation();
			 profilForm.setListeSituation(situationList);
			return "home/profil";
		}
		else
			return "home/profil";
			
	}

	@PostMapping("saveEtatCivil") // parametre action balise FORM de la page
									// ficheProfilGeographique
	String saveEtatCivil(@Valid @ModelAttribute ProfilForm profilForm, Principal principal,
			RedirectAttributes ra) { // methode sInfomer envoie homeForm vers le
										// controleur FicheMetierController par
										// l'intermédiare ra)
		Account accountBase = accountService.loadUserByEmail(principal.getName());
		Account account = profilForm.getAccount();
		accountBase.setNom(account.getNom());
		accountBase.setPrenom(account.getPrenom());
		
		accountBase.setCommune(account.getCommune());
		accountBase.setSituation(account.getSituation());
		accountService.save(accountBase);
		
		return "redirect:/displayProfil"; // redirection vers
															// le controleur
															// FicheMetierController

	}

}