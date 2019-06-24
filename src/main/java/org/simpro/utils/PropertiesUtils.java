package org.simpro.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class PropertiesUtils {
	
	 public static String getPara(String param){
		 Properties properties = new Properties();
		 InputStream in = PropertiesUtils.class.getResourceAsStream("../configInfo.properties");//或者直接写成"db.properties"
         try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
         String value = properties.getProperty(param);
         return value;
	 }
	 
	 public static String[] getFnsParam(){
		 Properties properties = new Properties();
		 InputStream in = PropertiesUtils.class.getResourceAsStream("./configInfo.properties");//或者直接写成"db.properties"
         try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
        String fnsurlparam = properties.getProperty("fnsurlparam").trim();
        String [] fnsParamArray = fnsurlparam.split("\\|\\|");
        String port = "";
        String ipaddress="";
        int loopcnt = 0;
        while(true){
            Random ra = new Random();
     		int tmpcnt = ra.nextInt(fnsParamArray.length);
            String[] fnsParam = fnsParamArray[tmpcnt].trim().split(":");
            String [] testArray = fnsParam[0].split("\\.");
            int numberCount = 0;
            for(String numberString : testArray){
            	if(numberString.matches("[0-9]+")){
            		if(Integer.parseInt(numberString)>=0&&Integer.parseInt(numberString)<=255){
            			numberCount ++;
            		}
            	}
            }
            if(numberCount==4){
            	if(fnsParam[1].matches("[0-9]+")){
            		if(Integer.parseInt(fnsParam[1])>=1024&&Integer.parseInt(fnsParam[1])<=65535){
                		ipaddress = fnsParam[0];
                		port = fnsParam[1];
                		break;
            		}
            	}
            }
			loopcnt ++;
			if(loopcnt>50){
				return null;
			} 
        }
        String[] finalFnsParam = {ipaddress,port};
        return finalFnsParam;
	 }
	 public static void main(String[] args) {
	       /* Properties properties = new Properties();
	        try {
	            InputStream in = PropertiesUtils.class.getResourceAsStream("./configInfo.properties");//或者直接写成"db.properties"
	            properties.load(in);
	            String url = properties.getProperty("bossurl");
	            
	            System.out.println("url="+url );
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }*/
		 
		 	System.out.println(getPara("appid"));
	    }
}
