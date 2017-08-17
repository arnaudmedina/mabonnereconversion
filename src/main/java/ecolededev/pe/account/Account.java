package ecolededev.pe.account;

import javax.persistence.*;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	private Instant created;

	@Column(name="codePostal")
	private String codePostal;
	
	@Column(name="mobilite")
	private String mobilite;
	
	protected Account() {

	}
	
	public Account(String email, String password, String role, String codePostal, String mobilite) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.created = Instant.now();
		this.codePostal = codePostal;
		this.mobilite = mobilite;
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getMobilite() {
		return mobilite;
	}

	public void setMobilite(String mobilite) {
		this.mobilite = mobilite;
	}
	
	
}
