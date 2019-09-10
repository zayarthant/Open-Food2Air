package com.food2air.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food2air.dataAccess.IAdminUserDataAccess;
import com.food2air.entity.AdminUser;

@Service
public class AdminUserService {

	@Autowired
	IAdminUserDataAccess adminUserDataAccess;

	public AdminUser login(String username, String password) {
		if (null != username && null != password)
			return adminUserDataAccess.searchAdminUser(username, password);
		return null;
	}
}
