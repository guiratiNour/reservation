package com.reservation.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Hebergement> hebergements;

    // Constructeur par défaut
    public Categorie() {
    }

    public Categorie(String type, List<Hebergement> hebergements) {
        this.type = type;
        this.hebergements = hebergements;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Hebergement> getHebergements() {
		return hebergements;
	}

	public void setHebergements(List<Hebergement> hebergements) {
		this.hebergements = hebergements;
	}


}
