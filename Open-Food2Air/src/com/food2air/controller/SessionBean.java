package com.food2air.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.food2air.entity.AdminUser;

@Component("sessionBean")
@Scope("session")
public class SessionBean {

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	private int tableNumber;

	private AdminUser adminUser;

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

}
