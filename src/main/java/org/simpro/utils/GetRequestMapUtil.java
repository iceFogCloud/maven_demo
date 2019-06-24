package org.simpro.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class GetRequestMapUtil {
	
	/**
	 * 根据request获取请求中的Map信息
	 * @Author zhxin_yan
	 * @date 2019年4月22日
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,Object> getMapFromRequest(HttpServletRequest request){
    	Map<String,Object> paraMap = new HashMap<String, Object>();
    	Map<String, String[]> map = request.getParameterMap();
		// 遍历
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();
			String _value = "";
			for (int i = 0; i < value.length; i++) {
				if(value[i]!=null&&!"".equals(value[i])){
					_value+=value[i] + "#";
				}
			}
			if(_value!=null&&!"".equals(_value)){
				if(_value.endsWith("#")){
					_value = _value.substring(0, _value.length()-1);
				}
				if("undefined".equals(_value)){
					_value=null;
				}
			}else{
				_value=null;
			}
			paraMap.put(strKey.toString(), _value);
		}
    	return paraMap;
	}
	
	/**
	 * 转换为String 
	 * @Author zhxin_yan
	 * @date 2018年7月30日
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj){
		String res = "";
		if(obj==null||"undefined".equals(obj)||"".equals(obj)){
			res = null;
		}else{
			res = obj.toString();
		}
		return res;
	}
}
