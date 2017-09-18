package ecolededev.pe.domaine.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecolededev.pe.domaine.CompetenceType;

	@Repository
	public interface ICompetenceTypeRepository extends JpaRepository<CompetenceType, Long> {
	}
