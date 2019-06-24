package org.simpro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
   *   页面接口管理所有页面
 * @author yan_zhx
 * 2019年6月13日
 * TODO
 */
@Controller
@RequestMapping("/pageInterfaceController")
public class PageInterfaceController extends BaseController {

	@RequestMapping("/toEmailIndex")
	public String toEmailIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/email";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * yan_zhx 
	 * 2019年6月13日 下午3:40:46 
	 * TODO(跳转到用户列表信息)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toUserListIndex")
	public String toUserListIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/userList";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月13日 下午3:49:00 
	 * TODO(添加用户信息)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toAddUserIndex")
	public String toAddUserIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/addUser";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月13日 下午3:49:00 
	 * TODO(添加用户信息)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toModifyUserIndex")
	public String toModifyUserIndex(HttpServletRequest request,HttpServletResponse response,Model model,String id) {
		String url = "view/manage/modifyUser";
		model.addAttribute("basePath",request.getContextPath());
		model.addAttribute("id",id);
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午10:41:20 
	 * TODO(资源列表)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toSourceListIndex")
	public String toSourceListIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/sourceList";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:44:36 
	 * TODO(跳转到资源添加页面)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toAddSourceIndex")
	public String toAddSourceIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/addSource";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 下午3:57:30 
	 * TODO(跳转到角色列表页面)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toRbacListIndex")
	public String toRbacListIndex(HttpServletRequest request,HttpServletResponse response,Model model){
		String url ="view/manage/rbacList";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:44:36 
	 * TODO(跳转到资源添加页面)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toAddRbacIndex")
	public String toAddRbacIndex(HttpServletRequest request,HttpServletResponse response,Model model) {
		String url = "view/manage/addRbac";
		model.addAttribute("basePath",request.getContextPath());
		return url;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:44:36 
	 * TODO(跳转到资源添加页面)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toModifyRbacIndex")
	public String toModifyRbacIndex(HttpServletRequest request,HttpServletResponse response,Model model,String id) {
		String url = "view/manage/modifyRbac";
		model.addAttribute("basePath",request.getContextPath());
		model.addAttribute("id",id);
		return url;
	}
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:44:36 
	 * TODO(跳转到资源添加页面)   
	 * @param request
	 * @param response
	 * @param model
	 * @return    设定文件   
	 * String    返回类型
	 */
	@RequestMapping("/toModifySourceIndex")
	public String toModifySourceIndex(HttpServletRequest request,HttpServletResponse response,Model model,String id) {
		String url = "view/manage/modifySource";
		model.addAttribute("basePath",request.getContextPath());
		model.addAttribute("id",id);
		return url;
	}
}
