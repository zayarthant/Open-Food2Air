package com.food2air.dataAccess;

import java.util.List;

import com.food2air.entity.Bill;

public interface IBillDataAccess extends IDataAccess<Bill> {
	
	public List<Bill> getUnConfirmedBills();
	
}