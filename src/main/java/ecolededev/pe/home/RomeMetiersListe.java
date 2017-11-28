package ecolededev.pe.home;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class RomeMetiersListe {

	// annotation json @ pour récupérer companies_count
		@JsonProperty("metiers")
		private List<RomeMetier>  metiers;
		
		public RomeMetiersListe() {
			metiers = new ArrayList<RomeMetier>();
		}

		public List<RomeMetier> getMetiers() {
			return metiers;
		}

		public void setMetiers(List<RomeMetier> metiers) {
			this.metiers = metiers;
		}

		
	
	}