package com.code2017.timerDemo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

	private String mTime = "1,010000"; // 开始任务的设置时间(每月的1号1点执行)

	public static void main(String[] args) {
		GregorianCalendarDemo gc = new GregorianCalendarDemo();
		Date data = gc.getSpecialDate("last,221711");
		System.out.println(data.getDate());
		System.out.println(data.getDay());
		System.out.println(data.getHours());
		System.out.println(data.getTime());
	}

	private Date getSpecialDate(String strTime) {
		if (strTime.split(",").length != 2) {
			strTime = mTime;
		}
		String hour = strTime.split(",")[1].substring(0, 2);
		String miue = strTime.split(",")[1].substring(2, 4);
		String send = strTime.split(",")[1].substring(4, 6);

		GregorianCalendar gca = new GregorianCalendar();
		gca.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		gca.set(Calendar.MINUTE, Integer.parseInt(miue));
		gca.set(Calendar.SECOND, Integer.parseInt(send));
		// 如果时间已过下月启动
		String daynum = strTime.split(",")[0];// 前台传过来的天参数
		if ("last".equalsIgnoreCase(daynum)) {
			GregorianCalendar temgca = new GregorianCalendar();
			//int day1 = temgca.get(Calendar.DAY_OF_MONTH);
			temgca.add(Calendar.MONTH, 1);
			//int day2 = temgca.get(Calendar.DAY_OF_MONTH);
			temgca.set(Calendar.DAY_OF_MONTH, 1);
			//int day3 = temgca.get(Calendar.DAY_OF_MONTH);
			temgca.add(Calendar.DAY_OF_MONTH, -1);
			int day4 = temgca.get(Calendar.DAY_OF_MONTH);
			daynum = String.valueOf(temgca.get(Calendar.DAY_OF_MONTH));// 获取当月最后一天是几号
		}
		int day5 = gca.get(Calendar.DATE);
		if (gca.get(Calendar.DATE) >= Integer.parseInt(daynum)) {
			if (strTime.split(",")[1].compareTo(getCurrentTime()) <= 0) {
				gca.add(Calendar.MONTH, 1);
			}
		}
		//算出时间
		if ("last".equalsIgnoreCase(strTime.split(",")[0])) {
			// 获取月的最后一天
			GregorianCalendar temgca = new GregorianCalendar();
			if (gca.get(Calendar.DATE) >= Integer.parseInt(daynum)
					&& strTime.split(",")[1].compareTo(getCurrentTime()) <= 0) {
				temgca.add(Calendar.MONTH, 2);
			} else {
				temgca.add(Calendar.MONTH, 1);
			}
			temgca.set(Calendar.DAY_OF_MONTH, 1);
			temgca.add(Calendar.DAY_OF_MONTH, -1);
			gca.set(Calendar.DAY_OF_MONTH, temgca.get(Calendar.DAY_OF_MONTH));
		} else {
			gca.set(Calendar.DAY_OF_MONTH,
					Integer.parseInt(strTime.split(",")[0]));
		}
		Date date = gca.getTime();

		return date;
	}

	public static String getCurrentTime() {
		Calendar cal = new GregorianCalendar();
		int hour = cal.get(11);
		int minute = cal.get(12);
		int second = cal.get(13);
		String value = "";
		if (hour < 10)
			value = value + "0" + hour;
		else {
			value = value + hour;
		}
		if (minute < 10)
			value = value + "0" + minute;
		else {
			value = value + minute;
		}
		if (second < 10)
			value = value + "0" + second;
		else {
			value = value + second;
		}
		return value;
	}

	public static void demo1() {

		// create a new calendar
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
				.getInstance();

		// print the current date and time
		System.out.println("" + cal.getTime());

		// add 2 months
		cal.add((GregorianCalendar.MONTH), 2);

		// print the modified date and time
		System.out.println("" + cal.getTime());

		// add 2 years
		cal.add((GregorianCalendar.YEAR), 2);

		// print the modified date and time
		System.out.println("" + cal.getTime());
	}

}
