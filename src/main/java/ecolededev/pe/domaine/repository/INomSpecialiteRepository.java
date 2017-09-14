package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.NomSpecialite;


	@Repository
	public interface INomSpecialiteRepository extends JpaRepository<NomSpecialite, Long> {
		
		
	}

