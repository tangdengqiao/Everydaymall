package com.everydaymall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.common.result.ResponseResult;
import com.everydaymall.entity.Collection;
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

	@Autowired
	private HomeController homeController;

	/**
	 * 跳转商品详情
	 * 
	 * @param idCommodity
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/doFrontendShopDetail")
	@ResponseBody
	public ModelAndView doFrontendShopCart(String idCommodity, ModelAndView modelAndView) {
		if (idCommodity != null) {
			Commodity commodity = commodityService.selectCommodityIdCommodity(idCommodity);
			CommodityType commodityType = commodityTypeService.selectTypeNameIdType(commodity.getCommodityType());
			List<Comment> listComment = commentService.listComment(commodity.getIdCommodity());
			int commentNumber = commentService.selectCommentNumber(commodity.getIdCommodity());
			List<Commodity> listCommodity = commodityService.listCommodity(null);
			List<Users> listUsers = usesService.listUsers();
			modelAndView.addObject("commodity", commodity);
			modelAndView.addObject("commodityType", commodityType);
			modelAndView.addObject("listComment", listComment);
			modelAndView.addObject("commentNumber", commentNumber);
			modelAndView.addObject("listCommodity", listCommodity);
			modelAndView.addObject("listUsers", listUsers);
			modelAndView.setViewName("frontend/shop-detail");
			return modelAndView;
		} else {
			return null;
		}
	}

	/**
	 * 增加购物车
	 */
	@RequestMapping(value = "/saveShoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> savesaveShoppingcart(Integer idIndex, Integer number, HttpServletRequest request)
			throws Exception {
		return homeController.savesaveShoppingcart(idIndex, number, request);
	}

	/**
	 * 增加收藏
	 * 
	 * @param collection
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveCollection", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> saveCollection(Collection collection, HttpServletRequest request) throws Exception {
		return homeController.saveCollection(collection, request);
	}

	/**
	 * 根据ID查询商品的详情
	 * 
	 * @param idIndex
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectCommodity", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> selectCommodity(Integer idIndex) throws Exception {
		return homeController.selectCommodity(idIndex);
	}
}
