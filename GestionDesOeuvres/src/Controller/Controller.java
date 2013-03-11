package Controller;

import hibernate.dao.GenericDao;
import hibernate.metier.Adherent;
import hibernate.metier.Oeuvrevente;
import hibernate.metier.Proprietaire;
import hibernate.util.HibernateUtil;

import java.io.IOException;
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
    private static final String CATAlOGUERESERVATION = "listeReservation";
    private static final String SAVERESERVATION = "saveReservation";
    private static final String CONFIRMRESERVATION = "confirmReservation";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller()
    {
	super();
	// TODO Auto-generated constructor stub
    }

    public void processRequest(HttpServletRequest request,
	    HttpServletResponse response) throws Exception
    {

	String actionName = request.getParameter(ACTION_TYPE);
	boolean flagSaisieModif;
	String destinationPage = "";

	if (LOGIN.equals(actionName))
	{
	    String userLogin = request.getParameter("user_login");
	    String userPassword = request.getParameter("user_password");
	    if (userLogin.equals("userepul") && userPassword.equals("epul"))
	    {
		destinationPage = "/accueil.jsp";
	    } else
		throw new Exception("utilisateur Inconnu");

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

	    // R�cup�re le bon objet
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
	    System.out.println("SAVE");

	    String id = request.getParameter("id"); // cas ou modification il
	    // existe d�j� un id...

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
	    System.out.println(p.getIdProprietaire());

	    Oeuvrevente ov = dov.findById(new Oeuvrevente(), idOeuvreVente);
	    ov.setPrixOeuvrevente(prixOeuvre);
	    ov.setTitreOeuvrevente(titreOeuvre);
	    System.out.println(ov.getIdOeuvrevente());
	    ov.setProprietaire(p);
	    dov.attachDirty(ov);
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
	} else if (RESERVEOEUVRE.equals(actionName))
	{
	    GenericDao<Adherent> da = new GenericDao<Adherent>(new Adherent());
	    ArrayList<Adherent> listeAdherents = (ArrayList<Adherent>) da
		    .findAll(new Adherent());

	    request.setAttribute("listeAdherents", listeAdherents);
	    destinationPage = "/reservation.jsp";

	} else if (SAVERESERVATION.equals(actionName))
	{
	    GenericDao<Adherent> da = new GenericDao<Adherent>(new Adherent());
	    ArrayList<Adherent> listeAdherents = (ArrayList<Adherent>) da
		    .findAll(new Adherent());

	    request.setAttribute("listeAdherents", listeAdherents);
	    destinationPage = "/reservation.jsp";
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
	} catch (Exception e)
	{
	    if (tx != null)
		tx.rollback();
	    tx.rollback();
	    // Redirection vers la page jsp appropriee
	    request.setAttribute("erreur", e.getMessage());
	    RequestDispatcher dispatcher = getServletContext()
		    .getRequestDispatcher("/erreur.jsp");
	    dispatcher.forward(request, response);
	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException
    {
	Session session = null;
	Transaction tx = null;
	// this.processRequest(request, response);

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
	    tx.rollback(); // Redirection vers la page jsp appropriee
	    request.setAttribute("erreur", e.getMessage());
	    RequestDispatcher dispatcher = getServletContext()
		    .getRequestDispatcher("/erreur.jsp");
	    dispatcher.forward(request, response);
	}

    }

}
