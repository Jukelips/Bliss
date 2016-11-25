package com.bliss.dao;

import java.util.List;

import com.bliss.db.HibernateUtil;
import com.bliss.metier.Machine;
import com.bliss.metier.Salle;


public class MachineDAO extends UtilDAO<Machine> {
    
    
    public MachineDAO() {
        super(Machine.class);
    }
    
    

    @Override
    public Machine getById(long id) {
        return HibernateUtil.getSession().load(Machine.class, id);
    }
    public List<Machine> listAll() {
		return HibernateUtil.getSession().createQuery("from Machine").list();
		/*for (Machine m : listMachine) {
            m.setSalle(getNomById(m.getId()));
        }
        return listMachine;*/
    }
    
	/*public List<Salle> getAllSalle() {
		return HibernateUtil.getSession().createQuery("from Salle").list();
	}*/
	
	public Salle getSalleByName(String nom){
		return HibernateUtil.getSession().load(Salle.class, nom);
	}
   /* @SuppressWarnings({ "deprecation", "rawtypes" })
	public String getNomById(Long id) {

        NativeQuery m = null;
		try {
            m = HibernateUtil.getSession()
            		.createQuery("from Machine where idMachine=? and nomSalle=?")
                    //.createSQLQuery("select nomSalle from Salle, Parc where Salle.idSalle = Parc.idSalle and idMachine = ? orderby nomSalle")
                    .setParameter(0, id);
        } catch (NoResultException nre) {
            nre.getMessage();
        }
        return m.toString();
    }*/
}