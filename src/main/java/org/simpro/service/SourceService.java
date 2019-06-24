package org.simpro.service;

import java.util.List;
import java.util.Map;

/**
 * 资源列表
 * @author yan_zhx
 * 2019年6月18日
 * TODO
 */
public interface SourceService {

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:01:24 
	 * TODO(获取资源列表数目)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getSourceListCount(Map<String, Object> paraMap);

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 上午11:07:06 
	 * TODO(获取资源列表信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getSourceList(Map<String, Object> paraMap);

	/**
	 * 获取资源列表信息下拉的
	 * yan_zhx 
	 * 2019年6月18日 下午1:24:42 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getSourceSelectList();

	/**
	 * 
	 * yan_zhx 
	 * 2019年6月18日 下午3:21:57 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer insertSourceInfo(Map<String, Object> paraMap);

	/**
	 * 获取资源信息
	 * yan_zhx 
	 * 2019年6月20日 下午12:00:59 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getSourceInfo(String id);

	/**
	 * 更新资源信息
	 * yan_zhx 
	 * 2019年6月20日 下午1:46:27 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer updateSourceInfo(Map<String, Object> paraMap);
}
