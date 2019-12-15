package com.everydaymall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.entity.Comment;
import com.everydaymall.entity.Commodity;
import com.everydaymall.service.ICommentService;
import com.everydaymall.service.ICommodityService;
import com.everydaymall.service.ICommodityTypeService;

@Controller
@RequestMapping("/commoditydetails")
public class CommodityDetails {
	
	@Autowired
	private ICommodityService commodityService;

	@Autowired
	private ICommodityTypeService commodityTypeService;
	
	@Autowired
	private ICommentService commentService;
	
	/**
	 * 跳转商品详情
	 * @param idCommodity
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/doFrontendShopDetail")
	@ResponseBody
	public ModelAndView doFrontendShopCart(String idCommodity,ModelAndView modelAndView) {
		if(idCommodity!=null) {
			Commodity commodity = commodityService.selectCommodityIdCommodity(idCommodity);
			String typeName = commodityTypeService.selectTypeNameIdType(commodity.getCommodityType());
			List<Comment> listComment = commentService.listComment(commodity.getIdCommodity());
			modelAndView.addObject("commodity",commodity);
			modelAndView.addObject("typeName",typeName);
			modelAndView.addObject("listComment",listComment);
			modelAndView.setViewName("frontend/shop-detail");
			return modelAndView;
		}else {
			return null;
		}
	}
}
