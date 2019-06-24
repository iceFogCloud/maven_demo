package org.simpro.dao;

import java.util.List;
import java.util.Map;

/**
 * 获取登陆信息
 * @author yan_zhx
 * 2019年6月11日
 * TODO
 */
public interface RbacMapper {

	/**
	 * 获取用户权限信息
	 * yan_zhx 
	 * 2019年6月12日 下午2:17:53 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserRbacInfo(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 下午4:13:31 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getRbacListCount(Map<String, Object> paraMap);
	
	/**
	 * 获取角色列表信息
	 * yan_zhx 
	 * 2019年6月18日 下午4:21:32 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getRbacList(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午2:18:30 
	 * TODO(插入全新信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer insertRbacInfo(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月19日 下午2:29:42 
	 * TODO(批量插入权限关联信息)   
	 * @param list
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer batchInsertRbacSourceMatch(List<Map<String, Object>> paraList);

	/**
	 *	 获取角色列表信息
	 * yan_zhx 
	 * 2019年6月19日 下午3:34:30 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getRoleSelectList(Map<String, Object> paraMap);

	/**
	 * 通过主键Id获取用户信息
	 * yan_zhx 
	 * 2019年6月20日 上午11:03:54 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getRoleInfoByKey(Integer id);

	/**
	 * 更新角色信息
	 * yan_zhx 
	 * 2019年6月20日 上午11:38:21 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer updateRbacInfo(Map<String, Object> paraMap);

	/**
	 * 删除角色资源关联信息
	 * yan_zhx 
	 * 2019年6月20日 上午11:40:06 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer deleteRbacSourceMatch(Map<String, Object> paraMap);

	/**
	 * 获取用户权限资源树
	 * yan_zhx 
	 * 2019年6月24日 下午4:39:33 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getUserRbacInfoTree(Map<String, Object> paraMap);

      
} 