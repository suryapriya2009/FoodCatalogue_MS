package com.suryams.foodcatalogue.dto;

import java.util.List;

import com.suryams.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogue {
	
	private List<FoodItem> foodItems;
	private Restaurant restaurant;

}
