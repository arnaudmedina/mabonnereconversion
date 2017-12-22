package ecolededev.pe.home;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/mbrapi")
public class RestPeApiInfoTravail
{
	//        @Value(value = "${pe.store.dev.client.id}")
	@Value("${pe.store.dev.client.id}")
	private String clientId;

	@Value(value = "${pe.store.dev.key}")
	private String clientSecretKey;

	@Value(value = "${pe.store.dev.accessTokenUri}")
	private String accessTokenUri;

	@Value(value = "${pe.store.dev.api.infotravail.id}")
	private String infotravailId;

	@Value(value = "${pe.store.dev.api.infotravail.entryPoint}")
	private String infotravailEntryPoint;

	@RequestMapping(method = RequestMethod.GET, path = "/getRome")
	public RomeMetiersListe getRome () throws Exception {
		EmploiStoreTokenResponse emploiStoreTokenResponse = OAuthController.getToken(accessTokenUri, clientId, clientSecretKey, infotravailId);
		ObjectMapper objectMapper = new ObjectMapper();
		String reponse;
		// Exemple : GET /partenaire/infotravail/v1/datastore_search?resource_id=[identifiant-ressource]
//		System.out.println("Envoi d'une requête GET à " + infotravailEntryPoint + "datastore_search?resource_id=10");
//		reponse = OAuthController.callApi(infotravailEntryPoint + "datastore_search?resource_id=10", emploiStoreTokenResponse) ;
		System.out.println("Envoi d'une requête GET à " + infotravailEntryPoint + "resource_search?query=pe_type:reference");
		reponse = OAuthController.callApi(infotravailEntryPoint + "resource_search?query=pe_type:reference", emploiStoreTokenResponse) ;
		System.out.println("Réponse : " + reponse);

		RomeMetiersListe romeMetiersListe = null;
		if ("".equals(reponse)){
			// rien
		}
		else{
			romeMetiersListe = objectMapper.readValue(reponse, RomeMetiersListe.class);
		}
		if ((romeMetiersListe != null) && (romeMetiersListe.getMetiers().size()>0)){
			for (RomeMetier romeMetier : romeMetiersListe.getMetiers())
			{
				System.out.println(romeMetier);
			}
			return romeMetiersListe;
		}
		else {
			romeMetiersListe = new RomeMetiersListe();
			RomeMetier romeMetier = new RomeMetier( "A1101", "00011", "11987", "Chauffeur / Chauffeuse de machines agricoles", 1);
			romeMetiersListe.getMetiers().add(romeMetier);
			romeMetier = new RomeMetier( "A1201", "00012", "11105", "Arboriste", 1);
			romeMetiersListe.getMetiers().add(romeMetier);
			romeMetier = new RomeMetier( "A1202", "00012", "10382", "Agent / Agente d'aménagement des circuits pédestres, équestres et Vtt", 1);
			romeMetiersListe.getMetiers().add(romeMetier);
			romeMetier = new RomeMetier( "A12013", "00012", "10675", "Agent / Agente d'entretien des parcs et jardins", 1);
			romeMetiersListe.getMetiers().add(romeMetier);
			return romeMetiersListe;
		}
	}
}
