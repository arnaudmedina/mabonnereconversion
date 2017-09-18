package ecolededev.pe.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.CompetenceDetail;
import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.Mobilite;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findOneByEmail(String email);

	@Query("select count(a) > 0 from Account a where a.email = :email")
	boolean exists(@Param("email") String email);
	
	@Query("select detailFormations from Account a where a.id = :userId")
	List<DetailFormation> listeFormation(@Param("userId") Long userId);
	
	@Query("select listeMobilites from Account a where a.id = :userId")
	List <Mobilite> listeMobilites (@Param("userId") Long userId);

	@Query("select detailCompetences from Account a where a.id = :userId")
	List<CompetenceDetail> listeCompetences (@Param("userId") Long userId);
	
}