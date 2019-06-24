package org.simpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simpro.service.SourceService;
import org.simpro.service.UserService;
import org.simpro.utils.DateUtil;
import org.simpro.utils.GetRequestMapUtil;
import org.simpro.utils.OrgConstant;
import org.simpro.utils.PropertiesUtils;
import org.simpro.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/sourceController")
public class SourceController extends BaseController {

	@Autowired
	private SourceService sourceService;
	
	
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
	@RequestMapping(value="/getSourceList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSourceList(HttpServletRequest request,HttpServletResponse response,String source_name,Integer currpage){
		Map<String,Object> resMap = new HashMap<String, Object>();
		try {
			
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("source_name",source_name);

			int countSum = sourceService.getSourceListCount(paraMap);
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
			
			List<Map<String,Object>> source = sourceService.getSourceList(paraMap);
			if(source==null||source.size()==0) {
				resMap.put("resCode", 401);
				resMap.put("resMsg", "暂无数据");
				logger.error("获取用户列表信息！暂无数据。当前时间："+DateUtil.getTime());
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
				resMap.put("source", source);
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
	 * 2019年6月18日 下午1:20:39 
	 * TODO(获取资源列表信息)   
	 * @param request
	 * @param response
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("getSourceSelectList")
	@ResponseBody
	public Map<String,Object> getSourceSelectList(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		List<Map<String,Object>> source = sourceService.getSourceSelectList();
		if(source==null||source.size()==0) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "暂无数据");
			LOGGER(logger, "获取资源下拉列表", "暂无数据");
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("source", source);
		}
		
		return resMap;
	}
	/**
	 * yan_zhx 
	 * 2019年6月18日 下午3:10:55 
	 * TODO(插入资源信息)   
	 * @param request
	 * @param response
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/insertSourceInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertSourceInfo(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		Map<String,Object> paraMap = GetRequestMapUtil.getMapFromRequest(request);
		if(paraMap==null||paraMap.size()==0) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "参数错误");
			LOGGER(logger, "插入资源信息", "参数错误");
			return resMap;
		}
		paraMap.put("create_time", DateUtil.getTime());
		paraMap.put("update_time", DateUtil.getTime());
		
		Integer isSuccess = sourceService.insertSourceInfo(paraMap);
		if(isSuccess!=1) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "保存资源失败！");
			LOGGER(logger, "保存资源信息", "返回结果："+isSuccess);
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
		}
		
		return resMap;
	}
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月20日 上午11:57:19 
	 * TODO(获取资源信息)   
	 * @param request
	 * @param response
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping("getSourceInfo")
	@ResponseBody
	public Map<String,Object> getSourceInfo(HttpServletRequest request,HttpServletResponse response,String id){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		if(StringUtils.isEmpty(id)) {
			resMap.put("resCode", 400);
			resMap.put("resMsg", "参数错误");
			LOGGER(logger, "获取资源信息", "参数错误");
			return resMap;
		}
		
		Map<String,Object> source = sourceService.getSourceInfo(id);
		if(source==null||source.size()==0) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "暂无数据");
			LOGGER(logger, "获取资源信息", "暂无数据");
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
			resMap.put("source", source);
		}
		
		return resMap;
	}
	
	/**
	 * yan_zhx 
	 * 2019年6月18日 下午3:10:55 
	 * TODO(插入资源信息)   
	 * @param request
	 * @param response
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	@RequestMapping(value="/updateSourceInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateSourceInfo(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		Map<String,Object> paraMap = GetRequestMapUtil.getMapFromRequest(request);
		if(paraMap==null||paraMap.size()==0) {
			resMap.put("resCode", 401);
			resMap.put("resMsg", "参数错误");
			LOGGER(logger, "插入资源信息", "参数错误");
			return resMap;
		}
		paraMap.put("create_time", DateUtil.getTime());
		paraMap.put("update_time", DateUtil.getTime());
		
		Integer isSuccess = sourceService.updateSourceInfo(paraMap);
		if(isSuccess!=1) {
			resMap.put("resCode", 204);
			resMap.put("resMsg", "保存资源失败！");
			LOGGER(logger, "保存资源信息", "返回结果："+isSuccess);
		}else {
			resMap.put("resCode", 200);
			resMap.put("resMsg", "success");
		}
		
		return resMap;
	}
}
