package ecolededev.pe.home;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecolededev.pe.domaine.Metier;
import ecolededev.pe.services.IMetiersServices;


@Controller
class HomeController {

	@Autowired
	private IMetiersServices metiersService;

	@ModelAttribute("module")
	String module() {
		return "home";
	}

	@GetMapping("/")
	String index(Principal principal, Model model) {
		if (principal != null) {
			return "home/homeSignedIn";
		} else {
			HomeForm homeForm = (HomeForm) model.asMap().get("homeForm");
			if (homeForm == null) {
				homeForm = new HomeForm();
				model.addAttribute("homeForm", homeForm) ;
				List<Metier> metiersList = metiersService.listeMetiers();
				homeForm.setListeMetiers(metiersList);
			}
			return "home/homeNotSignedIn";
		}
	}

	@PostMapping("sInformer") //parametre action balise FORM de la page homeNotSignedIn 
	String sInfomer(@Valid @ModelAttribute HomeForm homeForm, RedirectAttributes ra) {   //methode sInfomer envoie homeForm vers le controleur FicheMetierController par l'intermédiare ra)
        ra.addAttribute("codeMetier",homeForm.getCodeMetier() );
		return "redirect:/displayFicheMetier"; //redirection vers le controleur FicheMetierController

	}
}