package com.bliss.dao;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Utilisateur;

public class UtilDAO<T> {

	Class<T> type;
	
	public UtilDAO(Class<T> type){
		this.type = type;
	}
	
	public void save(T u) {
		
		HibernateUtil.getSession().saveOrUpdate(u);
	}
	
	public T getById(long id){
		return (T) HibernateUtil.getSession().load(type,id);
	}

	public void delete(T o){
		HibernateUtil.getSession().delete(o);
	}
}