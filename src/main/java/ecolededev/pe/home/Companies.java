package ecolededev.pe.home;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Companies {
	// annotation json @ pour récupérer companies_count
	@JsonProperty("companies")
	private List<Company>  companies;
	
	@JsonProperty("companies_count")
	private int companiesCount;
	
	public Companies() {
		companies = new ArrayList<Company>();
		companiesCount = 0;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public int getCompaniesCount() {
		return companiesCount;
	}

	public void setCompaniesCount(int companiesCount) {
		this.companiesCount = companiesCount;
	}
}