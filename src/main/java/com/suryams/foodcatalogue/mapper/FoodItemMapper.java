package com.suryams.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.suryams.foodcatalogue.dto.FoodItemDTO;
import com.suryams.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);
	FoodItem mapFoodItemDtoToFoodItem(FoodItemDTO foodItemDTO);
	FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);
	

}
