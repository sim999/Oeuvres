package hibernate.metier;

// Generated 11 mars 2013 01:38:49 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Adherent generated by hbm2java
 */
public class Adherent implements java.io.Serializable
{

    private Integer idAdherent;
    private String nomAdherent;
    private String prenomAdherent;
    private Set reservations = new HashSet(0);

    public Adherent()
    {
    }

    public Adherent(String nomAdherent)
    {
	this.nomAdherent = nomAdherent;
    }

    public Adherent(String nomAdherent, String prenomAdherent, Set reservations)
    {
	this.nomAdherent = nomAdherent;
	this.prenomAdherent = prenomAdherent;
	this.reservations = reservations;
    }

    public Integer getIdAdherent()
    {
	return this.idAdherent;
    }

    public void setIdAdherent(Integer idAdherent)
    {
	this.idAdherent = idAdherent;
    }

    public String getNomAdherent()
    {
	return this.nomAdherent;
    }

    public void setNomAdherent(String nomAdherent)
    {
	this.nomAdherent = nomAdherent;
    }

    public String getPrenomAdherent()
    {
	return this.prenomAdherent;
    }

    public void setPrenomAdherent(String prenomAdherent)
    {
	this.prenomAdherent = prenomAdherent;
    }

    public Set getReservations()
    {
	return this.reservations;
    }

    public void setReservations(Set reservations)
    {
	this.reservations = reservations;
    }

    public boolean equals(Object other)
    {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof Adherent))
	    return false;
	Adherent castOther = (Adherent) other;

	return (this.idAdherent == castOther.getIdAdherent());
    }
}
