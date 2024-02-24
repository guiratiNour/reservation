package com.reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class ServiceHebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;
    private String description;
    @ManyToOne
    @JoinColumn(name = "hebergement_id")
    @JsonIgnore
    private Hebergement hebergement;
    
	public ServiceHebergement() {
		
	}
	public ServiceHebergement(String nom, double prix, String description, Hebergement hebergement) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.hebergement = hebergement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
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

