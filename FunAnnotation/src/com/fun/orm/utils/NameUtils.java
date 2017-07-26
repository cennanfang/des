package com.fun.orm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtils {

	 /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line, boolean lowerCase){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        if(lowerCase) {
        	return sb.toString().toLowerCase();
        }
        return sb.toString();
    }
    
    
    /**
	 * 功能：将输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String initcapUpCase(String str) {

		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}

		return new String(ch);
	}
	
	/**
	 * 功能：将输入字符串的首字母改成小写
	 * 
	 * @param str
	 * @return
	 */
	public static String initcapLowerCase(String str) {
		
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		
		return new String(ch);
	}
	
	/**
	 * 获取短类名
	 * @param packageClassName
	 * @return
	 */
	public static String getShortClassName(String packageClassName) {
		return packageClassName.substring((packageClassName.lastIndexOf(".") + 1));
	}
	
	/**
	 * 获取首字母为小写的类名
	 * @param className
	 * @return
	 */
	public static String getLowerCaseClassName(String className) {
		return NameUtils.initcapLowerCase(className);
	}
	
}
