package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TblStatistics {
	
		private String name;     //统计名字
		private int value;			
		private String color;		//柱状图颜色
		
		private String statTime;	//开始时间
		private String stopTime;	//结束时间
		
		public TblStatistics() {
			super();
		}
		
		
		
		/**
		 * 
		 * @Title:TblStatistics
		 * @Description:TODO 
		 * @param statTime
		 * @param stopTime
		 */
		public TblStatistics(String statTime, String stopTime) {
			super();
			this.statTime = statTime;
			this.stopTime = stopTime;
		}



		public TblStatistics(String name, int value, String color) {
			super();
			this.name = name;
			this.value = value;
			this.color = color;
		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "TblStatistics [name=" + name + ", value=" + value + ", color=" + color + ", statTime=" + statTime
					+ ", stopTime=" + stopTime + "]";
		}




		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getStatTime() {
			return statTime;
		}
		public void setStatTime(String statTime) {
			this.statTime = statTime;
		}
		public String getStopTime() {
			return stopTime;
		}
		public void setStopTime(String stopTime) {
			this.stopTime = stopTime;
		}
		
		
		
		
}
