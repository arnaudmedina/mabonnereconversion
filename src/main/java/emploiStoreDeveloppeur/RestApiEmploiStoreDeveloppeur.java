package emploiStoreDeveloppeur;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestApiEmploiStoreDeveloppeur {
	String urlPointAcces = "https://api.emploi-store.fr/partenaire/labonneboite/v1/company/";
	String sParamCodeRomeNom = "rome_codes";
	String sParamCodeRomeValeur = "M1607";
	
	EmploiStoreToken monToken = null;

	public RestApiEmploiStoreDeveloppeur() {

	}

	@RequestMapping(path = "/getOffre")
	public String getOffre() {
		String retour = "";

		return (retour);
	}

	public EmploiStoreToken connexionAccessToken() {

//POST /connexion/oauth2/access_token?realm=%2Fpartenaire
//Content-Type: application/x-www-form-urlencoded
//
		String monUrl = "https://entreprise.pole-emploi.fr/connexion/oauth2/access_token";
		String clientId = "PAR_mabonnereconversion_a7e2438b8bac7fbb3a5dd08962b7c43eb6b17ceaef87aa07209213a9488dadea";
		String clientSecret = "690b506a33d6126735e775af291097e8bbea015e05a2bae7ad13cac6402a7949";
		String parametres = "grant_type=client_credentials&client_id="+clientId+"&client_secret="+clientSecret+"&scope=application_"+clientId+"%20api_labonneboitev1";
		
		String sMethode = "POST";
		try {
			URL url = new URL(monUrl);
			HttpsURLConnection maConnexion;
			maConnexion = (HttpsURLConnection) new URL("https://entreprise.pole-emploi.fr/connexion/oauth2/access_token").openConnection();
			maConnexion.setRequestMethod(sMethode);
			maConnexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			maConnexion.setRequestProperty("Content-Length", Integer.toString(parametres.length()));
			maConnexion.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(maConnexion.getOutputStream());
	        wr.write(parametres.getBytes());
	        wr.flush();
	        wr.close();

	        int responseCode = maConnexion.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + monUrl);
	        System.out.println("Post parameters : " + parametres);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in;
	        if (responseCode >= HttpsURLConnection.HTTP_BAD_REQUEST)
	        {
	                in = new BufferedReader(new InputStreamReader(maConnexion.getErrorStream()));
	        }
	        else
	        {
	                in = new BufferedReader(new InputStreamReader(maConnexion.getInputStream()));
	        }

	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null)
	        {
	                response.append(inputLine);
	        }
	        in.close();
	        System.out.println(response);
	        if (responseCode == HttpsURLConnection.HTTP_OK)
	        {
	                // System.out.println("La bonne boîte");
	                ObjectMapper objectMapper = new ObjectMapper();
	                return objectMapper.readValue(response.toString(), EmploiStoreToken.class);
	        }
	        throw new RuntimeException("Error connection : HTTP " + responseCode + " - " + response);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (null);
	}
	
	public String getEntreprise() throws IOException{
	
	//GET /partenaire/labonneboite/v1/company/?distance=30&latitude=49.119146&longitude=6.17602&rome_codes=M1607
	//
	//Authorization: Bearer [Access token]

		String source = "";
		URL monUrl = new URL(urlPointAcces + "/company/?distance=30&latitude=49.119146&longitude=6.17602&rome_codes=M1607");
		URLConnection maConnection = monUrl.openConnection();
		maConnection.setRequestProperty("Authorization","Bearer "+ this.monToken);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(maConnection.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			source += inputLine;
		in.close();
		// System.out.println("Méthode get renvoie la chaîne : " + source);
		return source;
		
	}
}