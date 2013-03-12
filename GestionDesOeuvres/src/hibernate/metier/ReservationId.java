package hibernate.metier;

// Generated 11 mars 2013 01:38:49 by Hibernate Tools 4.0.0

/**
 * ReservationId generated by hbm2java
 */
public class ReservationId implements java.io.Serializable
{

    private int idOeuvrevente;
    private int idAdherent;

    public ReservationId()
    {
    }

    public ReservationId(int idOeuvrevente, int idAdherent)
    {
	this.idOeuvrevente = idOeuvrevente;
	this.idAdherent = idAdherent;
    }

    public int getIdOeuvrevente()
    {
	return this.idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente)
    {
	this.idOeuvrevente = idOeuvrevente;
    }

    public int getIdAdherent()
    {
	return this.idAdherent;
    }

    public void setIdAdherent(int idAdherent)
    {
	this.idAdherent = idAdherent;
    }

    public boolean equals(Object other)
    {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof ReservationId))
	    return false;
	ReservationId castOther = (ReservationId) other;

	return (this.getIdOeuvrevente() == castOther.getIdOeuvrevente())
		&& (this.getIdAdherent() == castOther.getIdAdherent());
    }

    public int hashCode()
    {
	int result = 17;

	result = 37 * result + this.getIdOeuvrevente();
	result = 37 * result + this.getIdAdherent();
	return result;
    }

}
