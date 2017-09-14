package ecolededev.pe.domaine.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecolededev.pe.domaine.DetailCompetence;

	@Repository
	public interface ICompetenceTypeRepository extends JpaRepository<DetailCompetence, Long> {
	}
