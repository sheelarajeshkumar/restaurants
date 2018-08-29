package com.example.RestaurantGeoSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class RestaurantGeoSearchService {
	
	@Autowired
	MongoOperations  mongooperation;
	
	public void createRestaureant(RestaurantRepresentation rrrrestaurant){
		System.out.println("createRestaureant name :: "+rrrrestaurant.getName());
		Restaurent restaurent  =  new Restaurent();
		restaurent.setName(rrrrestaurant.getName());
		
		
		restaurent.setAddress(rrrrestaurant.getAddress());
		System.out.println("RestaurantGeoSearchService :: "+restaurent);
		mongooperation.save(restaurent);
	}
	
	public List<Restaurent> findAll(){
		return mongooperation.findAll(Restaurent.class);
	}
	
	public List<Restaurent> findByDistance(float longitute,float latitute,int distance){
		Point  basePoint =  new Point(longitute,latitute);
		Distance radius = new Distance(distance, Metrics.KILOMETERS);
		Circle circle  =  new Circle(basePoint,radius);
		
		Query query =   new Query();
		query.addCriteria(Criteria.where("address.geoLocation").withinSphere(circle));
		return mongooperation.find(query, Restaurent.class);
	}

}
