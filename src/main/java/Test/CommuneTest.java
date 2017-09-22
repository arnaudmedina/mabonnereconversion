package Test;
import static org.junit.Assert.*;
import org.junit.Test;
import ecolededev.pe.domaine.Commune;

public class CommuneTest {
	@Test
	public void test() {
		Commune maCommune = new Commune();
		maCommune.setCodePostal("64100");
		maCommune.setLibelle("Bayonne");
		if (!"64100".equals(maCommune.getCodePostal()))
			fail("Not yet implemented");
	}
}
