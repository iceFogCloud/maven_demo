package org.simpro.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.simpro.controller.BaseController;
import org.simpro.dao.LoginDao;
import org.simpro.dao.RbacMapper;
import org.simpro.service.LoginService;
import org.simpro.service.RbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.model.core.Adapter;

@Service("rbacServiceImpl")  
public class RbacServiceImpl extends BaseController implements RbacService{

	
	@Autowired
	public RbacMapper rbacMapper;

	/**
	 * 获取用户权限
	 */
	@Override
	public List<Map<String, Object>> getUserRbacInfo(Map<String, Object> paraMap) {
		
		List<Map<String,Object>> rbac = rbacMapper.getUserRbacInfo(paraMap);
		/**
		 * 	1：遍历出来root级的资源
		 *  2：遍历rabc，同时内部遍历root级的保存
		 */
		if(rbac!=null&&rbac.size()>0) {
			List<Map<String,Object>> rootRbac = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> map :rbac) {
				Integer pId = Integer.valueOf(map.get("source_pId").toString());
				if(pId.equals(0)) {
					map.put("hidden", false);
					map.put("list", "");
					if(map.get("url")==null||"".equals(map.get("url"))) {
						map.put("url", "");
					}
					rootRbac.add(map);
				}
			}
			
			rbac.removeAll(rootRbac);
			
			List<Map<String,Object>> _rbac = new ArrayList<Map<String,Object>>();
			
			if(rootRbac.size()>0) {
				Integer len = rootRbac.size();
				for(int k=0;k<len;k++) {
					Map<String,Object> _list = rootRbac.get(k);
					Integer _pId = Integer.valueOf(_list.get("id").toString());
					
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					if(rbac.size()>0) {
						for(int g=0;g<rbac.size();g++) {
							Map<String,Object> _map = rbac.get(g);
							if(_map.get("url")==null||"".equals(_map.get("url"))) {
								_map.put("url", "");
							}
							Integer id = Integer.valueOf(_map.get("source_pId").toString());
							if(id == _pId) {
								list.add(_map);
							}
						}
					}
					_list.put("list", list);
					_rbac.add(_list);
				}
				Collections.sort(_rbac, new Comparator<Map<String, Object>>() {
		            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		                Integer name1 = Integer.valueOf(o1.get("source_order").toString()) ;//name1是从你list里面拿出来的一个 
		                Integer name2 = Integer.valueOf(o2.get("source_order").toString()) ; //name1是从你list里面拿出来的第二个name
		                return name1.compareTo(name2);
		            }
		        });
				return _rbac;
			}else {
				return rootRbac;
			}
			
		}else {
			return null;
		}
	}

	/**
	 * 获取角色数目
	 */
	@Override
	public Integer getRbacListCount(Map<String, Object> paraMap) {
		return rbacMapper.getRbacListCount(paraMap);
	}

	/**
	 * 
	 */
	@Override
	public List<Map<String, Object>> getRbacList(Map<String, Object> paraMap) {
		return rbacMapper.getRbacList(paraMap);
	}

	/**
	 * 
	 */
	@Override
	public List<Map<String, Object>> getUserRbacInfoTree(Map<String, Object> paraMap) {
		List<Map<String,Object>> rbac = rbacMapper.getUserRbacInfoTree(paraMap);
		/**
		 * 	1：遍历出来root级的资源
		 *  2：遍历rabc，同时内部遍历root级的保存
		 */
		if(rbac!=null&&rbac.size()>0) {
			List<Map<String,Object>> rootRbac = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> map :rbac) {
				Integer pId = Integer.valueOf(map.get("source_pId").toString());
				if(pId.equals(0)) {
					map.put("hidden", false);
					map.put("children", "");
					if(map.get("url")==null||"".equals(map.get("url"))) {
						map.put("url", "");
					}
					rootRbac.add(map);
				}
			}
			
			rbac.removeAll(rootRbac);
			
			List<Map<String,Object>> _rbac = new ArrayList<Map<String,Object>>();
			
			if(rootRbac.size()>0) {
				Integer len = rootRbac.size();
				for(int k=0;k<len;k++) {
					Map<String,Object> _list = rootRbac.get(k);
					Integer _pId = Integer.valueOf(_list.get("id").toString());
					
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					if(rbac.size()>0) {
						for(int g=0;g<rbac.size();g++) {
							Map<String,Object> _map = rbac.get(g);
							if(_map.get("url")==null||"".equals(_map.get("url"))) {
								_map.put("url", "");
							}
							Integer id = Integer.valueOf(_map.get("source_pId").toString());
							if(id == _pId) {
								list.add(_map);
							}
						}
					}
					_list.put("children", list);
					_rbac.add(_list);
				}
				Collections.sort(_rbac, new Comparator<Map<String, Object>>() {
		            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		                Integer name1 = Integer.valueOf(o1.get("source_order").toString()) ;//name1是从你list里面拿出来的一个 
		                Integer name2 = Integer.valueOf(o2.get("source_order").toString()) ; //name1是从你list里面拿出来的第二个name
		                return name1.compareTo(name2);
		            }
		        });
				return _rbac;
			}else {
				return rootRbac;
			}
			
		}else {
			return null;
		}
	}

	/**
	 * 
	 */
	@Override
	@Transactional
	public Map<String, Object> insertRbacInfo(Map<String, Object> paraMap) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		Integer isSuccess = rbacMapper.insertRbacInfo(paraMap);
		if(isSuccess==1) {
			String sourceIds = paraMap.get("sourceIds").toString();
			Integer id =Integer.valueOf(paraMap.get("id").toString());
			if(sourceIds!=null&&sourceIds.indexOf(",")>-1) {
				String[] sourceList = sourceIds.split(",");
				if(sourceList.length>0) {
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					for(String sourceId:sourceList) {
						Map<String,Object> map = new HashMap<String, Object>();
						map.put("roleId", id);
						map.put("sourceId", sourceId);
						list.add(map);
					}
					
					Integer _isSuccess = rbacMapper.batchInsertRbacSourceMatch(list);
					if(_isSuccess>0) {
						resMap.put("resCode", 200);
						resMap.put("resMsg", "success");
					}else {
						resMap.put("resCode", 202);
						resMap.put("resMsg", "更新权限失败");
					}
				}else {
					resMap.put("resCode", 200);
					resMap.put("resMsg", "success");
				}
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
			}
			
		}else {
			resMap.put("resCode", 201);
			resMap.put("resMsg", "更新失败");
			LOGGER(logger, "插入资源信息", "返回结果："+isSuccess);
		}
		
		return resMap;
	}

	/**
	 * 获取角色选择列表信息
	 */
	@Override
	public List<Map<String, Object>> getRoleSelectList(Map<String, Object> paraMap) {
		return rbacMapper.getRoleSelectList(paraMap);
	}

	/**
	 * 获取角色信息
	 */
	@Override
	public Map<String, Object> getRoleInfoByKey(Integer id) {
		return rbacMapper.getRoleInfoByKey(id);
	}

	/**
	 * 更新权限信息
	 */
	@Override
	public Map<String, Object> updateRbacInfo(Map<String, Object> paraMap) {
		Map<String,Object> resMap = new HashMap<String, Object>();
		
		Integer isSuccess = rbacMapper.updateRbacInfo(paraMap);
		if(isSuccess==1) {
			
			Integer delSuccess = rbacMapper.deleteRbacSourceMatch(paraMap);
			
			LOGGER(logger, "删除角色资源关联", "返回结果信息"+delSuccess);
			
			String sourceIds = paraMap.get("sourceIds").toString();
			Integer id =Integer.valueOf(paraMap.get("roleId").toString());
			if(sourceIds!=null&&sourceIds.indexOf(",")>-1) {
				String[] sourceList = sourceIds.split(",");
				if(sourceList.length>0) {
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					for(String sourceId:sourceList) {
						Map<String,Object> map = new HashMap<String, Object>();
						map.put("roleId", id);
						map.put("sourceId", sourceId);
						list.add(map);
					}
					
					Integer _isSuccess = rbacMapper.batchInsertRbacSourceMatch(list);
					if(_isSuccess>0) {
						resMap.put("resCode", 200);
						resMap.put("resMsg", "success");
					}else {
						resMap.put("resCode", 202);
						resMap.put("resMsg", "更新权限失败");
					}
				}else {
					resMap.put("resCode", 200);
					resMap.put("resMsg", "success");
				}
			}else {
				resMap.put("resCode", 200);
				resMap.put("resMsg", "success");
			}
			
		}else {
			resMap.put("resCode", 201);
			resMap.put("resMsg", "更新失败");
			LOGGER(logger, "插入资源信息", "返回结果："+isSuccess);
		}
		
		return resMap;
	}

}
