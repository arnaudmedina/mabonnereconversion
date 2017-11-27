package ecolededev.pe.home;
import org.codehaus.jackson.annotate.JsonProperty;

/* JSon à interpréter
{ 
"address": "Service des ressources humaines, 221B BOULEVARD JEAN JAURES, 92100 BOULOGNE-BILLANCOURT", 
"city": "BOULOGNE-BILLANCOURT", 
"contact_mode": "Envoyer un CV et une lettre de motivation", 
"distance": 8, 
"headcount_text": "2 000 à 4 999 salariés", 
"lat": 48.831446, 
"lon": 2.244855, 
"naf": "6202A", 
"naf_text": "Conseil en systèmes et logiciels informatiques", 
"name": "ALTEN JEAN JAURES", 
"siret": "34860741700048", "stars": 4.5, 
"url": "https://labonneboite.pole-emploi.fr/34860741700048/details?rome_code=M1802&utm_campaign=api__emploi_store_dev__mabonnereconversion&utm_medium=web&utm_source=api__emploi_store_dev"
}
*/

public class Company {

	@JsonProperty("address")
	private String address;
	
	@JsonProperty("city")
	private String city;

	// contact_mode
	@JsonProperty("contact_mode")
	private String contactMode;
	
	@JsonProperty("distance")
	private Long distance;
	
	// headcount_text
	@JsonProperty("headcount_text")
	private String headcountText;
	
	@JsonProperty("lat")
	private Long lat;
	
	@JsonProperty("lon")
	private Long lon;
	
	@JsonProperty("naf")
	private String codeNaf;	
	
	@JsonProperty("naf_text")
	private String libelleNaf;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("siret")
	private String siret;

	@JsonProperty("stars")
	private Integer stars;
	
	
	@JsonProperty("url")
	private String url;

	public Company() {

	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactMode() {
		return contactMode;
	}

	public void setContactMode(String contactMode) {
		this.contactMode = contactMode;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public String getHeadcountText() {
		return headcountText;
	}

	public void setHeadcountText(String headcountText) {
		this.headcountText = headcountText;
	}

	public Long getLat() {
		return lat;
	}

	public void setLat(Long lat) {
		this.lat = lat;
	}

	public Long getLon() {
		return lon;
	}

	public void setLon(Long lon) {
		this.lon = lon;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public String getLibelleNaf() {
		return libelleNaf;
	}

	public void setLibelleNaf(String libelleNaf) {
		this.libelleNaf = libelleNaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Company [address=" + address + ", city=" + city + ", contactMode=" + contactMode + ", distance="
				+ distance + ", headcountText=" + headcountText + ", lat=" + lat + ", lon=" + lon + ", codeNaf="
				+ codeNaf + ", libelleNaf=" + libelleNaf + ", name=" + name + ", siret=" + siret + ", stars=" + stars
				+ ", url=" + url + "]";
	}


	
}
