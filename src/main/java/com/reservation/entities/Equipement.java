package com.reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int quantiteDisponible;
    private String description;
    @ManyToOne
    @JoinColumn(name = "hebergement_id")
    @JsonIgnore
    private Hebergement hebergement;
    public Equipement() {
        // Initialisation des champs si nécessaire
    }
	public Equipement(String nom, int quantiteDisponible, String description, Hebergement hebergement) {
		super();
		this.nom = nom;
		this.quantiteDisponible = quantiteDisponible;
		this.description = description;
		this.hebergement = hebergement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantiteDisponible() {
		return quantiteDisponible;
	}
	public void setQuantiteDisponible(int quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Hebergement getHebergement() {
		return hebergement;
	}
	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
}
