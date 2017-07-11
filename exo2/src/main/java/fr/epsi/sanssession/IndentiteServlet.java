package fr.epsi.sanssession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.Utilisateur;

@WebServlet("/identiteSansSession")
public class IndentiteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		switch(req.getParameter("etape")) {
			case "saisieIdentite":
				sauvegarderIdentite(req, resp);
				break;
			case "saisieAddresse":
				sauvegarderAdresse(req, resp);
				break;
			default:
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	private void sauvegarderIdentite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(req.getParameter("nom"));
		utilisateur.setPrenom(req.getParameter("prenom"));
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(
			"<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"<meta charset=\"UTF-8\">" +
			"<title>Saisie d'indentité</title>" +
			"</head>" +
			"<body>" +
			"	<section>" +
			"		<form id=\"identiteForm\" method=\"POST\" action=\"identiteSansSession\">" +
			"			<input name=\"etape\" value=\"saisieAddresse\" type=\"hidden\">" +
			"			<input name=\"nom\" value=\"" + utilisateur.getNom() + "\" type=\"hidden\">" +
			"			<input name=\"prenom\" value=\"" + utilisateur.getPrenom() + "\" type=\"hidden\">" +
			"			<p>" +
			"				<label for=\"addressId\">Adresse</label>" +
			"				<input id=\"addressId\" name=\"adresse\" type=\"text\">" +
			"			</p>" +
			"			<p><button type=submit>Valider</button></p>" +
			"		</form>" +
			"	</section>" +
			"</body>" +
			"</html>");
	}

	private void sauvegarderAdresse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(req.getParameter("nom"));
		utilisateur.setPrenom(req.getParameter("prenom"));
		utilisateur.setAdresse(req.getParameter("adresse"));

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(
			"<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"<meta charset=\"UTF-8\">" +
			"<title>Saisie d'indentité</title>" +
			"</head>" +
			"<body>" +
			"	<section>" +
			"   <p>Nom : " + utilisateur.getNom() + "</p>" +
			"   <p>Prénom : " + utilisateur.getPrenom() + "</p>" +
			"   <p>Adresse : " + utilisateur.getAdresse() + "</p>" +
			"	</section>" +
			"</body>" +
			"</html>");
	}

}
