package org.simpro.utils;

public class StringUtils {

	/**
	 * 判断obj是否为空
	 * yan_zhx 
	 * 2019年6月11日 下午2:13:42 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param obj
	 * @return    设定文件   
	 * boolean    返回类型
	 */
	public static boolean isEmpty(Object obj) {
		boolean isTrue = false;
		if(obj==null||"".equals(obj)||"".equals(obj.toString().replaceAll(" ", ""))) {
			return true;
		}else {
			return isTrue;
		}
	}
	
}
