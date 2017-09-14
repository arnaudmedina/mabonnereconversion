package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Situation;


	@Repository
	public interface ISituationRepository extends JpaRepository<Situation, Long> {

		Situation findOneBycode(String code);

		
	}

