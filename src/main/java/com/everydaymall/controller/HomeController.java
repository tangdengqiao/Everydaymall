package com.everydaymall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;
import com.everydaymall.mapper.CommodityMapper;
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
		modelAndView.setViewName("frontend/index");
		return modelAndView;
	}
}
