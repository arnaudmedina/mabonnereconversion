package ecolededev.pe.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ecolededev.pe.domaine.Metier;
import ecolededev.pe.services.referentiel.IMetiersServices;


@Controller
class FicheMetierController {

	
	@Autowired
	private IMetiersServices metiersService;

	
	@GetMapping("displayFicheMetier") 
	
	String displayFicheMetier(@ModelAttribute("codeMetier") String codeMetier, Model model)
	{   
		Metier ficheMetier = metiersService.infoMetier(codeMetier);
		
		model.addAttribute("metier", ficheMetier) ;
		return "home/ficheMetier";

	}
	
}