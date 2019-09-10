package com.food2air.dataAccess;

import com.food2air.entity.AdminUser;

public interface IAdminUserDataAccess extends IDataAccess<AdminUser> {

	public AdminUser searchAdminUser(String username, String password);
	
}
