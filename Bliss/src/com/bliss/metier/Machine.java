package com.bliss.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class Machine {

    @Column(name = "nom")
    private String nom;

    @Column(name = "ip")
    private String ip;
    
    @Column(name = "nomSalle")
    private String nomSalle;

    public String getNomSalle() {
		return nomSalle;
	}
    
    public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
    
	@ManyToOne
	@JoinColumn(name = "idSalle", foreignKey = @ForeignKey(name = "parc_ibfk_1"))
	public Salle salle;
	
	public Salle getSalle() {
		return salle;
	}
	
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}