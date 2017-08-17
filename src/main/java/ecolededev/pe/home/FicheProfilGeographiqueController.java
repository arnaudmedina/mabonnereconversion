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
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.services.IMetiersServices;
import ecolededev.pe.services.IMobiliteServices;

@Controller
class FicheProfilGeographiqueController {

	@Autowired
	private IMobiliteServices mobilitesService;

	@Autowired
	private AccountService accountService;
	
	
	@ModelAttribute("module")
	String module() {
		return "home";
	}

	@GetMapping("displayFicheProfilGeographique")
	String displayFicheProfilGeographique(@ModelAttribute("email") String email, Model model) {

		FicheProfilGeographiqueForm ficheProfilGeographiqueForm = (FicheProfilGeographiqueForm) model.asMap()
				.get("ficheProfilGeographiqueForm");
		if (ficheProfilGeographiqueForm == null) {
			ficheProfilGeographiqueForm = new FicheProfilGeographiqueForm();

			// Account ficheAccount = accountService.loadUserByEmail(email);
			// model.addAttribute("account", ficheAccount) ;
			// email = model.asMap().get("email");
			Account profil = accountService.loadUserByEmail("arnaud@medina.net");

			model.addAttribute("profil", profil);
			return "home/profilGeographique";
		}
		else
			return "home/profilGeographique";
			
	}

	@PostMapping("definirMobilite") // parametre action balise FORM de la page
									// ficheProfilGeographique
	String definirMobilite(@Valid @ModelAttribute FicheProfilGeographiqueForm ficheProfilGeographiqueForm,
			RedirectAttributes ra) { // methode sInfomer envoie homeForm vers le
										// controleur FicheMetierController par
										// l'intermédiare ra)
		ra.addAttribute("codeMobilite", ficheProfilGeographiqueForm.getCodeMobilite());
		return "redirect:/displayFicheProfilGeographique"; // redirection vers
															// le controleur
															// FicheMetierController

	}

}