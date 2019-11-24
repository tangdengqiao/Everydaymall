package com.everydaymall.service;

import com.everydaymall.entity.Users;

public interface IUsesService {
	/**
	 * 注册
	 * 
	 * @param users
	 * @return
	 */
	int saveRegister(Users users);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	Users selectByUsername(String userName);

	/**
	 * 根据用户名,密码查询用户
	 * 
	 * @param users
	 * @return
	 */
	Users selectByUsers(Users users);

}
