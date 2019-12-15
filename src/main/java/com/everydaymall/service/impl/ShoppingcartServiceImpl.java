package com.everydaymall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.entity.Shoppingcart;
import com.everydaymall.mapper.ShoppingcartMapper;
import com.everydaymall.service.IShoppingcartService;
import com.everydaymall.utils.DateUtil;
import com.everydaymall.utils.StringUtils;

@Service
public class ShoppingcartServiceImpl implements IShoppingcartService{
	
	private Logger LOGGER = LoggerFactory.getLogger(ShoppingcartServiceImpl.class);
	
	@Autowired
	private ShoppingcartMapper shoppingcartMapper;
	
	/**
	 * 增加购物车
	 */
	@Override
	public int saveShoppingcart(Shoppingcart shoppingcart) {
		try {
			shoppingcart.setIdShoppingcart(StringUtils.getInstance().randomString(Constants.SUM_20));
			shoppingcart.setShoppingcartCreatetime(DateUtil.getCurrentTime());
			return shoppingcartMapper.insertSelective(shoppingcart);
		} catch (Exception e) {
			LOGGER.info("ShoppingcartServiceImpl    saveShoppingcart  增加异常----" + e.toString());
		}
		return Constants.SAVEREGISTER_SUCESS;
	}

	/**
	 * 根据商品ID和用户ID查询购物车里面的商品
	 */
	@Override
	public Shoppingcart selectShoppingcart(String idCommodity, String shoppingcartCreateby) {
		try {
			Shoppingcart shoppingcart = shoppingcartMapper.selectShoppingcart(idCommodity, shoppingcartCreateby);
			return shoppingcart;
		} catch (Exception e) {
			LOGGER.info("ShoppingcartServiceImpl    selectShoppingcart  查询异常----" + e.toString());
			return null;
		}
	}

	/**
	 * 修改数量
	 */
	@Override
	public int updateShoppingcartNumber(Shoppingcart shoppingcart) {
		try {
			return shoppingcartMapper.updateByPrimaryKeySelective(shoppingcart);
		} catch (Exception e) {
			LOGGER.info("ShoppingcartServiceImpl    updateShoppingcartNumber  修改异常----" + e.toString());
		}
		return Constants.SAVEREGISTER_SUCESS;
	}

}
