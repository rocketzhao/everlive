package com.everlive.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


public class DateUtil {

	private static final long MILLISECONDS_A_DAY = 24 * 3600 * 1000;

	private static final long MILLISECONDS_A_HOUR = 3600 * 1000;

	@SuppressWarnings("unused")
	private static final long MILLISECONDS_A_MINUTE = 3600 * 1000;

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	private static Logger logger = Logger.getLogger(DateUtil.class);

	private static final String DEFAULT_DATEFULLTIME_FORMAT = "yyyyMMddHHmmss";

	public static final String DEFAULT_DATEFULLDATE_FORMAT = "yyyyMMdd";

	public static final String DEFAULT_YEAR_FORMAT = "yyyy";
	public static final String DEFAULT_MONTH_FORMAT = "MM";

	/** 验证日期字符串，有效日期范围1900-1-1到2099-12-31. */
	private static final Pattern pattern = Pattern
			.compile("(?:(?:19|20)\\d{2})-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|[12][0-9]|3[01])");

	/**
	 * 当前时间加上days天
	 */
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date addMinutes(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static Date addSeconds(Date date, int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}

	/**
	 * 当前时间加上days月
	 */
	public static Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 获取当前月的最大日期
	 * 
	 * @return
	 */
	public static Date getMaxDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		return cal.getTime();
	}

	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取当前月
	 * 
	 * @return
	 */
	public static int getMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前月的最小日期
	 * 
	 * @return
	 */
	public static Date getMinDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
		return cal.getTime();
	}

	/**
	 * 获取指定月的最小时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMinDateByMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
		return cal.getTime();
	}

	/**
	 * 获取指定月的最大时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMaxDateByMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		return cal.getTime();
	}

	/**
	 * 取得某月的的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfLastMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 1);// 日，设为一号
		// cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
		return cal.getTime();// 获得月末是几号
	}

	/**
	 * 当前时间加上years年
	 */
	public static Date addYears(Date date, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	/**
	 * 获得指定格式的日期时间字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String datetime(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}

	/**
	 * 获得指定格式的日期时间字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String datetime(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	/**
	 * 获得指定格式的日期时间字符串
	 * 
	 * @param 日期字符串
	 * @param format
	 * @return
	 */
	public static String datetime(String date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	/**
	 * 获得指定格式的当前日期字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date(Date date, String format) {
		if (date == null) {
			return "";
		}

		return (new SimpleDateFormat(format)).format(date);
	}

	/**
	 * 获得指定格式的当前日期字符串
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String date(String dateStr, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(dateStr);
	}

	/**
	 * 获得"yyyy-MM-dd"格式的当前日期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateStr() {
		return getNowDatetimeStr(DEFAULT_DATE_FORMAT);
	}

	/**
	 * 获得"yyyy-MM-dd HH:mm:ss"格式的当前日期时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDatetimeStr() {
		return getNowDatetimeStr(DEFAULT_DATETIME_FORMAT);
	}

	/**
	 * 获得"yyyyMMddHHmmss"格式的当前日期时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getNowDateminStr() {
		return getNowDatetimeStr(DEFAULT_DATEFULLTIME_FORMAT);
	}

	/**
	 * 获得当前日期时间字符串
	 * 
	 * @param format
	 *            日期格式
	 * @return 日期时间字符串
	 */
	public static String getNowDatetimeStr(String format) {
		Calendar cal = Calendar.getInstance();
		return datetime(cal.getTime(), format);
	}

	/**
	 * 只取当前时间的日期部分，小时、分、秒等字段归零
	 */
	public static Date dateOnly(Date date) {
		return new Date(date.getTime() / MILLISECONDS_A_DAY);
	}

	/**
	 * 只取当前时间的日期部分，小时、分、秒等字段归零
	 */
	public static Date dateOnlyExt(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 只取当前时间的日期部分，小时、分、秒等字段归零
	 */
	public static Date dateMinTime(Date date) {
		return dateOnlyExt(date);
	}

	/**
	 * 把类似2007-2-2 7:1:8的时间串变为标准的2007-02-02 07:01:08
	 * 
	 * @param dateTimeStr
	 *            未校正日期值
	 * @return 日期对象
	 */
	public static String getStandDateTimeStr(String dateTimeStr) {
		if (dateTimeStr == null || "".equals(dateTimeStr)) {
			return "";
		}

		dateTimeStr = dateTimeStr.replaceAll("\\s+", "|");
		String[] a = dateTimeStr.split("\\|");
		List<String> list = Arrays.asList(a);
		String datetime = "";
		int count = 1;
		for (int i = 0; i < list.size(); i++) {
			String temp = (String) list.get(i);
			StringTokenizer st;
			if (i == 0)
				st = new StringTokenizer(temp, "-");
			else
				st = new StringTokenizer(temp, ":");
			int k = st.countTokens();
			for (int j = 0; j < k; j++) {
				String sttemp = (String) st.nextElement();
				if (count == 1) {
					datetime = sttemp;
				} else {
					if ((sttemp.equals("0")) || (sttemp.equals("00")))
						sttemp = "0";
					else if ((Integer.valueOf(sttemp).intValue()) < 10)
						sttemp = sttemp.replaceAll("0", "");
					if (count < 4) {
						if ((Integer.valueOf(sttemp).intValue()) < 10)
							datetime = datetime + "-0" + sttemp;
						else
							datetime = datetime + "-" + sttemp;
					}
					if (count == 4) {
						if ((Integer.valueOf(sttemp).intValue()) < 10)
							datetime = datetime + " 0" + sttemp;
						else
							datetime = datetime + " " + sttemp;
					}
					if (count > 4) {
						if ((Integer.valueOf(sttemp).intValue()) < 10)
							datetime = datetime + ":0" + sttemp;
						else
							datetime = datetime + ":" + sttemp;
					}
				}
				count++;
			}
		}

		try {
			@SuppressWarnings("unused")
			Date test = getDateFromStr(datetime); // 测试能否格式化成时间
			return datetime;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 把标准的2007-02-02 07:01:08格式转换成日期对象
	 * 
	 * @param datetime
	 *            日期,标准的2007-02-02 07:01:08格式
	 * @return 日期对象
	 */
	@SuppressWarnings("deprecation")
	public static Date getDateFromStr(String datetime) {
		if (datetime == null || "".equals(datetime)) {
			return new Date();
		}

		String nyr = datetime.trim();

		if (nyr.indexOf(" ") > 0) {
			nyr = nyr.substring(0, nyr.indexOf(" "));
		} else {
			nyr = nyr.substring(0, nyr.length());
		}

		StringTokenizer st = new StringTokenizer(nyr, "-");
		Date date = new Date();
		String temp = "";
		int count = st.countTokens();
		for (int i = 0; i < count; i++) {
			temp = (String) st.nextElement();
			// if(!(temp.equals("0")))
			// temp.replaceAll("0", "");
			if (i == 0)
				date.setYear(Integer.parseInt(temp) - 1900);
			if (i == 1)
				date.setMonth(Integer.parseInt(temp) - 1);
			if (i == 2)
				date.setDate(Integer.parseInt(temp));
		}

		if (datetime.length() > 10) {
			String sfm = datetime.substring(11, 19);
			StringTokenizer st2 = new StringTokenizer(sfm, ":");
			count = st2.countTokens();
			for (int i = 0; i < count; i++) {
				temp = (String) st2.nextElement();
				// if(!(temp.equals("0")))
				// temp.replaceAll("0", "");
				if (i == 0)
					date.setHours(Integer.parseInt(temp));
				if (i == 1)
					date.setMinutes(Integer.parseInt(temp));
				if (i == 2)
					date.setSeconds(Integer.parseInt(temp));
			}
		}
		return date;
	}

	/**
	 * 返回两个日期相差天数
	 * 
	 * @param startDate
	 *            起始日期对象
	 * @param endDate
	 *            截止日期对象
	 * @return
	 */
	public static int getQuot(Date startDate, Date endDate) {
		long quot = 0;
		quot = endDate.getTime() - startDate.getTime();
		quot = quot / MILLISECONDS_A_DAY;
		return (int) quot;
	}

	/**
	 * 返回两个日期相差天数
	 * 
	 * @param startDateStr
	 *            起始日期字符串
	 * @param endDateStr
	 *            截止期字符串
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static int getQuot(String startDateStr, String endDateStr,
			String format) {
		long quot = 0;
		format = (format != null && format.length() > 0) ? format
				: DEFAULT_DATE_FORMAT;
		SimpleDateFormat ft = new SimpleDateFormat(format);
		try {
			Date date1 = ft.parse(endDateStr);
			Date date2 = ft.parse(startDateStr);
			quot = date1.getTime() - date2.getTime();
			quot = quot / MILLISECONDS_A_DAY;
		} catch (ParseException e) {
			logger.error("获取两个日期相差天数异常: ", e);
		}
		return (int) quot;
	}

	/**
	 * 返回日期字符串："yyyy-MM-dd HH:mm" 格式。
	 * 
	 * @author chun.fengch
	 * 
	 * @param date
	 * @return
	 */
	public static final String getDateTime(Date date) {
		if (date == null)
			return "";
		DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return ymdhmsFormat.format(date);
	}

	/**
	 * 按给定格式返回时间的字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String getDateTime(Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat ymdhmsFormat = new SimpleDateFormat(pattern);
		return ymdhmsFormat.format(date);
	}

	/**
	 * 返回两个日期相差的小时
	 * 
	 * @param startDateStr
	 * @param endDateStr
	 * @param format
	 * @return
	 */
	public static int getQuotHours(Date startDate, Date endDate) {
		long quot = 0;
		quot = endDate.getTime() - startDate.getTime();
		quot = quot / MILLISECONDS_A_HOUR;
		return (int) quot;
	}

	/**
	 * 取当前的时间戳，在页面上保证URL唯一，防止缓存
	 * 
	 * @return
	 */
	public static long getDtSeq() {
		return System.currentTimeMillis();
	}

	/**
	 * 判断是否在参数日期的最大值和最小值之间
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isBetween(Date min, Date compare) {
		Boolean ret = false;
		Date minDate = DateUtil.dateOnlyExt(min);
		Date maxDate = DateUtil.dateOnlyExt(DateUtil.addDays(min, 1));
		if (compare.after(minDate) && compare.before(maxDate)) {
			ret = true;
		}
		return ret;
	}

	public static Date getDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.getTime();
	}

	/**
	 * 获取某日期的年份字符串
	 * 
	 * @param date
	 * @return 字符串类型的年份
	 */
	public static String getYearString(Date date) {
		return DateUtil.date(date, DEFAULT_YEAR_FORMAT);
	}

	/**
	 * 获取某日期的年份数字
	 * 
	 * @param date
	 * @return 数字类型的年份
	 */
	public static int getYearInteger(Date date) {
		return Integer.parseInt(DateUtil.date(date, DEFAULT_YEAR_FORMAT));
	}

	/**
	 * 获取某日期的月份
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month+"";
	}

	/**
	 * 获取某日期的月份数字
	 * 
	 * @param date
	 * @return 数字类型的月份
	 */
	public static int getMonthInteger(Date date) {
		return Integer.parseInt(DateUtil.date(date, DEFAULT_MONTH_FORMAT));
	}

	/**
	 * 取得当前月的的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfCurMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, month);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 1);// 日，设为一号
		// cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
		return cal.getTime();// 获得月末是几号
	}

	/**
	 * 取得当前月的的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfCurMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 1);// 日，设为一号
		// cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, 0);// 下一个月减一为本月最后一天
		return cal.getTime();// 获得月末是几号
	}

	/** */
	/**
	 * 取得某天所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	/** */
	/**
	 * 取得某天所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}

	/** 验证日期是否有效，有效日期范围1900-1-1到2099-12-31. */
	public static boolean isValidDate(Date d) {
		if (d == null)
			return false;
		return pattern.matcher(date(d, DEFAULT_DATE_FORMAT)).matches();
	}
	
	/**
	 * 获取本月第一个周一
	 * @return
	 */
	public static Date getFirstMondayThisMonth(){
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_MONTH, 1);
		today.setFirstDayOfWeek(Calendar.MONDAY);
		today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		today.add(Calendar.DAY_OF_YEAR,7);
		return today.getTime();
	}
	
	/**
	 * 获取下月第一个周日
	 * @return
	 */
	public static Date getFirstSundayLastMonth(){
		Calendar today = Calendar.getInstance();
		today.setFirstDayOfWeek(Calendar.MONDAY);
		today.set(Calendar.DATE, 1);
		today.add(Calendar.MONTH, 1);
		today.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return today.getTime();
	}
	
	/** */
	/**
	 * 取得某天所在周上一周的周日
	 * 
	 * @return
	 */
	public static Date getLastDayOfLastWeek() {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		c.add(Calendar.DAY_OF_YEAR, -7);
		return c.getTime();
	}
	
	/** */
	/**
	 * 取得某天所在周的上一周的周一
	 * 	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfLastWeek() {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.add(Calendar.DAY_OF_YEAR, -7);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}
	/**
	 * 获取上一周所在月第一个周一
	 * @return
	 */
	public static Date getFirstMondayLastMonth(){
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_YEAR, -7);
		today.setFirstDayOfWeek(Calendar.MONDAY);
		today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		today.getTime();
		today.set(Calendar.DAY_OF_MONTH, 1);
		today.getTime();
		today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		if(today.get(Calendar.DAY_OF_MONTH) !=1){
			today.add(Calendar.DAY_OF_YEAR,7);
		}
		return today.getTime();
	}
	
	/**
	 * 获取月和日的英文缩写，从1-12,如Feb.3rd
	 * @return
	 */
	public static String getMonthNameAll(Date time){
		String[] monthEn = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug",
				"Sep","Oct","Nov","Dec"};
		String mon = "";
		String d = "";
		int month = time.getMonth();
		int day = time.getDate();
		switch(month){
			case 0:mon = monthEn[0];break;
			case 1:mon = monthEn[1];break;
			case 2:mon = monthEn[2];break;
			case 3:mon = monthEn[3];break;
			case 4:mon = monthEn[4];break;
			case 5:mon = monthEn[5];break;
			case 6:mon = monthEn[6];break;
			case 7:mon = monthEn[7];break;
			case 8:mon = monthEn[8];break;
			case 9:mon = monthEn[9];break;
			case 10:mon = monthEn[10];break;
			case 11:mon = monthEn[11];break;
			case 12:mon = monthEn[12];break;
		}
		switch(day){
			case 1:d = day+"st";break;
			case 2:d = day+"nd";break;
			case 3:d = day+"rd";break;
			default:d = day+"th";
		}
		
		mon = mon+"."+d;
		return mon;
	}
	
	/**
	 * 获取月和日的英文缩写，从1-12,如Feb.3
	 * @return
	 */
	public static String getMonthName(Date time){
		String[] monthEn = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug",
				"Sep","Oct","Nov","Dec"};
		String mon = "";
		String d = "";
		int month = time.getMonth();
		int day = time.getDate();
		switch(month){
			case 0:mon = monthEn[0];break;
			case 1:mon = monthEn[1];break;
			case 2:mon = monthEn[2];break;
			case 3:mon = monthEn[3];break;
			case 4:mon = monthEn[4];break;
			case 5:mon = monthEn[5];break;
			case 6:mon = monthEn[6];break;
			case 7:mon = monthEn[7];break;
			case 8:mon = monthEn[8];break;
			case 9:mon = monthEn[9];break;
			case 10:mon = monthEn[10];break;
			case 11:mon = monthEn[11];break;
		}
		
		mon = mon+"."+day;
		return mon;
	}
	
	/**
	 * 查询一周前的今天为今年的第几周
	 * @return
	 */
	public static String getWeekNoLastWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -7);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);//需要设置周一为一周的起始日
		return String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
	}

	/*
	 * 获取日期所在周为当年第几周
	 */
	public static int getWeekOfYear(Date date){
		Calendar cal=Calendar.getInstance(); 
		cal.setFirstDayOfWeek(Calendar.MONDAY);//需要设置周一为一周的起始日
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	@SuppressWarnings("deprecation")
	public static String getQuarterString(Date time){
		String qua = "";
		int month = time.getMonth();
		switch(month){//西门子规定季度为财务年的季度，但是数据库中仍然以自然季度做存储
			case 0:
			case 1:
			case 2:qua = "1";break;
			case 3:
			case 4:
			case 5:qua = "2";break;
			case 6:
			case 7:
			case 8:qua = "3";break;
			case 9:
			case 10:
			case 11:qua = "4";break;
		}
		return qua;
	}
	
	public static void main(String[] args){
		Date lastWeekDay = DateUtil.addDays(new Date(), -7);//获取当天-7

		System.out.println(getWeekOfYear(lastWeekDay));
	}
}
