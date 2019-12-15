package com.everydaymall.mapper;

import org.apache.ibatis.annotations.Param;

import com.everydaymall.entity.Shoppingcart;

public interface ShoppingcartMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Shoppingcart record);

    int insertSelective(Shoppingcart record);

    Shoppingcart selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Shoppingcart record);

    int updateByPrimaryKey(Shoppingcart record);
    
    //自定义
    /**
     * 根据商品ID和用户ID查询购物车里面的商品
     * @param idCommodity
     * @param shoppingcartCreateby
     * @return
     */
    Shoppingcart selectShoppingcart(@Param("idCommodity") String idCommodity,@Param("shoppingcartCreateby") String shoppingcartCreateby);
}