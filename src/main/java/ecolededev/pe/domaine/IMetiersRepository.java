package ecolededev.pe.domaine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Metier;


	@Repository
	public interface IMetiersRepository extends JpaRepository<Metier, Long> {

		Metier findOneBycode(String code);

		
	}

