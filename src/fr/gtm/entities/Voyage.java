package fr.gtm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voyages")

public class Voyage implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_voyage")
	private long id ;
	
	private String region ;
	private String descriptif ;
//	@Column(name = "fk_client")
//	private Client client ;
//	@Column (name = "fk_dates_voyage")
//	private DatesVoyage ddv ;

	public Voyage() {
		
	}
	
	public Voyage(String region, String descriptif) {

		this.region = region;
		this.descriptif = descriptif;
	//	this.client = client;
		//this.ddv = ddv;
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


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


//	public Client getClient() {
//		return client;
//	}
//
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
//
//
//	public DatesVoyage getDdv() {
//		return ddv;
//	}
//
//
//	public void setDdv(DatesVoyage ddv) {
//		this.ddv = ddv;
//	}
	
	

}
