package hibernate.metier;

// Generated 22 f�vr. 2013 17:19:52 by Hibernate Tools 4.0.0

/**
 * Oeuvrepret generated by hbm2java
 */
public class Oeuvrepret implements java.io.Serializable
{

    private Integer idOeuvrepret;
    private Proprietaire proprietaire;
    private String titreOeuvrepret;

    public Oeuvrepret()
    {
    }

    public Oeuvrepret(String titreOeuvrepret)
    {
	this.titreOeuvrepret = titreOeuvrepret;
    }

    public Oeuvrepret(Proprietaire proprietaire, String titreOeuvrepret)
    {
	this.proprietaire = proprietaire;
	this.titreOeuvrepret = titreOeuvrepret;
    }

    public Integer getIdOeuvrepret()
    {
	return this.idOeuvrepret;
    }

    public void setIdOeuvrepret(Integer idOeuvrepret)
    {
	this.idOeuvrepret = idOeuvrepret;
    }

    public Proprietaire getProprietaire()
    {
	return this.proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire)
    {
	this.proprietaire = proprietaire;
    }

    public String getTitreOeuvrepret()
    {
	return this.titreOeuvrepret;
    }

    public void setTitreOeuvrepret(String titreOeuvrepret)
    {
	this.titreOeuvrepret = titreOeuvrepret;
    }

}
