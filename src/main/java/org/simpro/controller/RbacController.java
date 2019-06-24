package org.simpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simpro.service.LoginService;
import org.simpro.service.RbacService;
import org.simpro.utils.DateUtil;
import org.simpro.utils.OrgConstant;
import org.simpro.utils.PropertiesUtils;
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
@RequestMapping("/rbacController")
public class RbacController extends BaseController {

	@Autowired
	private RbacService rbacService;
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月12日 下午1:52:40 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @param model
	 * @param user_name
	 * @param user_password
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/getUserRbacInfo")
	@ResponseBody
	public Map<String,Object> getUserRbacInfo (HttpServletRequest request,HttpServletResponse response,Model model){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		HttpSession hs = request.getSession();
		
		Integer userId = 0;
		if(StringUtils.isEmpty(hs.getAttribute("userId"))) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "参数错误");
			logger.error("点击登录失败：参数错误参数为空：当前时间："+DateUtil.getTime());
		}else {
			userId = Integer.valueOf(hs.getAttribute("userId").toString());
		}
		
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("userId", userId);
		
		List<Map<String,Object>> rbac = rbacService.getUserRbacInfo(paraMap);
		if(rbac==null||rbac.size()==0) {
			resMap.put("resCode", 400);
			resMap.put("resMsg", "暂无数据");
			logger.error("暂无数据;查询参数："+paraMap.toString()+"当前时间："+DateUtil.getTime());
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("rbac", rbac);
		}
		
		return resMap;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月13日 下午5:07:39 
	 * TODO(获取用户列表信息)   
	 * @param request
	 * @param response
	 * @param user_name
	 * @param user_state
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/getRbacList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getRbacList(HttpServletRequest request,HttpServletResponse response,String role_name,String role_state,Integer currpage){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("role_name",role_name);
			role_state = "-1".equals(role_state) ?null:role_state;
			paraMap.put("rabc_state",role_state);

			int countSum = rbacService.getRbacListCount(paraMap);
	    	int pageSize = PropertiesUtils.getPara("pageSize")!=null?Integer.parseInt(PropertiesUtils.getPara("pageSize")):10;
	    	//计算最大页数
	    	int maxPage = (countSum-1)/pageSize+1;
	    	if(currpage>maxPage) {
	    		currpage = maxPage;
	    	}
	    	//查询起始数
	    	int curNum = (currpage-1)*pageSize;
	    	
	    	paraMap.put("curNum", curNum);
	    	paraMap.put("pageSize", pageSize);
	    	
	    	resMap.put("setTotalCount", countSum);
	    	resMap.put("totalPages", maxPage);
			
			List<Map<String,Object>> rbac = rbacService.getRbacList(paraMap);
			if(rbac==null||rbac.size()==0) {
				resMap.put("resCode", 401);
				resMap.put("resMsg", "暂无数据");
				logger.error("获取用户列表信息！暂无数据。当前时间："+DateUtil.getTime());
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
				resMap.put("rbac", rbac);
			}
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "获取失败");
			logger.error("获取用户信息过程中失败！当前时间："+DateUtil.getTime());
		}
		return resMap;
	}
	
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月12日 下午1:52:40 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param request
	 * @param response
	 * @param model
	 * @param user_name
	 * @param user_password
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/getUserRbacInfoTree")
	@ResponseBody
	public List<Map<String,Object>> getUserRbacInfoTree (HttpServletRequest request,HttpServletResponse response,Model model){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		HttpSession hs = request.getSession();
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("userId", null);
		
		List<Map<String,Object>> rbac = rbacService.getUserRbacInfoTree(paraMap);
		if(rbac==null||rbac.size()==0) {
			resMap.put("resCode", 400);
			resMap.put("resMsg", "暂无数据");
			logger.error("暂无数据;查询参数："+paraMap.toString()+"当前时间："+DateUtil.getTime());
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("rbac", rbac);
		}
		
		return rbac;
	}
	
	/**
	 * yan_zhx 
	 * 2019年6月19日 下午1:50:18 
	 * TODO(插入角色信息和资源关联)   
	 * @param request
	 * @param response
	 * @param role_name
	 * @param sourceIds
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/insertRbacInfo")
	@ResponseBody
	public Map<String,Object> insertRbacInfo(HttpServletRequest request,HttpServletResponse response,String role_name,String sourceIds){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			
			if (StringUtils.isEmpty(role_name)||StringUtils.isEmpty(sourceIds)) {
				resMap.put("resCode", 400);
				resMap.put("resMsg", "参数错误");
				LOGGER(logger, "保存权限信息", "参数错误");
				return resMap;
			}
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("role_name", role_name);
			paraMap.put("sourceIds", sourceIds);
			paraMap.put("role_state", OrgConstant.ROLE_STATE_ON);
			paraMap.put("create_time", DateUtil.getTime());
			paraMap.put("update_time", DateUtil.getTime());
			
			Map<String,Object> data = rbacService.insertRbacInfo(paraMap);
			if(data==null||data.size()==0) {
				resMap.put("resCode", 402);
				resMap.put("resMsg", "保存失败");
				LOGGER(logger, "保存权限信息", "执行过程失败");
			}else {
				return data;
			}
			
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "执行过程中失败！");
			LOGGER(logger, "保存权限信息", "保存过程中失败！"+e.getMessage());
		}
		return resMap;
	}
	
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午3:28:55 
	 * TODO(获取角色select信息)   
	 * @param request
	 * @param response
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("getRoleSelectList")
	@ResponseBody
	public Map<String,Object> getRoleSelectList(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("role_state", OrgConstant.ROLE_STATE_ON);
		
		List<Map<String,Object>> role = rbacService.getRoleSelectList(paraMap);
		if(role==null||role.size()==0) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "暂无数据");
			LOGGER(logger, "获取角色列表信息", "暂无数据");
			return resMap;
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("role", role);
		}
		return resMap;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月20日 上午10:57:05 
	 * TODO(获取角色信息)   
	 * @param request
	 * @param response
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("getRoleInfo")
	@ResponseBody
	public Map<String,Object> getRoleInfo(HttpServletRequest request,HttpServletResponse response,String id) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		if(StringUtils.isEmpty(id)) {
			resMap.put("resCode", 400);
			resMap.put("resMsg", "参数错误");
			LOGGER(logger, "获取角色信息", "参数错误");
			return resMap;
		}
		
		Map<String,Object> role = rbacService.getRoleInfoByKey(Integer.valueOf(id));
		if(role==null||role.size()==0) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "暂无数据");
			LOGGER(logger, "获取角色信息", "暂无数据");
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("role", role);
		}
		return resMap;
	}
	
	/**
	 * yan_zhx 
	 * 2019年6月19日 下午1:50:18 
	 * TODO(插入角色信息和资源关联)   
	 * @param request
	 * @param response
	 * @param role_name
	 * @param sourceIds
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/updateRbacInfo")
	@ResponseBody
	public Map<String,Object> updateRbacInfo(HttpServletRequest request,HttpServletResponse response,String role_name,String sourceIds,String roleId){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			
			if (StringUtils.isEmpty(role_name)||StringUtils.isEmpty(sourceIds)||StringUtils.isEmpty(roleId)) {
				resMap.put("resCode", 400);
				resMap.put("resMsg", "参数错误");
				LOGGER(logger, "更新权限信息", "参数错误");
				return resMap;
			}
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("role_name", role_name);
			paraMap.put("roleId", roleId);
			paraMap.put("sourceIds", sourceIds);
			paraMap.put("role_state", OrgConstant.ROLE_STATE_ON);
			paraMap.put("create_time", DateUtil.getTime());
			paraMap.put("update_time", DateUtil.getTime());
			
			Map<String,Object> data = rbacService.updateRbacInfo(paraMap);
			if(data==null||data.size()==0) {
				resMap.put("resCode", 402);
				resMap.put("resMsg", "保存失败");
				LOGGER(logger, "更新权限信息", "执行过程失败");
			}else {
				return data;
			}
			
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "执行过程中失败！");
			LOGGER(logger, "更新权限信息", "保存过程中失败！"+e.getMessage());
		}
		return resMap;
	}
}
