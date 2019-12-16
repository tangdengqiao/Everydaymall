package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.entity.Users;
import com.everydaymall.mapper.UsersMapper;
import com.everydaymall.service.IUsesService;
import com.everydaymall.shiro.PasswordHelper;
import com.everydaymall.utils.DateUtil;
import com.everydaymall.utils.StringUtils;

@Service
public class UsersServiceImpl implements IUsesService {

	private Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Autowired
	private UsersMapper usersMapper;

	/**
	 * 注册
	 */
	@Override
	public int saveRegister(Users users) {
		try {
			String salt = PasswordHelper.createSalt();
			String credentials = PasswordHelper.createCredentials(users.getUserPwd(), salt);
			users.setSalt(salt);
			users.setIdUser(StringUtils.getInstance().randomString(Constants.SUM_20));
			users.setUserPwd(credentials);
			users.setUserCreatetime(DateUtil.getCurrentTime());
			users.setUserMoney(Constants.USERMONEY);
			users.setIdIdentity(Constants.USERS_IDIDENTITY1);
			users.setUserState(Constants.USERS_STATE);
			int insertSelective = usersMapper.insertSelective(users);
			return insertSelective;
		} catch (Exception e) {
			LOGGER.info("UsersServiceImpl    saveRegister  增加异常----" + e.toString());
			return Constants.SAVEREGISTER_SUCESS;
		}
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public Users selectByUsername(String userName) {
		try {
			return usersMapper.selectByUsername(userName);
		} catch (Exception e) {
			LOGGER.info("UsersServiceImpl    selectByUsername  查询异常----" + e.toString());
			return null;
		}
	}

	/**
	 * 根据用户名,密码查询用户
	 */
	@Override
	public Users selectByUsers(Users users) {
		try {
			return usersMapper.selectByUsers(users);
		} catch (Exception e) {
			LOGGER.info("UsersServiceImpl    selectByUsers  查询异常----" + e.toString());
			return null;
		}
	}

	@Override
	public List<Users> listUsers() {
		try {
			return usersMapper.listUsers();
		} catch (Exception e) {
			LOGGER.info("UsersServiceImpl    listUsers  查询异常----" + e.toString());
			return null;
		}
	}

}
