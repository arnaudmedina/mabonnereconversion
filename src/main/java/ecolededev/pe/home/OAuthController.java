package ecolededev.pe.home;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

public class OAuthController
{
	public static EmploiStoreTokenResponse getToken(String urlEntryPoint, String clientId, String clientSecretKey, String idApi) throws IOException{
		// On construit la chaine à ajouter à l'url pour passer les paramètres
		String urlParameters = "grant_type=client_credentials&"
				+ "client_id=" + clientId + "&"
				+ "client_secret=" + clientSecretKey + "&"
				+ "scope=application_" + clientId + "%20" + idApi;

		// On ouvre une connexion http avec ses paramètres
		HttpsURLConnection httpURLConnection = (HttpsURLConnection) (new URL(urlEntryPoint))
				.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpURLConnection.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
		httpURLConnection.setDoOutput(true);

		// On crée un flux de sortie de données
		DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
		dataOutputStream.write(urlParameters.getBytes());
		dataOutputStream.flush();
		dataOutputStream.close();

		int responseCode = httpURLConnection.getResponseCode();
		// On affiche un retour dans la console pour infos devéloppement
		System.out.println("\nSending 'POST' request to URL : " + urlEntryPoint);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		// On recupère le code reponse de notre requete
		BufferedReader lecteurDeBuffer;
		if (responseCode >= HttpsURLConnection.HTTP_BAD_REQUEST)
		{
			lecteurDeBuffer = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		else
		{
			lecteurDeBuffer = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		}

		// On va lire la réponse ligne par ligne
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = lecteurDeBuffer.readLine()) != null)
		{
			response.append(inputLine);
		}
		lecteurDeBuffer.close();

		// On affiche la réponse dans la console pour infos devéloppement
		System.out.println(response);
		// Si la réponse est ok, on retourne la réponse dans un objet EmploiStoreTokenResponse
		if (responseCode == HttpsURLConnection.HTTP_OK)
		{
			System.out.println("On a bien reçu le jeton d'accès à " + idApi);
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response.toString(), EmploiStoreTokenResponse.class);
		}
		throw new RuntimeException("Error connection : HTTP " + responseCode + " - " + response);
	}

	public static String callApi (String urlEntryPoint, EmploiStoreTokenResponse emploiStoreResponse) throws IOException
	{	
		// On crée un request recevant les header Authorization & Content-Type
		HttpGet request = new HttpGet(urlEntryPoint);
		request.addHeader("Authorization", emploiStoreResponse.getTokenType() + " " + emploiStoreResponse.getAccessToken());
		request.addHeader("Content-Type", "application/json");
		System.out.println(request.getFirstHeader("Authorization"));
		
		// On crée un objet HttpsClient pour envoyer la requete via http
		HttpClient httpsUrlConnectionToServices = HttpClientBuilder.create().build();

		// On crée un objet httpResponse pour recevoir le résultat
		HttpResponse httpResponse = httpsUrlConnectionToServices.execute(request);
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		
		// Si le résultat de la requête est ok
		if (responseCode == HttpsURLConnection.HTTP_OK)
		{
			// On lit la réponse ligne par ligne et la renvoie
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = bufferedReader.readLine()) != null)
			{
				response.append(inputLine);
			}
			return response.toString();
		}
		else
		{
			return ("");
			// Sinon on renvoie une exception
			// throw new RuntimeException("Error connection "+ responseCode + " - " + httpResponse.getStatusLine().getReasonPhrase());
		}
	}
}
