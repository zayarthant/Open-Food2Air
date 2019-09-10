package com.food2air.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: OrderRecord
 *
 */
@Entity

public class OrderRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private FoodItem food_item;
	private FoodTable food_table;
	private Bill bill;
	private int quantity;
	private int status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date order_date;

	public OrderRecord() {
		// TODO Auto-generated constructor stub
	}

	public OrderRecord(FoodItem food_item, FoodTable food_table, Bill bill, int quantity, int status, Date order_date) {
		super();
		this.food_item = food_item;
		this.food_table = food_table;
		this.bill = bill;
		this.quantity = quantity;
		this.status = status;
		this.order_date = order_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FoodItem getFood_item() {
		return food_item;
	}

	public void setFood_item(FoodItem food_item) {
		this.food_item = food_item;
	}

	public FoodTable getFood_table() {
		return food_table;
	}

	public void setFood_table(FoodTable food_table) {
		this.food_table = food_table;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStringStatus() {
		if (this.status == Status.ACCEPT.getCode())
			return Status.ACCEPT.getValue();
		if (this.status == Status.PENDING.getCode())
			return Status.PENDING.getValue();
		if (this.status == Status.COMPLETE.getCode())
			return Status.COMPLETE.getValue();
		return null;
	}

}
