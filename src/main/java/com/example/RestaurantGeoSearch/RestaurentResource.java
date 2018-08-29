package com.example.RestaurantGeoSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurentResource {
	
	
	@Autowired
	private RestaurantGeoSearchService resSearchService;
	
	@RequestMapping( method= RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody RestaurantRepresentation resturant){
		
		resSearchService.createRestaureant(resturant);
	} 
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Restaurent> findAll(){
		return resSearchService.findAll();
	}
	
	@RequestMapping(value="/findByDistance",method = RequestMethod.GET)
	public List<Restaurent>  findByDistance(@RequestParam(value = "longitute") float longitute,
	@RequestParam(value = "latitute") float latitute , @RequestParam(value = "distance")int distance){
		return resSearchService.findByDistance(longitute, latitute, distance);
		
	}
	
	

}
