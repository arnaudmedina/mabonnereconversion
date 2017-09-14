package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.DetailFormation;

	@Repository
	public interface IDetailFormationRepository extends JpaRepository<DetailFormation, Long> {
		
	}

