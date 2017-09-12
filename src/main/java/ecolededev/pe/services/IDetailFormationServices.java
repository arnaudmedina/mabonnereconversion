package ecolededev.pe.services;



import ecolededev.pe.domaine.DetailFormation;



public interface IDetailFormationServices {
	
	public DetailFormation detailFormation(Long id);
	public void updateDetailFormation(DetailFormation detailFormation);
	public void deleteDetailFormation(Long id);
	}
