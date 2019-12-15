package com.everydaymall.service;

import com.everydaymall.entity.Shoppingcart;

public interface IShoppingcartService {
	
	/**
	 * 增加购物车
	 * @param shoppingcart
	 * @return
	 */
	int saveShoppingcart(Shoppingcart shoppingcart);
	
	/**
     * 根据商品ID和用户ID查询购物车里面的商品
     * @param idCommodity
     * @param shoppingcartCreateby
     * @return
     */
    Shoppingcart selectShoppingcart(String idCommodity,String shoppingcartCreateby);
    
    /**
     * 修改数量
     * @param shoppingcart
     * @return
     */
    int updateShoppingcartNumber(Shoppingcart shoppingcart);

}
