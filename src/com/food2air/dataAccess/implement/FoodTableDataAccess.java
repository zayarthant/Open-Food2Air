package com.food2air.dataAccess.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.food2air.dataAccess.ADataAccess;
import com.food2air.dataAccess.IFoodTableDataAccess;
import com.food2air.dataAccess.utility.DataAccessUtility;
import com.food2air.entity.FoodTable;

@Repository
public class FoodTableDataAccess extends ADataAccess<FoodTable> implements IFoodTableDataAccess {

	public FoodTableDataAccess() {
		super(FoodTable.class);
	}

	@Override
	public FoodTable findByTableNumber(int number) {
		List<FoodTable> FoodTableList = em
				.createQuery("SELECT t FROM FoodTable t WHERE t.table_number = ?1", FoodTable.class)
				.setParameter(1, number).getResultList();
		return (FoodTable) DataAccessUtility.getSingleResult(FoodTableList);
	}

}