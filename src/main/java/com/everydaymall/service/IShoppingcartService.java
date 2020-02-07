package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.Shoppingcart;
import com.everydaymall.vo.ShoppingcartVo;

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
    
    /**
     * 根据shoppingcartCreateby查询购物车里面的所有商品
     * @param shoppingcartCreateby
     * @return
     */
    List<ShoppingcartVo> listShoppingcart(String shoppingcartCreateby);
    
    /**
     * 删除购物车里面的商品
     * @param idIndex
     * @return
     */
    int delShoppingcart(Integer idIndex);
    
    /**
     * 根据idIndex查询购物车里面的商品
     * @param idIndex
     * @return
     */
    Shoppingcart selectShoppingcartIdIndex(Integer idIndex);
    
    
    
    /**
     * 根据idIndex删除购物车里面的商品
     * @param idIndex
     * @return
     */
    int deleteShoppingcart(List<Integer> idIndex);

}
