package com.food2air.dataAccess;

import java.util.List;

import com.food2air.entity.Bill;
import com.food2air.entity.FoodTable;
import com.food2air.entity.OrderRecord;

public interface IOrderRecordDataAccess extends IDataAccess<OrderRecord> {
	
	public List<OrderRecord> get(FoodTable foodTable, Bill bill);
	
	public List<OrderRecord> getActive();

}
