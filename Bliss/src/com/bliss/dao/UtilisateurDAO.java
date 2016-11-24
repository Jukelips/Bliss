package com.bliss.dao;


import java.util.List;

import javax.persistence.NoResultException;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Utilisateur;

public class UtilisateurDAO extends UtilDAO<Utilisateur> {
	
	public UtilisateurDAO() {
		super(Utilisateur.class);
	}

	public Utilisateur getByLoginPassword(final String login, final String password){
		Utilisateur u = new Utilisateur();
		//try {
			u =  (Utilisateur) HibernateUtil.getSession()
					.createQuery("from Utilisateur where login=? and password=?")
					.setParameter(0, login)
					.setParameter(1, password).getSingleResult();
		//} catch (NoResultException nre) {
			//nre.getMessage();
		//}
		return u;
	}
	
	public List<Utilisateur> listAll() {
		return HibernateUtil.getSession().createQuery("from Utilisateur").list();
	}
}