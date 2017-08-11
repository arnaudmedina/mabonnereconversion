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

import ecolededev.pe.account.Account;
import ecolededev.pe.account.AccountService;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.services.IMetiersServices;


@Controller
class FicheProfilGeographiqueController {

	
	@Autowired
	private AccountService accountService;

	
	@GetMapping("displayFicheProfilGeographique") 
	String displayFicheProfilGeographique(@ModelAttribute("email") String email, Model model)
	{   
//		Account ficheAccount = accountService.loadUserByEmail(email);
//		
//		model.addAttribute("account", ficheAccount) ;
//		

		//		email = model.asMap().get("email");
		
		Account profil = accountService.loadUserByEmail("arnaud@medina.net");
		
		model.addAttribute("profil", profil) ;
		return "home/profilGeographique";

	}
	
}