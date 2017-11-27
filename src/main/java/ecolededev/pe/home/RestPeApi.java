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
public class RestPeApi
{
//        @Value(value = "${pe.store.dev.client.id}")
        @Value("${pe.store.dev.client.id}")
        private String clientId;
       
        @Value(value = "${pe.store.dev.key}")
        private String clientSecretKey;
        
        @Value(value = "${pe.store.dev.accessTokenUri}")
        private String accessTokenUri;
        
        @Value(value = "${pe.store.dev.api.labonneboite.id}")
        private String labonneboiteId;
        
        @Value(value = "${pe.store.dev.api.labonneboite.entryPoint}")
        private String labonneboiteEntryPoint;

        @RequestMapping(method = RequestMethod.GET, path = "/getOffresParRomeCommune/{codeMetierRome}/{codeInseeCommune}")
        public String getOffresByRome (@PathVariable (name = "codeMetierRome") String codeMetierRome, @PathVariable (name = "codeInseeCommune") String codeInseeCommune) throws Exception {
                EmploiStoreTokenResponse emploiStoreResponse = OAuthController.getToken(accessTokenUri, clientId, clientSecretKey, labonneboiteId);
                ObjectMapper objectMapper = new ObjectMapper();
                String reponse;
                reponse = OAuthController.callApi(labonneboiteEntryPoint + "?commune_id=" + codeInseeCommune + "&rome_codes=" + codeMetierRome, emploiStoreResponse);
    			Companies companies =  objectMapper.readValue(reponse, Companies.class);
    			for (Company company : companies.getCompanies())
    			{
    				System.out.println(company);
    			}
                return reponse;
        }
        @RequestMapping(method = RequestMethod.GET, path = "/getOffresParCommuneRome/{codeInseeCommune}/{codeMetierRome}")
        public String getOffresByCommune (@PathVariable (name = "codeMetierRome") String codeMetierRome, @PathVariable (name = "codeInseeCommune") String codeInseeCommune) throws Exception {
                
        	return getOffresByRome(codeMetierRome, codeInseeCommune);
        }
}
