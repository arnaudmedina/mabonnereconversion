package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.NomFormation;


	@Repository
	public interface INomFormationRepository extends JpaRepository<NomFormation, Long> {
		
		
	}

