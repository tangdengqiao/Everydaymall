package com.everydaymall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.entity.Comment;
import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;
import com.everydaymall.entity.Users;
import com.everydaymall.service.ICommentService;
import com.everydaymall.service.ICommodityService;
import com.everydaymall.service.ICommodityTypeService;
import com.everydaymall.service.IUsesService;

@Controller
@RequestMapping("/commoditydetails")
public class CommodityDetailsController {
	
	@Autowired
	private ICommodityService commodityService;

	@Autowired
	private ICommodityTypeService commodityTypeService;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private IUsesService usesService;
	
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
			CommodityType commodityType = commodityTypeService.selectTypeNameIdType(commodity.getCommodityType());
			List<Comment> listComment = commentService.listComment(commodity.getIdCommodity());
			int commentNumber = commentService.selectCommentNumber(commodity.getIdCommodity());
			List<Commodity> listCommodity = commodityService.listCommodity(null);
			List<Users> listUsers = usesService.listUsers();
			modelAndView.addObject("commodity",commodity);
			modelAndView.addObject("commodityType",commodityType);
			modelAndView.addObject("listComment",listComment);
			modelAndView.addObject("commentNumber",commentNumber);
			modelAndView.addObject("listCommodity",listCommodity);
			modelAndView.addObject("listUsers",listUsers);
			modelAndView.setViewName("frontend/shop-detail");
			return modelAndView;
		}else {
			return null;
		}
	}
	
	
	
}
