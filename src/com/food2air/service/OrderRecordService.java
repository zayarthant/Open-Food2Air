package com.food2air.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food2air.dataAccess.IBillDataAccess;
import com.food2air.dataAccess.IOrderRecordDataAccess;
import com.food2air.dataAccess.exception.StatusOverException;
import com.food2air.entity.Bill;
import com.food2air.entity.FoodItem;
import com.food2air.entity.FoodTable;
import com.food2air.entity.OrderRecord;
import com.food2air.entity.Status;

@Service
public class OrderRecordService {

	@Autowired
	private IOrderRecordDataAccess orderRecordDataAccess;

	@Autowired
	private IBillDataAccess billDataAccess;

	public OrderRecord insertRecord(FoodItem food_item, FoodTable food_table, int quantity) {
		int status = Status.PENDING.getCode();
		Date current = new Date();
		Bill bill = food_table.getServing_bill();
		OrderRecord orderRecord = new OrderRecord(food_item, food_table, bill, quantity, status, current);
		orderRecord = orderRecordDataAccess.create(orderRecord);
		bill.getOrder_record_list().add(orderRecord);
		billDataAccess.update(bill);
		return orderRecord;
	}

	public Bill cancelRecord(OrderRecord orderRecord) throws StatusOverException {
		if (orderRecord.getStatus() != Status.PENDING.getCode())
			throw new StatusOverException("Can't Delete. Record not in PENDING Status!");
		Bill bill = orderRecord.getBill();
		bill.getOrder_record_list().remove(orderRecord);
		billDataAccess.update(bill);
		orderRecordDataAccess.delete(orderRecord);
		return bill;
	}

	public Bill cancelRecord(long id) throws StatusOverException {
		OrderRecord orderRecord = orderRecordDataAccess.findById(id);
		Bill bill = cancelRecord(orderRecord);
		return bill;
	}

	public List<OrderRecord> getOrderRecordList() {
		return orderRecordDataAccess.getActive();
	}

	public OrderRecord acceptRecord(OrderRecord orderRecord) {
		orderRecord.setStatus(Status.ACCEPT.getCode());
		orderRecordDataAccess.update(orderRecord);
		return orderRecord;
	}

	public OrderRecord acceptRecord(long id) {
		OrderRecord orderRecord = orderRecordDataAccess.findById(id);
		if (orderRecord != null)
			orderRecord = acceptRecord(orderRecord);
		return orderRecord;
	}

	public OrderRecord completeRecord(OrderRecord orderRecord) {
		orderRecord.setStatus(Status.COMPLETE.getCode());
		orderRecordDataAccess.update(orderRecord);
		return orderRecord;
	}
	
	public OrderRecord completeRecord(long id) {
		OrderRecord orderRecord = orderRecordDataAccess.findById(id);
		if (orderRecord != null)
			orderRecord = completeRecord(orderRecord);
		return orderRecord;
	}

}
