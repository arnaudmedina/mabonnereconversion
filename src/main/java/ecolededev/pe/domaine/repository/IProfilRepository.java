package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecolededev.pe.account.Account;


	@Repository
	public interface IProfilRepository extends JpaRepository<Account, Long> {

		Account findOneByemail(String email);
		
		@Query("select count(a) > 0 from Account a where a.email = :email")
		boolean exists(@Param("email") String email);
		
	}

