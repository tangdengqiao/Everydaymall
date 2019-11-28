package com.everydaymall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.everydaymall.entity.Users;
import com.everydaymall.mapper.CommodityMapper;
import com.everydaymall.service.ICollectionService;
import com.everydaymall.service.ICommodityService;
import com.everydaymall.service.ICommodityTypeService;
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

	/**
	 * 跳转到前端主页
	 * 
	 * @return
	 */
	@RequestMapping("/doFrontendHome")
	public ModelAndView doFrontendHome(@RequestParam(value = "commodityName", defaultValue = "") String commodityName,
			ModelAndView modelAndView, @RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "4") int size) throws Exception {
		PageHelper.startPage(start, size, "id_index asc");
		List<Commodity> listCommodity = commodityService.listCommodity(commodityName);
		PageInfo<Commodity> page = new PageInfo<Commodity>(listCommodity);
		modelAndView.addObject("pages", page);
		List<CommodityType> listCommodityType = commodityTypeService.listCommodityType();
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
	 */
	@RequestMapping(value = "/selectCommodity", method = RequestMethod.POST)
	@ResponseBody
	public Commodity selectCommodity(Integer idIndex) throws Exception {
		System.out.println(idIndex);
		Commodity Commodity = commodityService.selectCommodity(idIndex);
		if (Commodity != null) {
			return Commodity;
		} else {
			return null;
		}
	}

	/**
	 * 增加收藏
	 * 
	 * @param collection
	 * @return
	 */
	@RequestMapping(value = "/saveCollection", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> saveCollection(Collection collection,HttpServletRequest request) throws Exception {
		System.out.println(collection);
		HttpSession session = request.getSession();
		Users users= (Users)session.getAttribute("user");
		collection.setIdUser(users.getIdUser());
		collection.setIdCommodity(collection.getIdCommodity());
		if (collectionService.saveCollection(collection) > Constants.SAVEREGISTER_SUCESS) {
			return new ResponseResult<Object>(200, "已收藏");
		} else {
			return new ResponseResult<Object>(500, "收藏失败");
		}
	}
}
