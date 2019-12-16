package com.everydaymall.mapper;

import java.util.List;

import com.everydaymall.entity.Users;

public interface UsersMapper {
	int deleteByPrimaryKey(Integer idIndex);

	int insert(Users record);

	int insertSelective(Users record);

	Users selectByPrimaryKey(Integer idIndex);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	// 自定义
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
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<Users> listUsers();
}