package com.everydaymall.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.common.result.ResponseResult;
import com.everydaymall.entity.Shoppingcart;
import com.everydaymall.entity.Users;
import com.everydaymall.service.IShoppingcartService;
import com.everydaymall.vo.ShoppingcartVo;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingcartController {

	@Autowired
	private IShoppingcartService shoppingcartService;

	/**
	 * 跳转购物车页面
	 */
	@RequestMapping("/doFrontendShopCart")
	public ModelAndView doFrontendShopCart(ModelAndView modelAndView, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		if (users == null) {
			modelAndView.setViewName("redirect:/user/doLogin");
		} else {
			modelAndView.setViewName("frontend/shop-cart");
		}
		return modelAndView;
	}

	/**
	 * 根据shoppingcartCreateby查询购物车里面的所有商品
	 * 
	 * @param request
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listShoppingcart")
	@ResponseBody
	public List<ShoppingcartVo> listShoppingcart(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		List<ShoppingcartVo> listShoppingcart = shoppingcartService.listShoppingcart(users.getIdUser());
		return listShoppingcart;
	}

	/**
	 * 删除购物车里面的商品
	 * 
	 * @param idIndex
	 * @return
	 */
	@RequestMapping(value = "/delShoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> delshoppingcart(Integer idIndex) throws Exception {
		if (idIndex != null) {
			if (shoppingcartService.delShoppingcart(idIndex) > Constants.SAVEREGISTER_SUCESS) {
				return new ResponseResult<Object>(200, "已删除");
			} else {
				return new ResponseResult<Object>(500, "删除失败");
			}
		} else {
			return new ResponseResult<Object>(500, "购物车里面没有该商品");
		}
	}

	/**
	 * 购物车商品数量增加
	 * 
	 * @param idIndex
	 * @param number
	 * @throws Exception
	 */
	@RequestMapping(value = "/plusNumber", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> plusNumber(Integer idIndex, Integer number) throws Exception {
		Shoppingcart shoppingcart = new Shoppingcart();
		shoppingcart.setIdIndex(idIndex);
		shoppingcart.setShoppingcartNumber(number + 1);
		if (shoppingcartService.updateShoppingcartNumber(shoppingcart) > Constants.SAVEREGISTER_SUCESS) {
			return new ResponseResult<Object>(200, "成功");
		} else {
			return new ResponseResult<Object>(500, "失败");
		}
	}

	/**
	 * 购物车商品数量减少
	 * 
	 * @param idIndex
	 * @param number
	 * @throws Exception
	 */
	@RequestMapping(value = "/reduceNumber", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> reduceNumber(Integer idIndex, Integer number) throws Exception {
		Shoppingcart shoppingcart = new Shoppingcart();
		shoppingcart.setIdIndex(idIndex);
		shoppingcart.setShoppingcartNumber(number - 1);
		if (shoppingcartService.updateShoppingcartNumber(shoppingcart) > Constants.SAVEREGISTER_SUCESS) {
			return new ResponseResult<Object>(200, "成功");
		} else {
			return new ResponseResult<Object>(500, "失败");
		}
	}

	/**
	 * 批量删除购物车里面的商品
	 * 
	 * @param idIndex
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/batchdel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> batchdel(String idIndex) throws Exception {
		String[] strs = idIndex.split(",");
		List<Integer> ids = new ArrayList<>();
		for (String str : strs) {
			ids.add(Integer.parseInt(str));
		}
		if (ids.size() != 0) {
			if (shoppingcartService.deleteShoppingcart(ids) == ids.size()) {
				return new ResponseResult<Object>(200, "已经清除你勾选的商品");
			} else {
				return new ResponseResult<Object>(500, "清除失败");
			}
		} else {
			return new ResponseResult<Object>(300, "你可能未勾选需要清除的商品，请先勾选");
		}
	}

}
