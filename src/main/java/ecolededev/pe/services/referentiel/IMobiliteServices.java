package ecolededev.pe.services.referentiel;

import java.util.List;
import ecolededev.pe.domaine.Mobilite;

public interface IMobiliteServices {

	public List<Mobilite> listeMobilite();
	public Mobilite infoMobilite(String codeMobilite);
	public Mobilite getMobilite(Long idMobilite);
}
