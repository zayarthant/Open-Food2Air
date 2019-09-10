package com.food2air.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Bill
 *
 */
@Entity

public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	private List<OrderRecord> order_record_list;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private boolean confirmed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<OrderRecord> getOrder_record_list() {
		if (null == order_record_list)
			order_record_list = new ArrayList<OrderRecord>();
		return order_record_list;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public FoodTable getFood_table() {
		if (order_record_list != null && order_record_list.size() > 0)
			return order_record_list.get(0).getFood_table();
		return null;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
