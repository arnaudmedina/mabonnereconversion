package emploiStoreDeveloppeur;
import java.util.ArrayList;
import java.util.List;

public class EmploiStoreToken {
	// "scope":"api_labonneboitev1 application_PAR_mabonnereconversion_a7e2438b8bac7fbb3a5dd08962b7c43eb6b17ceaef87aa07209213a9488dadea",
	private String scope;	

	//"expires_in":1500,
	private Integer expires_in;
	
	// "token_type":"Bearer",
	private String token_type;
	
	// "access_token":"ab9ae71b-0f06-4ca7-a000-fac0ee03a4f5"
	private String access_token;
	
	public EmploiStoreToken() {
		
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
}