package ecolededev.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecolededev.pe.domaine.CompetenceTypes;
import ecolededev.pe.domaine.repository.ICompetenceTypesRepository;
import ecolededev.pe.services.referentiel.ICompetenceTypesServices;




@Service
public class CompetenceTypesServicesImpl implements ICompetenceTypesServices {
	
		@Autowired
		ICompetenceTypesRepository iCompetenceTypesRepository;

		@Override
		public List<CompetenceTypes> listeCompetenceType() {
			// TODO Auto-generated method stub
			return  iCompetenceTypesRepository.findAll();
		}
	}
