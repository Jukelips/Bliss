package com.bliss.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bliss.dao.MachineDAO;
import com.bliss.dao.SalleDAO;
import com.bliss.dao.UtilisateurDAO;
import com.bliss.metier.Machine;
import com.bliss.metier.Utilisateur;

public class ServletBackOffice extends UtilHttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getPathInfo() == null ? "/" : req.getPathInfo();
		switch (action) {
		case "/":
			afficherVue("dashboard", req, resp);
			break;
		case "/liste_machine":
			MachineDAO md = new MachineDAO();
			req.setAttribute("machines", md.listAll());
			afficherVue("liste_machine", req, resp);
			break;
		case "/liste_salle":
			SalleDAO sd = new SalleDAO();
			req.setAttribute("salles", sd.listAll());
			afficherVue("liste_salle", req, resp);
			break;
		default:
			resp.sendError(404);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getPathInfo() == null ? "/" : req.getPathInfo();
		switch (action) {
		case "/delete_machine":
			long id = getParamAsInt("id", req);
			MachineDAO md = new MachineDAO();
			Machine m = md.getById(id);
			String json = "{ nom:" + m.getNom() + "}";
			resp.setContentType("application/json");
			resp.getWriter().write(json);
			break;
		default:
			resp.sendError(404);
			break;
		}
	}
}
