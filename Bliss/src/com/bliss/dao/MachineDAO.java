package com.bliss.dao;

import java.util.List;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Machine;
import com.bliss.metier.Utilisateur;


public class MachineDAO extends UtilDAO<Machine> {
	
	
	public MachineDAO() {
		super(Machine.class);
	}

	@Override
	public Machine getById(long id) {
		return HibernateUtil.getSession().load(Machine.class, id);
	}
	public List<Utilisateur> listAll() {
		return HibernateUtil.getSession().createQuery("from machine").list();
	}

}
