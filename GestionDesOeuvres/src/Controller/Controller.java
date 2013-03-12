package Controller;

import hibernate.dao.GenericDao;
import hibernate.dao.ReservationDao;
import hibernate.metier.Adherent;
import hibernate.metier.LoginException;
import hibernate.metier.Oeuvrevente;
import hibernate.metier.Proprietaire;
import hibernate.metier.Reservation;
import hibernate.metier.ReservationId;
import hibernate.util.HibernateUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.metier.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.Tools;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LOGIN = "login";
    private static final String ADDOEUVRE = "addOeuvre";
    private static final String SAVEOEUVRE = "saveOeuvre";
    private static final String UPDATEOEUVRE = "updateOeuvre";
    private static final String MODIFOEUVRE = "modifOeuvre";
    private static final String RESERVEOEUVRE = "reserveOeuvre";
    private static final String CATALOGUE = "listeOeuvres";
    private static final String CATAlOGUERESERVATION = "listeReservations";
    private static final String SAVERESERVATION = "saveReservation";
    private static final String CONFIRMRESERVATION = "confirmReservation";
    private static final String DELETERESERVATION = "deleteReservation";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller()
    {
	super();
	// TODO Auto-generated constructor stub
    }

    public void processRequest(HttpServletRequest request,
	    HttpServletResponse response) throws LoginException, ParseException
    {

	String actionName = request.getParameter(ACTION_TYPE);
	boolean flagSaisieModif;
	String destinationPage = "";

	if (LOGIN.equals(actionName))
	{
	    String userLogin = request.getParameter("user_login");
	    String userPassword = request.getParameter("user_password");
	    try
	    {
		if (userLogin.equals("userepul") && userPassword.equals("epul"))
		{
		    destinationPage = "/accueil.jsp";
		} else
		    throw new LoginException("Utilisateur Inconnu");
	    } 
	    catch (LoginException e)
	    {
		throw e;
	    }
	}
	if (ADDOEUVRE.equals(actionName))
	{
	    flagSaisieModif = true;
	    Proprietaire p = new Proprietaire();
	    GenericDao<Proprietaire> dp = new GenericDao<Proprietaire>(p);

	    ArrayList<Proprietaire> listeProprietaires = (ArrayList<Proprietaire>) dp
		    .findAll(p);
	    request.setAttribute("flagSaisieModif", flagSaisieModif);

	    request.setAttribute("listeProprietaires", listeProprietaires);
	    destinationPage = "/addOeuvre.jsp";

	}

	else if (CATALOGUE.equals(actionName))
	{
	    Oeuvrevente ov = new Oeuvrevente();
	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(ov);

	    ArrayList<Oeuvrevente> liste = (ArrayList<Oeuvrevente>) dov
		    .findAll(ov);

	    request.setAttribute("listeOeuvres", liste);
	    destinationPage = "/catalogue.jsp";

	} else if (MODIFOEUVRE.equals(actionName))
	{
	    int id = Integer.valueOf(request.getParameter("id"));

	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(
		    new Oeuvrevente());

	    Oeuvrevente oeuvreVente = dov.findById(new Oeuvrevente(), id);

	    flagSaisieModif = false;
	    Proprietaire p = new Proprietaire();
	    GenericDao<Proprietaire> dp = new GenericDao<Proprietaire>(p);
	    ArrayList<Proprietaire> listeProprietaires = (ArrayList<Proprietaire>) dp
		    .findAll(p);

	    request.setAttribute("oeuvre", oeuvreVente);
	    request.setAttribute("flagSaisieModif", flagSaisieModif);
	    request.setAttribute("listeProprietaires", listeProprietaires);
	    destinationPage = "/addOeuvre.jsp";

	} else if (UPDATEOEUVRE.equals(actionName))
	{
	    String id = request.getParameter("id"); // cas ou modification il
	    // existe déjà un id...

	    int idOeuvreVente = Integer.valueOf(id);

	    String titreOeuvre = request.getParameter("titre");
	    float prixOeuvre = Float.valueOf(request.getParameter("prix"));
	    int idProprietaire = Integer.valueOf(request
		    .getParameter("lstProprietaires"));

	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(
		    new Oeuvrevente());
	    GenericDao<Proprietaire> dp = new GenericDao<Proprietaire>(
		    new Proprietaire());

	    Proprietaire p = dp.findById(new Proprietaire(), idProprietaire);

	    Oeuvrevente ov = dov.findById(new Oeuvrevente(), idOeuvreVente);
	    ov.setPrixOeuvrevente(prixOeuvre);
	    ov.setTitreOeuvrevente(titreOeuvre);
	    ov.setProprietaire(p);
	    dov.attachDirty(ov);
	    destinationPage = "/accueil.jsp";
	}

	else if (SAVEOEUVRE.equals(actionName))
	{

	    String titreOeuvre = request.getParameter("titre");
	    float prixOeuvre = Float.valueOf(request.getParameter("prix"));
	    int idProprietaire = Integer.valueOf(request
		    .getParameter("lstProprietaires"));

	    Oeuvrevente ov = new Oeuvrevente();

	    ov.setPrixOeuvrevente(prixOeuvre);
	    ov.setTitreOeuvrevente(titreOeuvre);
	    ov.setEtatOeuvrevente("L");

	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(ov);
	    GenericDao<Proprietaire> dp = new GenericDao<Proprietaire>(
		    new Proprietaire());

	    Proprietaire p = dp.findById(new Proprietaire(), idProprietaire);

	    ov.setProprietaire(p);

	    dov.attachDirty(ov);

	    destinationPage = "/accueil.jsp";

	} else if (RESERVEOEUVRE.equals(actionName))
	{
	    String id = request.getParameter("id");
	    int idOeuvre = Integer.valueOf(id);
	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(
		    new Oeuvrevente());

	    Oeuvrevente ov = dov.findById(new Oeuvrevente(), idOeuvre);

	    GenericDao<Adherent> da = new GenericDao<Adherent>(new Adherent());
	    ArrayList<Adherent> listeAdherents = (ArrayList<Adherent>) da
		    .findAll(new Adherent());

	    request.setAttribute("oeuvre", ov);
	    request.setAttribute("listeAdherents", listeAdherents);
	    destinationPage = "/reservation.jsp";

	} else if (DELETERESERVATION.equals(actionName))
	{
	    int idOeuvreVente = Integer.valueOf(request
		    .getParameter("idOeuvreVente"));
	    int idAdherent = Integer
		    .valueOf(request.getParameter("idAdherent"));
	    ReservationId ri = new ReservationId(idOeuvreVente, idAdherent);
	    Reservation r = new Reservation();

	    ReservationDao dr = new ReservationDao(new Reservation());
	    r = dr.findReservationbyId(r, ri);
	    dr.delete(r);
	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(
		    new Oeuvrevente());

	    Oeuvrevente ov = dov.findById(new Oeuvrevente(), idOeuvreVente);
	    if (ov.getReservations().size() == 1
		    && ov.getReservations().contains(r))

	    {
		ov.setEtatOeuvrevente("L");
		dov.attachDirty(ov);
	    }

	    destinationPage = "/accueil.jsp";

	} else if (CONFIRMRESERVATION.equals(actionName))
	{
	    int idOeuvreVente = Integer.valueOf(request
		    .getParameter("idOeuvreVente"));
	    int idAdherent = Integer
		    .valueOf(request.getParameter("idAdherent"));
	    ReservationId ri = new ReservationId(idOeuvreVente, idAdherent);
	    Reservation r = new Reservation();

	    ReservationDao dr = new ReservationDao(new Reservation());
	    r = dr.findReservationbyId(r, ri);
	    r.setStatut("confirmee");
	    dr.attachDirty(r);

	    destinationPage = "/accueil.jsp";

	} else if (SAVERESERVATION.equals(actionName))

	{
	    int idOeuvreVente = Integer.valueOf(request.getParameter("id"));
	    int idAdherent = Integer.valueOf(request
		    .getParameter("lstReservations"));
	    Date dateReservation = Tools.StrToDate(
		    request.getParameter("datedebut"), "yyyy-mm-dd");
	    Reservation r = new Reservation();

	    GenericDao<Oeuvrevente> dov = new GenericDao<Oeuvrevente>(
		    new Oeuvrevente());

	    Oeuvrevente ov = dov.findById(new Oeuvrevente(), idOeuvreVente);

	    ov.setEtatOeuvrevente("R");

	    dov.attachDirty(ov);

	    GenericDao<Adherent> da = new GenericDao<Adherent>(new Adherent());
	    Adherent a = da.findById(new Adherent(), idAdherent);

	    r.setId(new ReservationId(idOeuvreVente, idAdherent));
	    r.setOeuvrevente(ov);
	    r.setAdherent(a);
	    r.setDateReservation(dateReservation);
	    r.setStatut("Attente");

	    GenericDao<Reservation> dr = new GenericDao<Reservation>(
		    new Reservation());

	    dr.attachDirty(r);
	    destinationPage = "/accueil.jsp";

	} else if (CATAlOGUERESERVATION.equals(actionName))
	{

	    Reservation r = new Reservation();
	    GenericDao<Reservation> dr = new GenericDao<Reservation>(r);

	    ArrayList<Reservation> liste = (ArrayList<Reservation>) dr
		    .findAll(r);

	    request.setAttribute("listeReservations", liste);
	    destinationPage = "/listereservations.jsp";
	}
	RequestDispatcher dispatcher = getServletContext()
		.getRequestDispatcher(destinationPage);
	try
	{

	    dispatcher.forward(request, response);

	} catch (ServletException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	}

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException
    {

	Session session = null;
	Transaction tx = null;
	try
	{
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    this.processRequest(request, response);
	    tx.commit();
	}
	
	catch (Exception e)
	{
	    if (tx != null)
		tx.rollback();
	    // Redirection vers la page jsp appropriee
	    request.setAttribute("erreur", e.getMessage());
	    RequestDispatcher dispatcher = getServletContext()
		    .getRequestDispatcher("/erreur.jsp");
	    dispatcher.forward(request, response);
	}

	/*
	 * try {
	 * 
	 * Session session = HibernateUtil.getSessionFactory()
	 * .getCurrentSession();
	 * 
	 * Transaction tx = session.beginTransaction();
	 * 
	 * this.processRequest(request, response, tx, session); if
	 * (tx.isActive()) tx.commit(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 */

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException
    {
	/*
	 * try { Session session = HibernateUtil.getSessionFactory()
	 * .getCurrentSession(); Transaction tx = session.beginTransaction();
	 * 
	 * this.processRequest(request, response, tx, session);
	 * 
	 * if (tx.isActive()) tx.commit();
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */
	Session session = null;
	Transaction tx = null;
	try
	{
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    this.processRequest(request, response);
	    tx.commit();
	} catch (Exception e)
	{
	    if (tx != null)
		tx.rollback();
	    // Redirection vers la page jsp appropriee
	    request.setAttribute("erreur", e.getMessage());
	    RequestDispatcher dispatcher = getServletContext()
		    .getRequestDispatcher("/erreur.jsp");
	    dispatcher.forward(request, response);
	}

    }

}
