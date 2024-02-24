package com.reservation.entities;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ville;
    private String pays;
    private double prix;
    private double distance;
    private String contact;
    private String adresse;
    private String politiqueAnnulation;
    private String nbEtoile;
    private String espace;
    private double NombreSallesDeBains;
    private boolean jardin;
    private boolean piscine;
    private int nombreChambres;
    private String vue;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    @JsonIgnore
    private Categorie categorie;

    @OneToMany(mappedBy = "hebergement")
    @JsonIgnore
    private List<Image> images;

    @OneToMany(mappedBy = "hebergement")
    @JsonIgnore
    private List<Equipement> equipements;


    @OneToMany(mappedBy = "hebergement")
    @JsonIgnore
    private List<ServiceHebergement> services;
    public Hebergement() {
        
    }

	

	public Hebergement(String nom, String ville, String pays, double prix, double distance, String contact,
			String adresse, String politiqueAnnulation, String nbEtoile, String espace, double nombreSallesDeBains,
			boolean jardin, boolean piscine, int nombreChambres, String vue, Categorie categorie, List<Image> images,
			List<Equipement> equipements, List<ServiceHebergement> services) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
		this.prix = prix;
		this.distance = distance;
		this.contact = contact;
		this.adresse = adresse;
		this.politiqueAnnulation = politiqueAnnulation;
		this.nbEtoile = nbEtoile;
		this.espace = espace;
		NombreSallesDeBains = nombreSallesDeBains;
		this.jardin = jardin;
		this.piscine = piscine;
		this.nombreChambres = nombreChambres;
		this.vue = vue;
		this.categorie = categorie;
		this.images = images;
		this.equipements = equipements;
		this.services = services;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPolitiqueAnnulation() {
		return politiqueAnnulation;
	}

	public void setPolitiqueAnnulation(String politiqueAnnulation) {
		this.politiqueAnnulation = politiqueAnnulation;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public List<ServiceHebergement> getServices() {
		return services;
	}

	public void setServices(List<ServiceHebergement> services) {
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNbEtoile() {
		return nbEtoile;
	}



	public void setNbEtoile(String nbEtoile) {
		this.nbEtoile = nbEtoile;
	}



	public String getEspace() {
		return espace;
	}



	public void setEspace(String espace) {
		this.espace = espace;
	}



	public double getNombreSallesDeBains() {
		return NombreSallesDeBains;
	}



	public void setNombreSallesDeBains(double nombreSallesDeBains) {
		NombreSallesDeBains = nombreSallesDeBains;
	}



	public boolean isJardin() {
		return jardin;
	}



	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}



	public boolean isPiscine() {
		return piscine;
	}



	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}



	public int getNombreChambres() {
		return nombreChambres;
	}



	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}



	public String getVue() {
		return vue;
	}



	public void setVue(String vue) {
		this.vue = vue;
	}
	

}

