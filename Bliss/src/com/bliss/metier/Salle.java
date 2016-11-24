package com.bliss.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salle")
public class Salle {

	@Column(name = "nom")
	private String nom;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Machine> machines = new ArrayList<Machine>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
