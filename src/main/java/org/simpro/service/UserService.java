package org.simpro.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author yan_zhx
 * 2019年6月13日
 * TODO
 */
public interface UserService {

	/**
	 * yan_zhx 
	 * 2019年6月13日 下午5:14:36 
	 * TODO(获取用户列表信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserList(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月13日 下午5:42:04 
	 * TODO(获取用户列表数目)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getUserListCount(Map<String, Object> paraMap);

	/**
	 * 插入用户信息
	 * yan_zhx 
	 * 2019年6月17日 上午11:41:50 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer insertUserInfo(Map<String, Object> paraMap);

	/**
	 * 通过用户Id删除用户信息
	 * yan_zhx 
	 * 2019年6月18日 上午10:15:06 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer deleteUserInfoById(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午5:46:02 
	 * TODO(获取用户信息)   
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getUserInfo(String id);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月20日 上午9:39:30 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer updateUserInfo(Map<String, Object> paraMap);

}
