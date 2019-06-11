package org.simpro.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	//初始化省市的英文和中文
	private static String[][] arr = { { "安徽", "Anhui" }, { "澳门", "Aomen" }, { "北京", "Beijing" }, { "重庆", "Chongqing" },
			 { "福建", "Fujian" }, { "甘肃", "Gansu" }, { "广东", "Guangdong" },{ "广西", "Guangxi" },{ "贵州", "Guizhou" },
			 { "海南", "Hainan" }, { "河北", "Hebei" }, { "河南", "Henan" }, { "黑龙江", "Heilongjiang" }, { "湖北", "Hubei" },
			 { "湖南", "Hunan" }, { "吉林", "Jilin" }, { "江苏", "Jiangsu" }, { "江西", "Jiangxi" }, { "辽宁", "Liaoning" }, { "浙江", "Zhejiang" },
			 { "内蒙古", "Inner Mongolia" }, { "宁夏", "Ningxia" }, { "青海", "Qinghai" }, { "山东", "Shandong" }, { "山西", "Shanxi" },
			 { "陕西", "Shaanxi" }, { "上海", "Shanghai" }, { "四川", "Sichuan" }, { "台湾", "Taiwan" }, { "天津", "Tianjin" },
			 { "美国加州", "California" }, { "堪培拉", "Canberra" }, { "科尔多瓦", "Cordoba" }, { "英格兰", "England" }, { "茨城", "Ibaraki" },
			 { "马里兰", "Maryland" }, { "麻萨诸塞州", "Massachusetts" }, { "墨西哥市", "Mexico City" }, { "纽约", "New York" }, { "尼斯", "Nice" },
			 { "巴黎", "Paris" }, { "罗马", "Roma" }, { "苏格兰", "Scotland" }, { "首尔", "Seoul" }, { "萨克福马", "Suffolk" },
			 { "多伦多", "Toronto" }, { "乌斯怀亚", "Ushuaia" }, { "维多利亚", "Victoria" }, { "华盛顿", "Washington" }, { "韦斯特米思", "Westmeath" }};
	
	
	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	
	/**
	 * 字符串数组去重
	 */
	public static String[] array_unique(String[] ss) {
	    // array_unique
	    List<String> list =new ArrayList<String>();
			for(String s:ss){
				if(!list.contains(s))			//或者list.indexOf(s)!=-1
					list.add(s);
			}
			return list.toArray(new String[list.size()]);
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
	
	
	//微信中城市拼音转中文 如果没有找到中文则仍然显示英文
	public static String getChinessProvinceName(String cityName) {
		String _cityName= null;
		if(cityName==null||"".equals(cityName)){
			return _cityName;
		}else{
			return findProvince(cityName);
		}
    }
	
	
	/**
	 * 找到城市中文名
	 * @Author zhxin_yan
	 * @date 2019年3月29日
	 * @param cityName
	 * @return
	 */
	public static String findProvince(String cityName){
        String _cityName = cityName;
        String words = "";
        String py = "";
        boolean find = true;
        for (int i = 0; i < arr.length && find; i++) {
        	words = arr[i][0];
            py = arr[i][1];
            if(py.equals(cityName)){
            	find = false;
            	_cityName = words;
            	System.out.println("找到了中文是："+words+";拼音是"+py+";城市名是："+cityName);
            }else{
            }
        }
    	return _cityName;
    }
	
	/**
	 * 判断str 中是否包含value
	 * @Author zhxin_yan
	 * @date 2019年4月26日
	 * @param str
	 * @param value
	 * @return
	 */
	public static boolean isStringArrayContain(String str,String value){
		boolean isTrue = false;
		if(str==null||"".equals(str)){
			return false;
		}else{
			String[] strA = str.split(",");
			if(strA.length==0){
				if(value.equals(strA[0])){
					isTrue = true;
				}else{
					isTrue = false;
				}
			}else{
				isTrue = Arrays.asList(strA).contains(value);
			}
		}
		return isTrue;
	}
	
	public static String imgBase64(String imgURL) {
		ByteArrayOutputStream outPut = new ByteArrayOutputStream();
	                byte[] data = new byte[1024];
	        try {  
	            // 创建URL  
	            URL url = new URL(imgURL);  
	            // 创建链接  
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
	            conn.setRequestMethod("GET");  
	            conn.setConnectTimeout(10 * 1000);  

	            if(conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            return "fail";//连接失败/链接失效/图片不存在
	            }
	            InputStream inStream = conn.getInputStream();  
	            int len = -1;
	            while ((len = inStream.read(data)) != -1) {
	            outPut.write(data, 0, len);
	            }
	            inStream.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        // 对字节数组Base64编码  
	        BASE64Encoder encoder = new BASE64Encoder(); 
	        return encoder.encode(outPut.toByteArray()); 
	}
    public static void main(String[] args) {
        String strImg = imgBase64("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epJenvR20SStL8Rvk7AJQiah6HnicaqdRqndp7wcmsPe6RIBV0z1eTkW5JIYiajKziaNFaibK2bpOavJVA/132");
        System.out.println(strImg);
    }
    
    
    /**
     * int转16进制方法，不足五位前端补零
     * @param intVal
     * @return
     */
    public static String intToHex(Integer intVal){
		StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(intVal != 0){
            sb = sb.append(b[intVal%16]);
            intVal = intVal/16;            
        }
        a = sb.reverse().toString();
        return addZeroForNum(a,5);
	}
    /**
     * str 字符串不足五位前端补零方法
     * @param str
     * @param strLength
     * @return
     */
	public static String addZeroForNum(String str,int strLength) {  
		int strLen =str.length();  
		if (strLen <strLength) {  
			while (strLen< strLength) {  
				StringBuffer sb = new StringBuffer();  
				sb.append("0").append(str);//左补0  
				str= sb.toString();  
				strLen= str.length();  
			}  
		}  
	  return str;  
	}
	

	/**
	 * json转换为Map
	 * yan_zhx 
	 * 2019年6月4日 下午3:12:01 
	 * TODO(这里用一句话描述这个方法的作用)   
	 * @param jsonStr
	 * @return    设定文件   
	 * Map<String,Object>    返回类型
	 */
	public static Map<String, Object> parseJSON2Map(String jsonStr){    
            Map<String, Object> map = new HashMap<String, Object>();    
            JSONObject json = JSONObject.fromObject(jsonStr);    
            for(Object k : json.keySet()){    
                Object v = json.get(k);     
                if(v instanceof JSONArray){    
                    List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();    
                    Iterator<JSONObject> it = ((JSONArray)v).iterator();    
                    while(it.hasNext()){    
                        JSONObject json2 = it.next();    
                        list.add(parseJSON2Map(json2.toString()));    
                    }    
                    map.put(k.toString(), list);    
                } else {    
                    map.put(k.toString(), v);    
                }    
            }    
            return map;    
        } 
}
