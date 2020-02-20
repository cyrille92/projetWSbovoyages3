package fr.gtm.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.gtm.dao.DestinationDAO;
import fr.gtm.entities.DatesVoyage;
import fr.gtm.entities.Destination;

@Path("/destinations")

public class DestinationService{
	
	@EJB private DestinationDAO dao ;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Destination> findAll(){
		return dao.findAll();
			}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Allregion")
	
	
	public String[] findAllRegion(){
		
		List<String> regions = dao.findAllRegion() ;
		String [] regionsTab  = new String[regions.size()] ; 
		
		return regions.toArray(regionsTab) ;
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dvbydestination/{id}")
	public List<DatesVoyage> findDatesVoyageByDestination(@PathParam("id") long idDestination) {
		return dao.getDatesVoyageByDestination(idDestination);
		
	}
	
}
