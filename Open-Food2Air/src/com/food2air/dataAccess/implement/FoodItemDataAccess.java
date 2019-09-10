package com.food2air.dataAccess.implement;

import org.springframework.stereotype.Repository;

import com.food2air.dataAccess.ADataAccess;
import com.food2air.dataAccess.IFoodItemDataAccess;
import com.food2air.entity.FoodItem;

@Repository
public class FoodItemDataAccess extends ADataAccess<FoodItem> implements IFoodItemDataAccess {

	public FoodItemDataAccess() {
		super(FoodItem.class);
	}

	@Override
	public int getAllCount() {
		return getAll().size();
	}

}
