package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 员工表
 */
@Component
public class StaffBean {
     private int staffId;//员工ID
     private String staffName;//员工名
     private int age;//年龄
     private String sex;//性别
     private String idNum;//身份证号
     private long phone;//电话
     private int companyId;//公司ID
     private String napany;
     private int medicalId;//体检状态
     private String myGuChId ;//最新导检单号
     private int printGuCh; //打印导检单状态
     private int orderId;//预约状态
     private  Integer smallState;  //小结状态
     private  String examTime;    //体检时间
     
	 private String statTime;//开始时间
     private String stopTime;//结束时间
     private Integer  currentpage;  //当前页数
     private Integer  totalPage;   //总页数
     private  Integer pagecount = 5; //每页限制页数
     
     @Resource
     private UserBean userBean;//前台公司表
     @Resource
     private PerguirelaBean perguirelaBean;//员工导检单关系表
     
     private TotalBean totalBean;  //总结表
	 
	public StaffBean() {
		super();
	}


	public StaffBean(int staffId, String staffName, int age, String sex, String idNum, long phone, int companyId,
			String napany, int medicalId, String myGuChId, int printGuCh, String statTime, String stopTime,
			UserBean userBean, PerguirelaBean perguirelaBean) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.age = age;
		this.sex = sex;
		this.idNum = idNum;
		this.phone = phone;
		this.companyId = companyId;
		this.napany = napany;
		this.medicalId = medicalId;
		this.myGuChId = myGuChId;
		this.printGuCh = printGuCh;
		this.statTime = statTime;
		this.stopTime = stopTime;
		this.userBean = userBean;
		this.perguirelaBean = perguirelaBean;
	}


	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StaffBean [staffId=" + staffId + ", staffName=" + staffName + ", age=" + age + ", sex=" + sex
				+ ", idNum=" + idNum + ", phone=" + phone + ", companyId=" + companyId + ", napany=" + napany
				+ ", medicalId=" + medicalId + ", myGuChId=" + myGuChId + ", printGuCh=" + printGuCh + ", orderId="
				+ orderId + ", smallState=" + smallState + ", examTime=" + examTime + ", statTime=" + statTime
				+ ", stopTime=" + stopTime + ", currentpage=" + currentpage + ", totalPage=" + totalPage
				+ ", pagecount=" + pagecount + ", userBean=" + userBean + ", perguirelaBean=" + perguirelaBean
				+ ", totalBean=" + totalBean + "]";
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getIdNum() {
		return idNum;
	}


	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getNapany() {
		return napany;
	}


	public void setNapany(String napany) {
		this.napany = napany;
	}


	public int getMedicalId() {
		return medicalId;
	}


	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}


	public String getMyGuChId() {
		return myGuChId;
	}


	public void setMyGuChId(String myGuChId) {
		this.myGuChId = myGuChId;
	}


	public int getPrintGuCh() {
		return printGuCh;
	}


	public void setPrintGuCh(int printGuCh) {
		this.printGuCh = printGuCh;
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


	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


	public PerguirelaBean getPerguirelaBean() {
		return perguirelaBean;
	}


	public void setPerguirelaBean(PerguirelaBean perguirelaBean) {
		this.perguirelaBean = perguirelaBean;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	/**
	 * @return the smallState
	 */
	public Integer getSmallState() {
		return smallState;
	}


	/**
	 * @param smallState the smallState to set
	 */
	public void setSmallState(Integer smallState) {
		this.smallState = smallState;
	}


	/**
	 * @return the examTime
	 */
	public String getExamTime() {
		return examTime;
	}


	/**
	 * @param examTime the examTime to set
	 */
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}


	/**
	 * @return the totalBean
	 */
	public TotalBean getTotalBean() {
		return totalBean;
	}


	/**
	 * @param totalBean the totalBean to set
	 */
	public void setTotalBean(TotalBean totalBean) {
		this.totalBean = totalBean;
	}


	/**
	 * @return the currentpage
	 */
	public Integer getCurrentpage() {
		return currentpage;
	}


	/**
	 * @param currentpage the currentpage to set
	 */
	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}


	/**
	 * @return the pagecount
	 */
	public Integer getPagecount() {
		return pagecount;
	}


	/**
	 * @param pagecount the pagecount to set
	 */
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}


	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}


	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}



	
     
     
}
