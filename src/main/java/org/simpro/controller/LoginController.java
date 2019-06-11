package org.simpro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simpro.service.LoginService;
import org.simpro.utils.DateUtil;
import org.simpro.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户登录 控制层
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 登录地址的信息
	 * yan_zhx 
	 * 2019年6月11日 下午2:41:37 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @param model
	 * @param user_name
	 * @param user_password
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login (HttpServletRequest request,HttpServletResponse response,Model model,String user_name,String user_password){
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(StringUtils.isEmpty(user_password)||StringUtils.isEmpty(user_name)) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "参数错误");
			logger.error("点击登录失败：参数错误参数为空：当前时间："+DateUtil.getTime());
		}
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("user_name", user_name);
		paraMap.put("user_password", user_password);
		paraMap.put("last_login_time", DateUtil.getTime());
		
		Map<String,Object> customer = loginService.getLoginInfo(paraMap);
		if(customer==null||customer.size()==0) {
			resMap.put("resCode", 400);
			resMap.put("resMsg", "暂无数据");
			logger.error("暂无数据;查询参数："+paraMap.toString()+"当前时间："+DateUtil.getTime());
		}else {
			HttpSession hs = request.getSession();
			hs.setAttribute("LOGIN_USER", customer.get("user_name"));
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("redirectUrl", "/loginController/toLoginIndex.do");
			
			//Integer isSuccess = loginService.updateLastLoginTime(paraMap);
		}
		
		return resMap;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月11日 下午4:05:25 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping(value="/toLoginIndex")
	public String toLoginIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "/view/manage/index";
		HttpSession hs = request.getSession();
		System.out.println(hs.getAttribute("LOGIN_USER"));
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
}
