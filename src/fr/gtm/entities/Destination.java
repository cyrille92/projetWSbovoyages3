package fr.gtm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "destinations")
@NamedQuery(name = "findAllDestination",
			query = "SELECT d FROM Destination d")
@NamedQuery(name = "findByRegion",
			query = "SELECT d FROM Destination d WHERE d.region LIKE :region")
@NamedQuery(name = "findDestinationById",
			query= "SELECT d FROM Destination d WHERE d.id LIKE : id ORDER BY d.id ")


public class Destination implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_destination")
	private long id ;
	private String region ;
	private String description ;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_destination")
	private List<DatesVoyage> datesVoyages ;
	
	@ElementCollection
	@CollectionTable(name ="images",joinColumns = @JoinColumn(name = "fk_destination") )
	@Column(name = "image")
	private List<String> images = new ArrayList<>();
	
	public Destination() {
		
	}

	public Destination(String region, String description, List<DatesVoyage> datesVoyage, List<String> images) {
		
		this.region = region;
		this.description = description;
		this.datesVoyages = datesVoyage;
	//	this.images = images;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DatesVoyage> getDatesVoyage() {
		return datesVoyages;
	}

	public void setDatesVoyage(List<DatesVoyage> datesVoyage) {
		this.datesVoyages = datesVoyage;
	}

//	public List<String> getImages() {
//		return images;
//	}
//
//	public void setImages(List<String> images) {
//		this.images = images;
//	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", region=" + region + ", description=" + description + ", datesVoyage="
				+ datesVoyages + "]";
	}
	

}
