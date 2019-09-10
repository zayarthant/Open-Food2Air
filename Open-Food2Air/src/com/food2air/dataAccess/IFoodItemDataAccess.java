package com.food2air.dataAccess;

import com.food2air.entity.FoodItem;

public interface IFoodItemDataAccess extends IDataAccess<FoodItem> {

	public int getAllCount();

}
