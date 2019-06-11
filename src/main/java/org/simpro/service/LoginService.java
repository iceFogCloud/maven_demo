package org.simpro.service;

import java.util.Map;

/**
 * 登录接口
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
public interface LoginService {

	/**
	 * 根据用户名和密码获取登陆信息
	 * yan_zhx 
	 * 2019年6月11日 下午2:53:57 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getLoginInfo(Map<String, Object> paraMap);

}
