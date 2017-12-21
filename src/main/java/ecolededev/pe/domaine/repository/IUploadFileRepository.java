package ecolededev.pe.domaine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecolededev.pe.domaine.Commune;
import ecolededev.pe.domaine.UploadFile;


	@Repository
	public interface IUploadFileRepository extends JpaRepository<UploadFile, Long> {

		
	}

