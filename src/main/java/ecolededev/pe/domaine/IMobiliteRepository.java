package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Mobilite;


	@Repository
	public interface IMobiliteRepository extends JpaRepository<Mobilite, Long> {

		Mobilite findOneBycode(String code);

		
	}

