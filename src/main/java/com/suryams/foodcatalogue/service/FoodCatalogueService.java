package com.suryams.foodcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.suryams.foodcatalogue.dto.FoodCatalogue;
import com.suryams.foodcatalogue.dto.FoodItemDTO;
import com.suryams.foodcatalogue.dto.Restaurant;
import com.suryams.foodcatalogue.entity.FoodItem;
import com.suryams.foodcatalogue.mapper.FoodItemMapper;
import com.suryams.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		FoodItem foodItem = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDTO));
		System.out.println(foodItem);
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem);
		
	}

	public ResponseEntity<FoodCatalogue> fetchFoodCataloguePageDetls(Integer restaurantId) {
		//fetch foodListItems & Restaurant detail
		List<FoodItem> foodItems = foodItemRepo.findFoodItemByRestaurantId(restaurantId);
		Restaurant restaurant = fetchRestaurantDetailByRestId(restaurantId);
		return new ResponseEntity<>(createFoodCataloguePage(foodItems,restaurant),HttpStatus.OK);
	}

	private FoodCatalogue createFoodCataloguePage(List<FoodItem> foodItems, Restaurant restaurant) {
		FoodCatalogue foodCatalogue= new FoodCatalogue();
		foodCatalogue.setFoodItems(foodItems);
		foodCatalogue.setRestaurant(restaurant);
		return foodCatalogue;
	}

	private Restaurant fetchRestaurantDetailByRestId(Integer restaurantId) {
		Restaurant restaurant = restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchRestaurantById/"+restaurantId,Restaurant.class);
		return restaurant;
	}
	
	

}
