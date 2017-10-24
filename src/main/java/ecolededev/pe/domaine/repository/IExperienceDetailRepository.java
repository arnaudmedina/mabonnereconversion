package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.ExperienceDetail;

	@Repository
	public interface IExperienceDetailRepository extends JpaRepository<ExperienceDetail, Long> {
		
	}

