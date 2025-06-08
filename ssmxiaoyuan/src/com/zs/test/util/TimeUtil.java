package com.zs.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Description:时间操作的工具类
 * 
 * 
 */
public class TimeUtil 
{
	/**
	 * 时间转换成（HH:mm）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateHM(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（yyyy-MM-dd HH:mm）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateYMDHM(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（HH）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static Integer dateFormateHour(Date date)
	{
		if(date==null)return null;
		SimpleDateFormat sdf=new SimpleDateFormat("HH");
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 时间转换成（mm）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static Integer dateFormateMin(Date date)
	{
		if(date==null)return null;
		SimpleDateFormat sdf=new SimpleDateFormat("mm");
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 时间转换成（yyyy-MM-dd）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateYMD(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（MM-dd）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateMD(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（yyyyMM）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateYM(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（yyyy-MM-dd HH:mm:ss）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String dateFormateALL(Date date)
	{
		if(date==null)return "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 时间转换成（yyyy年MM月dd日-HH：mm）格式
	 * 
	 * 
	 * @param date Date类型的时间
	 * @return 时间string
	 */
	public static String formateExamDate(Date date,Date start,Date end){
		if(null == date || null == start || null == end){
			return "";
		}
		SimpleDateFormat dfDate = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat dfHM = new SimpleDateFormat("HH：mm");
		StringBuilder result = new StringBuilder();
	    result.append(dfDate.format(date));
	    result.append(dfHM.format(start));
	    result.append("-");
	    result.append(dfHM.format(end));
		
		return result.toString();
	}
	
	/**
	 * 根据字符串1111111获取中文星期，其中1表示含有对应的星期数，0表示没有对应的星期
	 * 
	 * 
	 * @param week 星期字符串
	 * @return 中文星期string
	 */
	public static String weekOfDay(String week)
	{
		System.out.println(week);
		String back="";
		if(week==null)return null;
		if(week.equals("1111111"))return "每天";
		char[] temp=week.toCharArray();
		if(temp[0]=='1')back=back+"星期一  ";
		if(temp[1]=='1')back=back+"星期二  ";
		if(temp[2]=='1')back=back+"星期三  ";
		if(temp[3]=='1')back=back+"星期四  ";
		if(temp[4]=='1')back=back+"星期五  ";
		if(temp[5]=='1')back=back+"星期六  ";
		if(temp[6]=='1')back=back+"星期日  ";
		System.out.println(back);
		return back;
	}
	
	
	/**
	 * 根据数字获取中文星期
	 * 
	 * 
	 * @param week 数字星期数
	 * @return 中文星期string
	 */
	public static String weekOfDay(Integer week)
	{
		if(week==null)return null;
		String back="";
		if(week==1)back=back+"星期一  ";
		if(week==2)back=back+"星期二  ";
		if(week==3)back=back+"星期三  ";
		if(week==4)back=back+"星期四  ";
		if(week==5)back=back+"星期五  ";
		if(week==6)back=back+"星期六  ";
		if(week==7)back=back+"星期日  ";
		return back;
	}
	
	
	/**
	 * 获取两个时间的时间间隔，返回相差几小时几分
	 * 
	 * 
	 * @param t1  时间一
	 * @param t2  时间二
	 * @return 返回相差几小时几分
	 */
	
	public static String lengthTime(Date t1,Date t2)
	{
		int l1=t1.getHours()*60+t1.getMinutes();
		int l2=t2.getHours()*60+t2.getMinutes();
		int l3=l2-l1;
		return (l3/60)+"小时"+(l3%60==0?(""):((l3%60)+"分"));
	}
}
