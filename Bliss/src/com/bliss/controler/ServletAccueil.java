package com.bliss.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAccueil extends UtilHttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		final String path = req.getServletPath();
		if(path.equals("/accueil")){
			afficherVue("accueil", req, resp);
			return;
		}
	}
}
