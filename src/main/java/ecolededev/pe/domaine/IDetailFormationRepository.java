package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Metier;


	@Repository
	public interface IDetailFormationRepository extends JpaRepository<DetailFormation, Long> {
		
	}

