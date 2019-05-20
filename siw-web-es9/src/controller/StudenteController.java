package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studente;
import service.StudenteService;

@WebServlet("/studenteController")
//crea le viste il controller in SIW, diverso da APS 
public class StudenteController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		String nome= request.getParameter("nome").trim();
		String cognome= request.getParameter("cognome").trim ();   //String.trim() rimuove gli spazi
		
		HttpSession session= request.getSession();
		StudenteForm studForm= new StudenteForm();
		
		//puoi fare i controlli sottostanti in una classe helper(session or request) 
		//controllo stringa vuota
		boolean ciSonoErrori= false;
		
		String nextPage;
		
		if(nome.equals("")) {
			String mess= "Nome è campo obbligatorio";
			request.setAttribute("nomeErr", mess);
			ciSonoErrori= true;
		}
		if(cognome.equals("")) {
			String mess= "Cognome è campo obbligatorio";
			request.setAttribute("cognomeErr", mess);
			ciSonoErrori= true; 
		}
		
		if(ciSonoErrori) { //se ci sono errori prossima vista              (helper.IsNotValid(request or session)) 
			nextPage="/newStudente.jsp";
			nome= nome.toUpperCase();
			cognome= cognome.toUpperCase();
			session.setAttribute("nome", nome);
			session.setAttribute("cognome", cognome);
		}
		else { //se non ci sono errori
			
			nextPage="/risposta.jsp";
			nome= nome.toUpperCase();
			cognome= cognome.toUpperCase();
			studForm.setNome(nome);
			studForm.setCognome(cognome);
			session.setAttribute("studenteForm", studForm);

		}
		ServletContext application = getServletContext (); 
		RequestDispatcher rd= application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String nextPage= "/studenti.jsp";
		StudenteService studenteService= new StudenteService();
		
		if(request.getParameter("id")!=null) {
			Long id =Long.parseLong( request.getParameter("id"));
			Studente studente= studenteService.studenteByIdLong(id);
			request.setAttribute("studente", studente);
			nextPage="/studente.jsp";
		}
		else {
		List<Studente> studenti= studenteService.listaStudenti();
		request.setAttribute("studenti", studenti);
		}
		
		ServletContext application = getServletContext (); 
		RequestDispatcher rd= application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}		



}
