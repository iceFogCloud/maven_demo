package org.simpro.service.Impl;

import java.util.List;
import java.util.Map;

import org.simpro.controller.BaseController;
import org.simpro.dao.UserMapper;
import org.simpro.service.UserService;
import org.simpro.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")  
public class UserServiceImpl extends BaseController implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	
	/**
	 * 获取用户列表信息
	 */
	@Override
	public List<Map<String, Object>> getUserList(Map<String, Object> paraMap) {
		return userMapper.getUserList(paraMap);
	}


	/**
	 * 获取用户列表数据数目
	 */
	@Override
	public Integer getUserListCount(Map<String, Object> paraMap) {
		return userMapper.getUserListCount(paraMap);
	}


	/**
	 * 插入用户信息
	 */
	@Override
	public Integer insertUserInfo(Map<String, Object> paraMap) {
		
		Integer userCount = userMapper.getUserCount(paraMap);
		if(userCount>=1) {
			return -1;
		}else {
			Integer isSuccess = userMapper.insertUserInfo(paraMap);
			if(isSuccess==1) {
				Integer userId = Integer.valueOf(paraMap.get("id").toString());
				paraMap.put("userId", userId);
				paraMap.put("create_time", DateUtil.getTime());
				Integer _isSuccess = userMapper.inserUserRoleMatch(paraMap);
				if(_isSuccess==1) {
					return 1;
				}else {
					return 0;
				}
			}else {
				return 0;
			}
		}
		
	}


	/**
	 * 通过Id删除用户信息
	 */
	@Override
	public Integer deleteUserInfoById(Map<String, Object> paraMap) {
		return userMapper.deleteUserInfoById(paraMap);
	}


	/**
	 *	 获取用户信息
	 */
	@Override
	public Map<String, Object> getUserInfo(String id) {
		return userMapper.getUserInfo(Integer.valueOf(id));
	}


	/**
	 * 更新用户信息
	 */
	@Override
	public Integer updateUserInfo(Map<String, Object> paraMap) {
		Integer isSuccess = userMapper.updateUserInfo(paraMap);
		if(isSuccess==1) {
			
			Integer delSuccess = userMapper.deleteUserRoleMatch(paraMap);
			
			LOGGER(logger, "删除用户角色关联信息", "删除关联结果："+delSuccess);
			
			Integer userId = Integer.valueOf(paraMap.get("userId").toString());
			paraMap.put("userId", userId);
			paraMap.put("create_time", DateUtil.getTime());
			Integer _isSuccess = userMapper.inserUserRoleMatch(paraMap);
			if(_isSuccess==1) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}

	
}
