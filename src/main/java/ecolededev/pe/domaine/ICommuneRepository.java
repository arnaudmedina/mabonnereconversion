package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface ICommuneRepository extends JpaRepository<Commune, Long> {

		Commune findOneBycodePostal(String codePostal);

		
	}

