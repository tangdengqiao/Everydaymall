package com.everydaymall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.common.result.ResponseResult;
import com.everydaymall.entity.Collection;
import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;
import com.everydaymall.entity.Shoppingcart;
import com.everydaymall.entity.Users;
import com.everydaymall.service.ICollectionService;
import com.everydaymall.service.ICommodityService;
import com.everydaymall.service.ICommodityTypeService;
import com.everydaymall.service.IShoppingcartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private ICommodityService commodityService;

	@Autowired
	private ICommodityTypeService commodityTypeService;

	@Autowired
	private ICollectionService collectionService;

	@Autowired
	private IShoppingcartService shoppingcartService;

	/**
	 * 跳转到前端主页并且加载所有商品
	 * 
	 * @param commodityName
	 * @param modelAndView
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doFrontendHome")
	public ModelAndView doFrontendHome(@RequestParam(value = "commodityName", defaultValue = "") String commodityName,
			ModelAndView modelAndView, @RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "4") int size) throws Exception {
		PageHelper.startPage(start, size, "id_index asc");
		List<Commodity> listCommodity = commodityService.listCommodity(commodityName);
		PageInfo<Commodity> page = new PageInfo<Commodity>(listCommodity);
		modelAndView.addObject("pages", page);
		List<CommodityType> listCommodityType = commodityTypeService.listCommodityTypeLimit();
		modelAndView.addObject("listCommodityType", listCommodityType);
		modelAndView.addObject("commodityName", commodityName);
		modelAndView.setViewName("frontend/index");
		return modelAndView;
	}

	/**
	 * 根据ID查询商品的详情
	 * 
	 * @param idIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/selectCommodity", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> selectCommodity(Integer idIndex) throws Exception {
		Commodity commodity = commodityService.selectCommodityIdIndex(idIndex);
		List<CommodityType> listCommodityType = commodityTypeService.listCommodityType();
		List<Object> list = new ArrayList<>();
		list.add(commodity);
		list.add(listCommodityType);
		if (list != null) {
			return list;
		} else {
			return null;
		}
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
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		if (users != null) {
			collection.setIdUser(users.getIdUser());
			collection.setIdCommodity(collection.getIdCommodity());
			if (collectionService.saveCollection(collection) > Constants.SAVEREGISTER_SUCESS) {
				return new ResponseResult<Object>(200, "已收藏");
			} else {
				return new ResponseResult<Object>(500, "收藏失败");
			}
		} else {
			return new ResponseResult<Object>(100, "你还没有登录，请先登录");
		}
	}

	/**
	 * 增加购物车
	 */
	@RequestMapping(value = "/saveShoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> savesaveShoppingcart(Integer idIndex, Integer number, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		if (users != null) {
			Commodity commodity = commodityService.selectCommodityIdIndex(idIndex);
			Shoppingcart shoppingcarta = shoppingcartService.selectShoppingcart(commodity.getIdCommodity(),
					users.getIdUser());
			Shoppingcart shoppingcart = new Shoppingcart();
			if (shoppingcarta == null) {
				shoppingcart.setIdCommodity(commodity.getIdCommodity());
				shoppingcart.setShoppingcartPrice(commodity.getCommodityPrice());
				shoppingcart.setShoppingcartNumber(number);
				shoppingcart.setShoppingcartCreateby(users.getIdUser());
				if (shoppingcartService.saveShoppingcart(shoppingcart) > Constants.SAVEREGISTER_SUCESS) {
					return new ResponseResult<Object>(200, "已加入购物车");
				} else {
					return new ResponseResult<Object>(500, "加入购物车失败");
				}
			} else {
				shoppingcart.setIdIndex(shoppingcarta.getIdIndex());
				shoppingcart.setShoppingcartNumber(shoppingcarta.getShoppingcartNumber() + number);
				if (shoppingcartService.updateShoppingcartNumber(shoppingcart) > Constants.SAVEREGISTER_SUCESS) {
					return new ResponseResult<Object>(200, "已加入购物车");
				} else {
					return new ResponseResult<Object>(500, "加入购物车失败");
				}
			}
		} else {
			return new ResponseResult<Object>(100, "你还没有登录，请先登录");
		}
	}
}
