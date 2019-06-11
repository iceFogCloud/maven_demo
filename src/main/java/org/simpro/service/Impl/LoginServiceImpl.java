package org.simpro.service.Impl;

import java.util.Map;

import org.simpro.dao.LoginDao;
import org.simpro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")  
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	public LoginDao loginDao;
	
	/**
	 * 获取登陆信息
	 */
	@Override
	public Map<String, Object> getLoginInfo(Map<String, Object> paraMap) {
		return loginDao.getLoginInfo(paraMap);
	}

}
