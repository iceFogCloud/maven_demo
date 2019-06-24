package org.simpro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 获取登陆信息
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
public interface UserMapper {

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月13日 下午5:15:51 
	 * TODO(获取用户列表信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserList(Map<String, Object> paraMap);

	/**
	 * 获取用户列表数目
	 * yan_zhx 
	 * 2019年6月13日 下午5:42:56 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getUserListCount(Map<String, Object> paraMap);

	/**
	 * 插入用户信息
	 * yan_zhx 
	 * 2019年6月17日 上午11:42:45 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer insertUserInfo(Map<String, Object> paraMap);

	/**
	 * 通过Id删除用户信息
	 * yan_zhx 
	 * 2019年6月18日 上午10:16:03 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer deleteUserInfoById(Map<String, Object> paraMap);

	/**
	 * 插入用户角色关联信息
	 * yan_zhx 
	 * 2019年6月19日 下午3:53:26 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer inserUserRoleMatch(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午5:46:54 
	 * TODO(获取用户信息)   
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getUserInfo(@Param("id")Integer id);

	/**
	 * 更新用户信息
	 * yan_zhx 
	 * 2019年6月20日 上午9:43:46 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer updateUserInfo(Map<String, Object> paraMap);
	
	/**
	 * 
	 * yan_zhx 
	 * 2019年6月20日 上午9:48:47 
	 * TODO(删除用户角色关联)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer deleteUserRoleMatch(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月20日 上午10:28:42 
	 * TODO(获取用户数目)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getUserCount(Map<String, Object> paraMap);

} 