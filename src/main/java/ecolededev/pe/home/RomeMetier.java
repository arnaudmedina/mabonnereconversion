package ecolededev.pe.home;
import org.codehaus.jackson.annotate.JsonProperty;

public class RomeMetier {

	@JsonProperty("ROME_PROFESSION_CARD_CODE")
	private String codeRome;
	
	
	@JsonProperty("PROFESSION_SHEET_CODE")
	private String codeFicheEmploiMetier;
	
	@JsonProperty("OGR_CODE")
	private String codeOgr;
	
	@JsonProperty("ROME_PROFESSION_CARD_NAME")
	private String libelle;
	
	@JsonProperty("STATUS_CODE")
	private Integer codeStatus;

	public String getCodeRome() {
		return codeRome;
	}

	public void setCodeRome(String codeRome) {
		this.codeRome = codeRome;
	}

	public String getCodeFicheEmploiMetier() {
		return codeFicheEmploiMetier;
	}

	public void setCodeFicheEmploiMetier(String codeFicheEmploiMetier) {
		this.codeFicheEmploiMetier = codeFicheEmploiMetier;
	}

	public String getCodeOgr() {
		return codeOgr;
	}

	public void setCodeOgr(String codeOgr) {
		this.codeOgr = codeOgr;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getCodeStatus() {
		return codeStatus;
	}

	public void setCodeStatus(Integer codeStatus) {
		this.codeStatus = codeStatus;
	}

	public RomeMetier() {
		super();
	}

	public RomeMetier(String codeRome, String codeFicheEmploiMetier, String codeOgr, String libelle,
			Integer codeStatus) {
		super();
		this.codeRome = codeRome;
		this.codeFicheEmploiMetier = codeFicheEmploiMetier;
		this.codeOgr = codeOgr;
		this.libelle = libelle;
		this.codeStatus = codeStatus;
	}

	@Override
	public String toString() {
		return "RomeMetier [codeRome=" + codeRome + ", codeFicheEmploiMetier=" + codeFicheEmploiMetier + ", codeOgr="
				+ codeOgr + ", libelle=" + libelle + ", codeStatus=" + codeStatus + "]";
	}
	
	
	
	}