package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface ISituationRepository extends JpaRepository<Situation, Long> {

		Situation findOneBycode(String code);

		
	}

