package com.food2air.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food2air.dataAccess.IFoodItemDataAccess;
import com.food2air.entity.FoodItem;

@Service
public class FoodItemService {

	@Autowired
	IFoodItemDataAccess foodItemDataAccess;

	public List<FoodItem> getAll() {
		return foodItemDataAccess.getAll();
	}

	public FoodItem get(long id) {
		return foodItemDataAccess.findById(id);
	}

}
