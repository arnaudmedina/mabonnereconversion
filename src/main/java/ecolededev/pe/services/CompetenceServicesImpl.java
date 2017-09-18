package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.Competence;
import ecolededev.pe.domaine.repository.ICompetenceRepository;
import ecolededev.pe.services.referentiel.ICompetenceServices;



@Service
public class CompetenceServicesImpl implements ICompetenceServices {
	
		@Autowired
		ICompetenceRepository iCompetenceRepository;

		@Override
		public List<Competence> listeCompetence() {

			return iCompetenceRepository.findAll();
		}
	}
