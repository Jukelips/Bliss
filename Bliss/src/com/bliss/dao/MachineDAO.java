package com.bliss.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.NativeQuery;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Machine;


public class MachineDAO extends UtilDAO<Machine> {
    
    
    public MachineDAO() {
        super(Machine.class);
    }

    @Override
    public Machine getById(long id) {
        return HibernateUtil.getSession().load(Machine.class, id);
    }
    public List<Machine> listAll() {
        @SuppressWarnings("unchecked")
		List<Machine> listMachine = HibernateUtil.getSession().createQuery("from machine").list();
		for (Machine m : listMachine) {
            m.setSalle(getNomById(m.getId()));
        }
        return listMachine;
    }
    @SuppressWarnings({ "deprecation", "rawtypes" })
	public String getNomById(Long id) {

        NativeQuery m = null;
		try {
            m = HibernateUtil.getSession()
                    .createSQLQuery("select nomSalle from Salle, Parc where Salle.idSalle = Parc.idSalle and idMachine = ? orderby nomSalle")
                    .setParameter(0, id);
        } catch (NoResultException nre) {
            nre.getMessage();
        }
        return m.toString();
    }
}