package com.bliss.controler;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bliss.dao.UtilDAO;
import com.bliss.dao.UtilisateurDAO;
import com.bliss.metier.Utilisateur;

/**
 * Servlet implementation class ServletUtilisateur
 */
@WebServlet("/utilisateur/*")
public class ServletUtilisateur extends UtilHttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletUtilisateur() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final UtilisateurDAO ud = new UtilisateurDAO();
		final String action = request.getPathInfo();
		switch (action) {
		case "/create":
			afficherVue("create", request, response);
			break;

		default:
			response.sendError(404);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String action = request.getPathInfo();
		final UtilisateurDAO ud = new UtilisateurDAO();
		switch (action) {
		case "/create":
			Utilisateur u = new Utilisateur();
			u.setLogin(getParam("login", request));
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(getParam("password", request).getBytes());
				byte byteData[] = md.digest();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
					u.setPassword(sb.toString());
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			ud.save(u);
			break;

		default:
			response.sendError(404);
			break;
		}
	}
}