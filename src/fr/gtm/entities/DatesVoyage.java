package fr.gtm.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "dates_voyages")
//@NamedQuery(name = "DatesVoyageByDestination",
//			query = "SELECT dv FROM DatesVoyage dv WHERE ")

public class DatesVoyage implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_date_voyage")
	private long id ;
	@Column(name = "date_depart")
	private LocalDate dateAller ;
	@Column(name = "date_retour")
	private LocalDate dateRetour ;
	@Column(name = "nb_places")
	private int nbPlaces ;
	private double prixHT ;
	
//	@Column(name = "fk_destination")
//	private long idDestination ;
		
	public DatesVoyage() {
		
	}
	public DatesVoyage(LocalDate dateAller, LocalDate dateRetour, int nbPlaces, double prixHT) {
	
		this.dateAller = dateAller;
		this.dateRetour = dateRetour;
		this.nbPlaces = nbPlaces;
		this.prixHT = prixHT;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateAller() {
		return dateAller;
	}

	public void setDateAller(LocalDate dateAller) {
		this.dateAller = dateAller;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
}