package com.suryams.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suryams.foodcatalogue.dto.FoodCatalogue;
import com.suryams.foodcatalogue.dto.FoodItemDTO;
import com.suryams.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {
	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		FoodItemDTO foodItemReturn = foodCatalogueService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemReturn,HttpStatus.OK);		
	}
	
	@GetMapping("/fetchRestAndFoodItemsByRestId/{restaurantId}")
	public ResponseEntity<FoodCatalogue> fetchRestDetailsWithFoodItem(@PathVariable Integer restaurantId){
		return foodCatalogueService.fetchFoodCataloguePageDetls(restaurantId);
	}
	
	

}
