package org.simpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simpro.service.UserService;
import org.simpro.utils.DateUtil;
import org.simpro.utils.OrgConstant;
import org.simpro.utils.PropertiesUtils;
import org.simpro.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.utils.Constant;

/**
 * 用户登录 控制层
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
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
	@RequestMapping(value="/getUserList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUserList(HttpServletRequest request,HttpServletResponse response,String user_name,String user_state,Integer currpage){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("user_name",user_name);
			user_state = "-1".equals(user_state) ?null:user_state;
			paraMap.put("user_state",user_state);

			int countSum = userService.getUserListCount(paraMap);
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
			
			List<Map<String,Object>> user = userService.getUserList(paraMap);
			if(user==null||user.size()==0) {
				resMap.put("resCode", 401);
				resMap.put("resMsg", "暂无数据");
				logger.error("获取用户列表信息！暂无数据。当前时间："+DateUtil.getTime());
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
				resMap.put("user", user);
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
	 * 2019年6月17日 上午11:47:03 
	 * TODO(插入用户信息)   
	 * @param request
	 * @param response
	 * @param user_name
	 * @param user_password
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("insertUserInfo")
	@ResponseBody
	public Map<String,Object> insertUserInfo(HttpServletRequest request,HttpServletResponse response,String user_name,String user_password,Integer roleId){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			if(StringUtils.isEmpty(user_name)||StringUtils.isEmpty(user_password)||StringUtils.isEmpty(roleId)) {
				resMap.put("resCode", 402);
				resMap.put("resMsg", "参数错误");
				logger.error("保存用户信息，参数错误");
				return resMap;
			}
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("user_name", user_name);
			paraMap.put("user_password", user_password);
			paraMap.put("user_state", OrgConstant.USER_STATE_ON);
			paraMap.put("create_time", DateUtil.getTime());
			paraMap.put("update_time", DateUtil.getTime());
			paraMap.put("last_login_time", DateUtil.getTime());
			paraMap.put("roleId", roleId);
			
			Integer isSuccess = userService.insertUserInfo(paraMap);
			if(isSuccess!=1) {
				String msg = "保存错误";
				if(isSuccess==-1) {
					msg = "该用户已存在";
				}
				resMap.put("resCode", 201);
				resMap.put("resMsg", msg);
				logger.error("保存用户信息错误！当前时间："+DateUtil.getTime());
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
			}
			
			
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "保存失败");
			logger.error("保存用户信息失败：失败原因："+e.getMessage()+";当前时间："+DateUtil.getTime());
		}
		return resMap;
	}
	
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午10:02:28 
	 * TODO(通过id删除用户信息)   
	 * @param request
	 * @param response
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("deleteUserInfoById")
	@ResponseBody
	public Map<String,Object> deleteUserInfoById(HttpServletRequest request,HttpServletResponse response,Integer id){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			if(id==null||"".equals(id)) {
				resMap.put("resCode", 400);
				resMap.put("resMsg", "参数错误");
				LOGGER(logger, "删除用户信息", "参数错误");
				return resMap;
			}
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("id", id);
			paraMap.put("update_time", DateUtil.getTime());
			paraMap.put("user_state", OrgConstant.USER_STATE_OFF);
			
			Integer isSuccess = userService.deleteUserInfoById(paraMap);
			if(isSuccess!=1) {
				resMap.put("resCode", 402);
				resMap.put("resMsg", "删除失败！");
				LOGGER(logger, "删除用户信息", "删除返回结果"+isSuccess);
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg","success");
			}
			
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "删除失败！");
			logger.error("删除用户信息失败，失败原因："+e.getMessage()+",当前时间："+DateUtil.getTime());
		}
		return resMap;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午5:41:59 
	 * TODO(通过Id获取用户信息)   
	 * @param request
	 * @param response
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("getUserInfo")
	@ResponseBody
	public Map<String,Object> getUserInfo(HttpServletRequest request,HttpServletResponse response,String id){
		Map<String,Object> resMap = new HashMap<String, Object>();
		Map<String,Object> data = userService.getUserInfo(id);
		if(data==null||data.size()==0) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "暂无数据");
			LOGGER(logger, "获取用户信息", "暂无数据");
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("user", data);
		}
		return resMap;
	}
	
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月17日 上午11:47:03 
	 * TODO(插入用户信息)   
	 * @param request
	 * @param response
	 * @param user_name
	 * @param user_password
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public Map<String,Object> updateUserInfo(HttpServletRequest request,HttpServletResponse response,String user_name,String user_password,Integer roleId,String userId){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			if(StringUtils.isEmpty(user_name)||StringUtils.isEmpty(user_password)||StringUtils.isEmpty(roleId)||StringUtils.isEmpty(userId)) {
				resMap.put("resCode", 402);
				resMap.put("resMsg", "参数错误");
				logger.error("保存用户信息，参数错误");
				return resMap;
			}
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("user_name", user_name);
			paraMap.put("user_password", user_password);
			paraMap.put("user_state", OrgConstant.USER_STATE_ON);
			paraMap.put("create_time", DateUtil.getTime());
			paraMap.put("update_time", DateUtil.getTime());
			paraMap.put("userId", userId);
			paraMap.put("last_login_time", DateUtil.getTime());
			paraMap.put("roleId", roleId);
			
			Integer isSuccess = userService.updateUserInfo(paraMap);
			if(isSuccess!=1) {
				resMap.put("resCode", 201);
				resMap.put("resMsg", "保存错误");
				logger.error("保存用户信息错误！当前时间："+DateUtil.getTime());
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
			}
			
			
		} catch (Exception e) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "保存失败");
			logger.error("保存用户信息失败：失败原因："+e.getMessage()+";当前时间："+DateUtil.getTime());
		}
		return resMap;
	}
}
