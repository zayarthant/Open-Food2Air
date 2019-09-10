package com.food2air.dataAccess.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.food2air.dataAccess.ADataAccess;
import com.food2air.dataAccess.IOrderRecordDataAccess;
import com.food2air.entity.Bill;
import com.food2air.entity.FoodTable;
import com.food2air.entity.OrderRecord;

@Repository
public class OrderRecordDataAccess extends ADataAccess<OrderRecord> implements IOrderRecordDataAccess {

	public OrderRecordDataAccess() {
		super(OrderRecord.class);
	}

	@Override
	public List<OrderRecord> get(FoodTable foodTable, Bill bill) {
		return em.createQuery("SELECT r FROM OrderRecord r WHERE r.food_item = ?1 AND r.bill = ?2", OrderRecord.class)
				.setParameter(1, foodTable).setParameter(2, bill).getResultList();
	}

	@Override
	public List<OrderRecord> getActive() {
		return em.createQuery("SELECT r FROM OrderRecord r WHERE r.status = 1 OR r.status = 2 ORDER BY r.id DESC",
				OrderRecord.class).getResultList();
	}

}