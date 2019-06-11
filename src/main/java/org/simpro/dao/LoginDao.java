package org.simpro.dao;

import java.util.Map;

/**
 * 获取登陆信息
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
public interface LoginDao {

	/**
	 * 获取登陆信息
	 * yan_zhx 
	 * 2019年6月11日 下午2:55:13 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getLoginInfo(Map<String, Object> paraMap);  
      
} 