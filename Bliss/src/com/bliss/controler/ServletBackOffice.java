package com.bliss.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bliss.dao.MachineDAO;
import com.bliss.dao.SalleDAO;
import com.bliss.dao.UtilisateurDAO;
import com.bliss.metier.Machine;
import com.bliss.metier.Salle;
import com.bliss.metier.Utilisateur;

public class ServletBackOffice extends UtilHttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getPathInfo() == null ? "/" : req.getPathInfo();
		SalleDAO sd = new SalleDAO();
		MachineDAO md = new MachineDAO();
		switch (action) {
		case "/":
			afficherVue("dashboard", req, resp);
			break;
		case "/liste_machine":
			req.setAttribute("machines", md.listAll());
			afficherVue("liste_machine", req, resp);
			break;
		case "/liste_salle":
			req.setAttribute("salles", sd.listAll());
			afficherVue("liste_salle", req, resp);
			break;
		case "/add_Salle":
			req.setAttribute("salles", sd.listAll());
			afficherVue("add_Salle", req, resp);
			break;
		case "/add_Machine":
			req.setAttribute("salles", sd.listAll());
			afficherVue("add_Machine", req, resp);
			break;
		default:
			resp.sendError(404);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String action = req.getPathInfo() == null ? "/" : req.getPathInfo();
		Machine m = new Machine();
		SalleDAO sd = new SalleDAO();
		MachineDAO md = new MachineDAO();
		Salle s = new Salle();
		long id;
		switch (action) {
		case "/delete_machine":
			id = getParamAsInt("id", req);
			m = md.getById(id);
			md.delete(m);
			String jsonMachine = "{ nom:" + m.getNom() + "}";
			resp.setContentType("application/json");
			resp.getWriter().write(jsonMachine);
			break;
		case "/delete_salle":
			id = getParamAsInt("id", req);
			s = sd.getById(id);
			String jsonSalle = "{ nom:" + s.getNom() + "}";
			resp.setContentType("application/json");
			resp.getWriter().write(jsonSalle);
			break;
		case "/add_Machine":
			m = new Machine();
			m.setIp(getParam("ip", req));
			m.setNom(getParam("nom", req));
			s = sd.getById(getParamAsInt("salle", req));
			m.setNomSalle(s.getNom());
			m.setSalle(s);
			md.save(m);
			break;
		case "/add_Salle":
			s = new Salle();
			s.setNom(getParam("nom", req));
			sd.save(s);
			break;
		default:
			resp.sendError(404);
			break;
		}
	}
}