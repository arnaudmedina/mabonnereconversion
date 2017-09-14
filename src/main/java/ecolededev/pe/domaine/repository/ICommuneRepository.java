package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Commune;


	@Repository
	public interface ICommuneRepository extends JpaRepository<Commune, Long> {

		Commune findOneBycodePostal(String codePostal);

		
	}

