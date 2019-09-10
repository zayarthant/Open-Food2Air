package com.food2air.dataAccess;

import com.food2air.entity.FoodTable;

public interface IFoodTableDataAccess extends IDataAccess<FoodTable>{
	public FoodTable findByTableNumber(int number);
}
