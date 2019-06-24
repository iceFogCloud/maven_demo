package org.simpro.service.Impl;

import java.util.List;
import java.util.Map;

import org.simpro.controller.BaseController;
import org.simpro.dao.SourceMapper;
import org.simpro.dao.UserMapper;
import org.simpro.service.SourceService;
import org.simpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取资源列表信息
 * @author yan_zhx
 * 2019年6月18日
 * TODO
 */
@Service("sourceServiceImpl")  
public class SourceServiceImpl extends BaseController implements SourceService {

	
	@Autowired
	private SourceMapper sourceMapper;

	@Override
	public Integer getSourceListCount(Map<String, Object> paraMap) {
		return sourceMapper.getSourceListCount(paraMap);
	}

	/**
	 * 获取资源列表信息
	 */
	@Override
	public List<Map<String, Object>> getSourceList(Map<String, Object> paraMap) {
		return sourceMapper.getSourceList(paraMap);
	}

	/**
	 * 获取资源列表信息
	 */
	@Override
	public List<Map<String, Object>> getSourceSelectList() {
		return sourceMapper.getSourceSelectList();
	}

	/**
	 * 
	 */
	@Override
	public Integer insertSourceInfo(Map<String, Object> paraMap) {
		return sourceMapper.insertSourceInfo(paraMap);
	}

	/**
	 * 获取角色资源信息
	 */
	@Override
	public Map<String, Object> getSourceInfo(String id) {
		return sourceMapper.getSourceInfo(id);
	}

	@Override
	public Integer updateSourceInfo(Map<String, Object> paraMap) {
		return sourceMapper.updateSourceInfo(paraMap);
	}
	
}
