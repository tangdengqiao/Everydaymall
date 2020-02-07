package com.everydaymall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.common.result.ResponseResult;
import com.everydaymall.entity.Users;
import com.everydaymall.service.IUsesService;
import com.everydaymall.shiro.PasswordHelper;
import com.everydaymall.utils.FileUtil;

@Controller
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private IUsesService usesService;

	@Autowired
	private FileUtil fileUtil;

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/doRegister")
	public String doRegister() throws Exception {
		return "login/register";
	}

	/**
	 * 注册
	 * 
	 * @param users
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> register(Users users,
			@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
		if (users != null && !file.isEmpty()) {
			String imagePath = "";
			if (!file.isEmpty()) {
				imagePath = fileUtil.uploadFile(file, Constants.USER_HEADPORTRAIT);
			}
			users.setUserHeadportrait(imagePath);
			if (usesService.selectByUsername(users.getUserName()) == null) {
				if (usesService.saveRegister(users) > Constants.SAVEREGISTER_SUCESS) {
					return new ResponseResult<Object>(200, "注册成功");
				} else {
					return new ResponseResult<Object>(500, "注册失败");
				}
			} else {
				return new ResponseResult<Object>(500, "该账户名已被占用");
			}
		} else {
			return new ResponseResult<Object>(500, "填充的数据或者文件为空");
		}
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin() {
		return "login/login";
	}

	/**
	 * 登录
	 * 
	 * @param users
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Object> login(Users users, HttpServletRequest request) throws Exception {
		if (users.getUserPwd() != null && !(users.getUserPwd().equals("")) && users.getUserName() != null
				&& !(users.getUserName().equals(""))) {
			Users u = usesService.selectByUsername(users.getUserName());
			if (null == u || !PasswordHelper.checkCredentials(users.getUserPwd(), u.getSalt(), u.getUserPwd())) {
				return new ResponseResult<Object>(500, "帐号或密码错误");
			} else if (new Integer(1).equals(u.getLocked())) {
				return new ResponseResult<Object>(500, "帐号已锁定，请与管理员联系");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				return new ResponseResult<Object>(200, "登录成功");
			}
		} else {
			return new ResponseResult<Object>(500, "填充的数据为空");
		}
	}

}
