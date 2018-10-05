package org.great.tools;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class DateSet {
	// 得到近三个月的时间
	public static List<String> getQuarter() {
		List<String> quList = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		// 这是已知的日期
		Date d = new Date();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		c.set(Calendar.DAY_OF_MONTH, 1);
		// 1号的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d = c.getTime();
		String time = sdf.format(d);
		System.out.println(time);

		Date dBefore1 = new Date();
		Date dBefore2 = new Date();
		Date dBefore3 = new Date();

		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(d);// 把当前时间赋给日历
		calendar.add(Calendar.MONTH, -1); // 设置为前3月
		dBefore1 = calendar.getTime();
		calendar.add(Calendar.MONTH, -1);
		dBefore2 = calendar.getTime();
		calendar.add(Calendar.MONTH, +3);
		dBefore3 = calendar.getTime(); // 得到前3月的时间
		String defaultStartDate1 = sdf.format(dBefore1); // 格式化前3月的时间
		String defaultStartDate2 = sdf.format(dBefore2);
		String defaultStartDate3 = sdf.format(dBefore3);
		quList.add(defaultStartDate2);
		quList.add(defaultStartDate1);
		quList.add(time);
		quList.add(defaultStartDate3);

		return quList;

	}

	// 得到本周所有时间加上下周一时间
	public static List<String> getWeek() {
		List<String> weekList = new ArrayList<String>();
		String yz_time = getTimeInterval(new Date());// 获取本周时间
		String array[] = yz_time.split(",");
		String start_time = array[0];// 本周第一天
		String end_time = array[1]; // 本周最后一天
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = null;
		Date dEnd = null;
		try {
			dBegin = sdf.parse(start_time);
			dEnd = sdf.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Date> lDate = findDates(dBegin, dEnd);// 获取这周所有date
		Calendar cal = Calendar.getInstance();
		cal.setTime(lDate.get(0));
		cal.add(Calendar.DATE, 7);

		for (Date date : lDate) {
			weekList.add(sdf.format(date));
		}
		weekList.add(sdf.format(cal.getTime()));

		return weekList;
	}

	// 得到当前月有几周以及每周开始时间和结束时间
	public static List<String> getMount() {
		Date first = firstMonthDate(new Date());
        Map<Integer,WeekRange> maps = new HashMap<Integer, WeekRange>();
        getWeekBeginAndEnd(1,first,maps);
         
        Set<Integer> set = maps.keySet();
        List<String> mountList=new ArrayList<String>();
        String lastDay=null;
        for(Integer key : set){
            WeekRange range = maps.get(key);
            System.out.println(String.format("第%d周,开始日期：%s,结束日期：%s", key,format(range.getBegin()),format(range.getEnd())));
            mountList.add(format(range.getBegin()));
            lastDay= format(range.getEnd());
        }
        mountList.add(lastDay);
        System.out.println(mountList.get(5));
		return mountList;
	
	}
	
	
	
	public static String getTimeInterval(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(cal.getTime());
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		// System.out.println("所在周星期日的日期：" + imptimeEnd);
		return imptimeBegin + "," + imptimeEnd;
	}

	public String getLastTimeInterval() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
		int offset1 = 1 - dayOfWeek;
		int offset2 = 7 - dayOfWeek;
		calendar1.add(Calendar.DATE, offset1 - 7);
		calendar2.add(Calendar.DATE, offset2 - 7);
		// System.out.println(sdf.format(calendar1.getTime()));// last Monday
		String lastBeginDate = sdf.format(calendar1.getTime());
		// System.out.println(sdf.format(calendar2.getTime()));// last Sunday
		String lastEndDate = sdf.format(calendar2.getTime());
		return lastBeginDate + "," + lastEndDate;
	}

	public static List<Date> findDates(Date dBegin, Date dEnd) {
		List lDate = new ArrayList();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}
	 private static DateFormat datafFormat = new SimpleDateFormat("yyyy-MM-dd");
	  // 月初
    public static Date firstMonthDate(Date date){
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
     
    // 月末
    public static Date lastMonthDate(Date date){
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
     
    // 星期几
    public static int week(Date date){
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
     
    // 下一天
    public static Date nextDate(Date date){
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
     
    // 每周开始结束时间
    public static void getWeekBeginAndEnd(int index,Date currentDate,Map<Integer,WeekRange> maps){
        //月末
        Date lastMonthDate = lastMonthDate(currentDate);
        int week = week(currentDate);
        if(null == maps){
            WeekRange range = new WeekRange(currentDate, currentDate);
            maps = new HashMap<Integer, WeekRange>();
            maps.put(index,range);
        }else{
            WeekRange range = maps.get(index);
            if(null == range){
                range = new WeekRange(currentDate);
            }
            range.setEnd(currentDate);
            maps.put(index,range);
        }
         
        if(currentDate.equals(lastMonthDate)){
            return;
        }
         
        if(week == 0){
            index++;
        }
         
        getWeekBeginAndEnd(index,nextDate(currentDate),maps);
    }
     
    public static String format(Date date){
        return datafFormat.format(date);
    }
}
 
class WeekRange{
    Date begin;//周开始日
    Date end;//周结束日
    public WeekRange(Date begin) {
        super();
        this.begin = begin;
    }
    public WeekRange(Date begin, Date end) {
        super();
        this.begin = begin;
        this.end = end;
    }
    public Date getBegin() {
        return begin;
    }
    public void setBegin(Date begin) {
        this.begin = begin;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
}
