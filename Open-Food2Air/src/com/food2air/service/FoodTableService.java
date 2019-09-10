package com.food2air.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food2air.dataAccess.IBillDataAccess;
import com.food2air.dataAccess.IFoodTableDataAccess;
import com.food2air.entity.Bill;
import com.food2air.entity.FoodTable;

@Service
public class FoodTableService {

	@Autowired
	private IFoodTableDataAccess foodTableDataAccess;

	@Autowired
	private IBillDataAccess billDataAccess;

	public FoodTable login(int number) {
		FoodTable foodTable = foodTableDataAccess.findByTableNumber(number);
		if (null != foodTable && null == foodTable.getServing_bill()) {
			Bill bill = new Bill();
			billDataAccess.create(bill);
			foodTable.setServing_bill(bill);
			foodTable = foodTableDataAccess.update(foodTable);
		}
		return foodTable;
	}

	public FoodTable confirmBill(FoodTable foodTable) {
		if (null != foodTable.getServing_bill()) {
			Bill oldBill = foodTable.getServing_bill();
			oldBill.setConfirmed(true);
			billDataAccess.update(oldBill);
		}
		Bill newBill = new Bill();
		newBill.setConfirmed(false);
		billDataAccess.create(newBill);
		foodTable.setServing_bill(newBill);
		foodTableDataAccess.update(foodTable);
		return foodTable;
	}

}
