package ecolededev.pe.services;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import ecolededev.pe.domaine.Mobilite;


public interface IMobiliteServices {

	public List <Mobilite> listeMobilite();
	public Mobilite infoMobilite(String codeMobilite);
	}
