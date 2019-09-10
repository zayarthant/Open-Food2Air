package com.food2air.dataAccess.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.food2air.dataAccess.ADataAccess;
import com.food2air.dataAccess.IAdminUserDataAccess;
import com.food2air.dataAccess.utility.DataAccessUtility;
import com.food2air.entity.AdminUser;

@Repository
public class AdminUserDataAccess extends ADataAccess<AdminUser> implements IAdminUserDataAccess {

	public AdminUserDataAccess() {
		super(AdminUser.class);
	}

	@Override
	public AdminUser searchAdminUser(String username, String password) {
		List<AdminUser> AdminUserList = em
				.createQuery("SELECT user FROM AdminUser user WHERE user.username = ?1 AND user.password = ?2",
						AdminUser.class)
				.setParameter(1, username).setParameter(2, password).getResultList();
		return (AdminUser) DataAccessUtility.getSingleResult(AdminUserList);
	}

}
