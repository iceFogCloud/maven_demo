package org.simpro.controller;


import org.apache.log4j.Logger;
import org.simpro.utils.DateUtil;
 
 
public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());
 
	private static final long serialVersionUID = 6357869213649815390L;
	
 
	
	/**
	 * 得到分页列表的信息 
	 */
	
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
	
	public static void LOGGER(Logger logger,String methodName, String errorMsg) {
		logger.error("方法名："+methodName+",错误信息："+errorMsg+",当前时间："+DateUtil.getTime());
	}
	
}