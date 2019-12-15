package com.everydaymall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.service.ICommodityService;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingcartController {
	
	@Autowired
	private ICommodityService commodityService;
	
	@RequestMapping("/doFrontendShopCart")
	public ModelAndView doFrontendShopCart(ModelAndView modelAndView) throws Exception{
		modelAndView.setViewName("frontend/shop-cart");
		return modelAndView;
	}
}
