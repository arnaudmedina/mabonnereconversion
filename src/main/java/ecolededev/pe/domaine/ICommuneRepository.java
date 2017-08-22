package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Mobilite;


	@Repository
	public interface ICommuneRepository extends JpaRepository<Commune, Long> {

		Commune findOneBycodePostal(String codePostal);

		
	}

