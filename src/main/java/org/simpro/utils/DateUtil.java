package org.simpro.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;


public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat sdfTimeOnly = new SimpleDateFormat(
			"HHmmss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}
	
	public static String getTimeFor(Date date) {
		return sdfTime.format(date);
	}
	
	/**
	 * 获取YYYY-MM-DD 格式时间字符串
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		return format.format(date);
	}
	
	/**
	 * 获取YYYY年MM月DD日 格式时间字符串
	 * @return
	 */
	public static String getDateChiness() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("YYYY年MM月dd日");
		return format.format(date);
	}
	/**
	 * 获取HHmmss格式
	 * 
	 * @return
	 */
	public static String getTimeOnly() {
		return sdfTimeOnly.format(new Date());
	}
	
	/**
	* @Title: compareDate
	* @Description: (日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}
	
	/**
	 * @Title: compareDate
	 * @Description: (日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean  
	 * @throws
	 * @author luguosui
	 */
	public static boolean compareTime(String s, String e) {
		if(fomatDateStr(s)==null||fomatDateStr(e)==null){
			return false;
		}
		return fomatDateStr(s).getTime() >=fomatDateStr(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-mm-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDateStr(String date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    
    /**
     * 得到n天之后的时间
     * @param days
     * @return
     */
    public static String getAfterDayTime(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }
    
    
    /**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

    /**
     *  获取时间随机串
     * @param args
     */
    public static String getRanDates(){
//    	Random random = new Random();
//    	String[] str = new String[size];
//    	String str = "";
//    	for(int i = 0;i<size;i++){
//    		str[i] = getDays()+(random.nextInt(90000000)+10000000);
//    		str = getDays()+(random.nextInt(90000000)+10000000);
//    	}
//    	return str;
    	Random ra =new Random();
    	String str = "1";
    	for (int i=0;i<15;i++){
    		str += ra.nextInt(10);
    	//	System.out.println(ra.nextInt(10)+1);
    	}
    	return str;
    }
    /**
     *  获取11位随机值
     * @param args
     */
    public static String get11RanDates(){
//    	Random random = new Random();
//    	String[] str = new String[size];
//    	String str = "";
//    	for(int i = 0;i<size;i++){
//    		str[i] = getDays()+(random.nextInt(90000000)+10000000);
//    		str = getDays()+(random.nextInt(90000000)+10000000);
//    	}
//    	return str;
    	Random ra =new Random();
    	String str = "1";
    	for (int i=0;i<10;i++){
    		str += ra.nextInt(10);
    	//	System.out.println(ra.nextInt(10)+1);
    	}
    	return str;
    }
    public static String getRanDate(){
    	Random random = new Random();
    	return getDays()+(random.nextInt(90000000)+10000000);
    }
    
    /**
     * 计算时间
     */
    public static Date calDate(Integer addend){
    	long curren = System.currentTimeMillis();
    	curren += addend * 60 * 1000;
    	Date date = new Date(curren);
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return date;
    }
    /**
     * 计算时间 天
     */
	public static Date calDateDay(Integer addendDays, Date beginDate) {
		long curren = beginDate.getTime();
    	curren += addendDays * 60 * 60 * 24 * 1000;
    	Date date = new Date(curren);
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return date;
	}
    /**
     *  获取时间时间差 分钟
     * @param args
     */
    public static long dataMinus(String dateStart, String dateStop ){
  	  // String dateStart = "2013-02-19 09:29:58";
         //String dateStop = "2013-02-20 11:31:48";

         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         Date d1 = null;
         Date d2 = null;
         long diffMinute=0L;
         try {
             d1 = format.parse(dateStart);
             d2 = format.parse(dateStop);
             //毫秒ms
             long diff = d2.getTime() - d1.getTime();
             diffMinute =  diff/1000/60;
             long diffSeconds = diff / 1000 % 60;
             long diffMinutes = diff / (60 * 1000) % 60;
             long diffHours = diff / (60 * 60 * 1000) % 24;
             long diffDays = diff / (24 * 60 * 60 * 1000);
             System.out.print(diffMinute+ " 分钟 ");

         } catch (Exception e) {
             e.printStackTrace();
         }
         return diffMinute;
  	    
     }
    public static void main(String[] args) throws Exception {
//    	String a = "abcds23";
//    	String b = getBase64(a);
//    	String c = getFromBase64(b);
//    	String aa = DateUtil.getBase64(DateUtil.getBase64("10001023" + "bayss" +"wechat"));
////    	System.out.println(b + "," + c);
//    	System.out.println("a:" +aa);
//    	String bb = getFromBase64(getFromBase64(aa));
//    	bb = bb.substring(0, bb.indexOf("bayss"));
//    	System.out.println("b:" + bb);
    	/*String str = getRanDates();
    	System.out.println(str);*/
    	
    	/*boolean res = DateUtil.compareDate("2017-08-05 09:11:33","2017-07-31 09:30:04");
    	System.out.println(res);*/
    	
    }

    public static String SendGET(String url,String param){
    	   String result="";//访问返回结果
    	   BufferedReader read=null;//读取访问结果
    	    
    	   try {
    	    //创建url
    	    URL realurl=new URL(url+"?"+param);
    	    //打开连接
    	    URLConnection connection=realurl.openConnection();
    	     // 设置通用的请求属性
    	             connection.setRequestProperty("accept", "*/*");
    	             connection.setRequestProperty("connection", "Keep-Alive");
    	             connection.setRequestProperty("user-agent",
    	                     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    	             //建立连接
    	             connection.connect();
    	          // 获取所有响应头字段
    	             Map<String, List<String>> map = connection.getHeaderFields();
    	             // 遍历所有的响应头字段，获取到cookies等
    	             for (String key : map.keySet()) {
    	                 System.out.println(key + "--->" + map.get(key));
    	             }
    	             // 定义 BufferedReader输入流来读取URL的响应
    	             read = new BufferedReader(new InputStreamReader(
    	                     connection.getInputStream(),"UTF-8"));
    	             String line;//循环读取
    	             while ((line = read.readLine()) != null) {
    	                 result += line;
    	             }
    	   } catch (IOException e) {
    	    e.printStackTrace();
    	   }finally{
    	    if(read!=null){//关闭流
    	     try {
    	      read.close();
    	     } catch (IOException e) {
    	      e.printStackTrace();
    	     }
    	    }
    	   }
    	     
    	   return result; 
    	 }
    
    /**
     * 获取时间戳
     * @return
     */
    public static String getTimeStamp(){
        return String.valueOf(System.currentTimeMillis()/1000);
    }
    
    /**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * 判断是否是2019-10-10 10:00:00格式
	 * @Author zhxin_yan
	 * @date 2019年4月26日
	 * @param datetime
	 * @return
	 */
	public static boolean isDateTime(String datetime){
		  Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		  boolean isTrue = false;
		  if(datetime!=null&&!"".equals(datetime)){
			  isTrue = datetime.length()>12&&p.matcher(datetime).matches();
		  }
		  return isTrue;
	}
	
	/**
	 * 判断是否是判断是否是2019-10-10 格式
	 * @Author zhxin_yan
	 * @date 2019年4月26日
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date){
		  Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");
		  return p.matcher(date).matches();
	}
	
	/**
	 * 判断是否是10:00:00格式
	 * @Author zhxin_yan
	 * @date 2019年4月26日
	 * @param time
	 * @return
	 */
	public static boolean isTime(String time){
		  Pattern p = Pattern.compile("((((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		  return p.matcher(time).matches();
	}
	
	/**
	 * 获取完整的时间格式
	 * @Author zhxin_yan
	 * @date 2019年4月26日
	 * @return
	 */
	public static String getCompleteDateTime(String dateString){
		String resDate = "";
		if(isDateTime(dateString)){
			resDate = dateString;
		}else{
			if(isDate(dateString)){
				resDate = dateString +"00:00:00";
			}else{
				if(isTime(dateString)){
					resDate = getDate()+ " " + dateString;
				}else{
					resDate = getTime();
				}
			}
		}
		
		
		return resDate;
	}
}
