package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Experience;

	@Repository
	public interface IExperienceRepository extends JpaRepository<Experience, Long> {
		
	}

