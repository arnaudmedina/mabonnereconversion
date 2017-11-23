package ecolededev.pe.controller.profil;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import ecolededev.pe.domaine.Metier;

public class ExperienceSaisieForm {

	@NotBlank(message = "{notBlank.message}")
	private String nom; //nom entreprise
	private String codeOgr;
	@NotBlank(message = "{notBlank.message}")
	private String dateDebut;  // String au lieu de date pour ne pas avoir de plantage au post du formulaire avant même que cela n'arrive au méthode du contrôleur
	@NotBlank(message = "{notBlank.message}")
	private String dateFin; // String au lieu de date pour ne pas avoir de plantage au post du formulaire  avant même que cela n'arrive au méthode du contrôleur
	private String commentaire;
	private Metier metier; //redondant avec idmetier et code OGR
	private List<Metier> metiers;
//	private Account  account; //pk?????
	private Long idMetier; //?? redondant codeOGR
	private Long idDetailExperience;

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getCodeOgr()
	{
		return codeOgr;
	}

	public void setCodeOgr(String codeOgr)
	{
		this.codeOgr = codeOgr;
	}

	public String getDateDebut()
	{
		return dateDebut;
	}

	public void setDateDebut(String dateDebut)
	{
		this.dateDebut = dateDebut;
	}

	public String getDateFin()
	{
		return dateFin;
	}

	public void setDateFin(String dateFin)
	{
		this.dateFin = dateFin;
	}

	public String getCommentaire()
	{
		return commentaire;
	}

	public void setCommentaire(String commentaire)
	{
		this.commentaire = commentaire;
	}

	public Metier getMetier()
	{
		return metier;
	}

	public void setMetier(Metier metier)
	{
		this.metier = metier;
	}

	public List<Metier> getMetiers()
	{
		return metiers;
	}

	public void setMetiers(List<Metier> metiers)
	{
		this.metiers = metiers;
	}

	public Long getIdMetier()
	{
		return idMetier;
	}

	public void setIdMetier(Long idMetier)
	{
		this.idMetier = idMetier;
	}

	public Long getIdDetailExperience()
	{
		return idDetailExperience;
	}

	public void setIdDetailExperience(Long idDetailExperience)
	{
		this.idDetailExperience = idDetailExperience;
	}
}


