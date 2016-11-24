package com.bliss.dao;

import java.util.List;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Machine;
import com.bliss.metier.Salle;
import com.bliss.metier.Utilisateur;

public class SalleDAO extends UtilDAO<Salle> {
	
	
	public SalleDAO() {
		super(Salle.class);
	}
	
	
	@Override
	public Salle getById(long id) {
		return HibernateUtil.getSession().load(Salle.class, id);
	}

	public List<Utilisateur> listAll() {
		return HibernateUtil.getSession().createQuery("from salle").list();
	}

}
