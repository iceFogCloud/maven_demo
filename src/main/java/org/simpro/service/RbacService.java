package org.simpro.service;

import java.util.List;
import java.util.Map;

/**
 * 登录接口
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
public interface RbacService {

	/**
	 * 获取用户权限信息
	 * yan_zhx 
	 * 2019年6月12日 下午2:11:07 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserRbacInfo(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 下午4:12:27 
	 * TODO(获取角色数目)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getRbacListCount(Map<String, Object> paraMap);

	/**
	 * yan_zhx 
	 * 2019年6月18日 下午4:20:36 
	 * TODO(获取角色列表信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getRbacList(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 上午11:06:04 
	 * TODO(获取角色资源树)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserRbacInfoTree(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午2:03:10 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> insertRbacInfo(Map<String, Object> paraMap);

	/**
	 * 获取角色列表信息
	 * yan_zhx 
	 * 2019年6月19日 下午3:31:30 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getRoleSelectList(Map<String, Object> paraMap);

	/**
	 * 获取角色用户信息
	 * yan_zhx 
	 * 2019年6月20日 上午11:02:50 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param valueOf
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getRoleInfoByKey(Integer id);

	/**
	 * 更新权限信息
	 * yan_zhx 
	 * 2019年6月20日 上午11:33:48 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> updateRbacInfo(Map<String, Object> paraMap);

}
