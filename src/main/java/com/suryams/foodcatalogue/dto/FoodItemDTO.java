package com.suryams.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {

	private int id;
	private String itemName;
	private String itemDesc;
	private Boolean isVeg;
	private Number price;
	private Integer restaurantId;
	private Integer quantity;
	
}
