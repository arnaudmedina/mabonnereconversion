package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Competence;

	@Repository
	public interface ICompetenceRepository extends JpaRepository<Competence, Long> {
		
	}

