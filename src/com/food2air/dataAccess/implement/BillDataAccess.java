package com.food2air.dataAccess.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.food2air.dataAccess.ADataAccess;
import com.food2air.dataAccess.IBillDataAccess;
import com.food2air.entity.Bill;

@Repository
public class BillDataAccess extends ADataAccess<Bill> implements IBillDataAccess {

	public BillDataAccess() {
		super(Bill.class);
	}

	@Override
	public List<Bill> getUnConfirmedBills() {
		return em.createQuery("SELECT b FROM Bill b WHERE b.confirmed = false ORDER BY b.id DESC", Bill.class)
				.getResultList();
	}

}