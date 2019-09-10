package com.food2air.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food2air.dataAccess.IBillDataAccess;
import com.food2air.entity.Bill;
import com.food2air.entity.OrderRecord;

@Service
public class BillService {

	@Autowired
	private IBillDataAccess billDataAccess;

	public List<Bill> getBills() {
		return billDataAccess.getUnConfirmedBills();
	}

	public Bill getBill(long id) {
		return billDataAccess.findById(id);
	}

	public double totalPrice(Bill bill) {
		double total = 0;
		List<OrderRecord> orderRecords = bill.getOrder_record_list();
		for (OrderRecord orderRecord : orderRecords) {
			double price = orderRecord.getFood_item().getPrice() * orderRecord.getQuantity();
			total = total + price;
		}
		return total;
	}

}
