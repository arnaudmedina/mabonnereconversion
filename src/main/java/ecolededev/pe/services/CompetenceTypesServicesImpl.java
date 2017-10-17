package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.CompetenceType;
import ecolededev.pe.domaine.repository.ICompetenceTypeRepository;
import ecolededev.pe.services.referentiel.ICompetenceTypeServices;

@Service
public class CompetenceTypesServicesImpl implements ICompetenceTypeServices {
	
		@Autowired
		ICompetenceTypeRepository iCompetenceTypeRepository;

		@Override
		public List<CompetenceType> listeCompetenceType() {
			return  iCompetenceTypeRepository.findAll();
		}
	}
