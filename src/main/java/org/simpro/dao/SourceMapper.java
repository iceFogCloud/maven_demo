package org.simpro.dao;

import java.util.List;
import java.util.Map;

/**
 * 资源Mapper
 * @author yan_zhx
 * 2019年6月18日
 * TODO
 */
public interface SourceMapper {

	/**
	 * yan_zhx 
	 * 2019年6月18日 上午11:03:12 
	 * TODO(获取资源列表信息)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer getSourceListCount(Map<String, Object> paraMap);

	/**
	 * 获取资源列表信息
	 * yan_zhx 
	 * 2019年6月18日 上午11:08:12 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getSourceList(Map<String, Object> paraMap);

	/**
	 * 获取资源下拉列表
	 * yan_zhx 
	 * 2019年6月18日 下午1:26:06 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @return    设定文件   
	 * List<Map<String,Object>>    返回类型
	 */
	List<Map<String, Object>> getSourceSelectList();

	/**
	 * 保存资源信息
	 * yan_zhx 
	 * 2019年6月18日 下午3:23:55 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer insertSourceInfo(Map<String, Object> paraMap);

	/**
	 * 获取
	 * yan_zhx 
	 * 2019年6月20日 下午1:22:45 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param id
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	Map<String, Object> getSourceInfo(String id);

	/**
	 * 更新资源信息
	 * yan_zhx 
	 * 2019年6月20日 下午1:47:12 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param paraMap
	 * @return    设定文件   
	 * Integer    返回类型
	 */
	Integer updateSourceInfo(Map<String, Object> paraMap);

	 

} 