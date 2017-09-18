package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.CompetenceDetail;

	@Repository
	public interface ICompetenceDetailRepository extends JpaRepository<CompetenceDetail, Long> {
		
	}

