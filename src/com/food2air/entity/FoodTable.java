package com.food2air.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FoodTable
 *
 */
@Entity
public class FoodTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int table_number;
	private Bill serving_bill;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTable_number() {
		return table_number;
	}

	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}

	public Bill getServing_bill() {
		return serving_bill;
	}

	public void setServing_bill(Bill serving_bill) {
		this.serving_bill = serving_bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
