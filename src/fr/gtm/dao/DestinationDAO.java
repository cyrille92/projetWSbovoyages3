package fr.gtm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.entities.DatesVoyage;
import fr.gtm.entities.Destination;

@Singleton

public class DestinationDAO extends AbstractDAO<Destination, Long>{
	
	@PersistenceContext(name = "bovoyages") private EntityManager em ;
	
	
	public DestinationDAO() {
		super(Destination.class);
	}
public List<Destination> findAll(){
		List<Destination> destinations = em.createNamedQuery("findAllDestination", Destination.class)
					.getResultList(); 
		
		return destinations ;	
	}
	
	public List<Destination> findByRegion(String region){
		List<Destination> destinations = em.createNamedQuery("findByRegion", Destination.class)
										.setParameter("region", region)
										.getResultList();
		return destinations;	
		
	}
	public List<String> findAllRegion(){
		
		List<String> regions = new ArrayList<String>() ;
		List<Destination> destinations = em.createNamedQuery("findAllDestination", Destination.class)
				.getResultList(); 
		for (Destination d : destinations)
		{
				regions.add(d.getRegion()) ;
			
		}
				return regions;
			}

	public List<DatesVoyage> getDatesVoyageByDestination(long idDestination) {
		Destination destDV = em.find(Destination.class, idDestination);
		destDV.getDatesVoyage().size() ;
		return destDV.getDatesVoyage() ;
		
	}
	public DestinationDAO(Class<Destination> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
}