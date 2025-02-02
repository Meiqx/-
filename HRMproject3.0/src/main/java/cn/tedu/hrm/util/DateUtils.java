package cn.tedu.hrm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 将字符串转成Date类型
	 * @param date 一个时间字符串  规定格式：yyyy-MM-dd
	 * @return	返回一个Date类型
	 * @throws ParseException 
	 */
	public static Date getDate(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(d);
	}
	
	
	/**
	 * 将日期Date对象转换成指定格式的日期字符串
	 * @author 李玉林
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 
	 * 将给定的Date类型转换成 字符串 
	 * 返回格式：yyyy-MM-dd
	 * @return
	 */
	public static String getStringDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	
	/**
	 * 创建当前时间
	 * @return
	 */
	public static Date getCreationTime() {
		return new Date();
	}
	
	/**
	 * 这个方法定义是为了方便util.date类型转为sql.date存入数据库用的
	 * @param date
	 * @return
	 */
	public static java.sql.Date changeDate(Date date){
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * 这个方法是将数据库中的sql型Date转成util包的Date
	 * @param sqldate
	 * @return
	 */
	public static Date changeToUtilDate(java.sql.Date sqldate) {
		Date date = new Date(sqldate.getTime());
		return date;
	}
	
}
