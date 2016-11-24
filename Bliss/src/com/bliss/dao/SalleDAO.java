package com.bliss.dao;

import java.util.List;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Salle;

public class SalleDAO extends UtilDAO<Salle> {

	public SalleDAO() {
		super(Salle.class);
	}

	@Override
	public Salle getById(long id) {
		return HibernateUtil.getSession().load(Salle.class, id);
	}

	public List<Salle> listAll() {
		return HibernateUtil.getSession().createQuery("from salle").list();
	}

}
