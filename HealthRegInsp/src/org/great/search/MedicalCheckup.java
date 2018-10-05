package org.great.search;

public class MedicalCheckup {
	private String company;  //公司名
	private int batch;       //批次号
	private String guChId;   //导检单号
	private String name;     //姓名
	private String sex;      //性别
	private int age;         //年纪
	private String phone;    //手机号
	private String printTime;//打印时间
	private String id;       //身份证号
	private String item1;     //项目一
	private String dept1;     //科室一
	private String describe1;  //描述二
	
	private String item2;     //项目二
	private String dept2;     //科室二
	private String describe2;  //描述二
	
	private String item3;     //项目三
	private String dept3;     //科室三
	private String describe3;  //描述三
	
	private String item4;     //项目四
	private String dept4;     //科室四
	private String describe4;  //描述四
	
	private String item5;     //项目五
	private String dept5;     //科室五
	private String describe5;  //描述五
	
	
	private int staffId;     //员工ID
	private int companyId;   //公司ID
	
	public MedicalCheckup() {
		
	}

	public MedicalCheckup(String company, int batch, String guChId, String name, String sex, int age, String phone,
			String printTime, String id, String item1, String dept1, String describe1, String item2, String dept2,
			String describe2, String item3, String dept3, String describe3, String item4, String dept4,
			String describe4, String item5, String dept5, String describe5, int staffId, int companyId) {
		super();
		this.company = company;
		this.batch = batch;
		this.guChId = guChId;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.printTime = printTime;
		this.id = id;
		this.item1 = item1;
		this.dept1 = dept1;
		this.describe1 = describe1;
		this.item2 = item2;
		this.dept2 = dept2;
		this.describe2 = describe2;
		this.item3 = item3;
		this.dept3 = dept3;
		this.describe3 = describe3;
		this.item4 = item4;
		this.dept4 = dept4;
		this.describe4 = describe4;
		this.item5 = item5;
		this.dept5 = dept5;
		this.describe5 = describe5;
		this.staffId = staffId;
		this.companyId = companyId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public String getGuChId() {
		return guChId;
	}

	public void setGuChId(String guChId) {
		this.guChId = guChId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrintTime() {
		return printTime;
	}

	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getDept1() {
		return dept1;
	}

	public void setDept1(String dept1) {
		this.dept1 = dept1;
	}

	public String getDescribe1() {
		return describe1;
	}

	public void setDescribe1(String describe1) {
		this.describe1 = describe1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getDept2() {
		return dept2;
	}

	public void setDept2(String dept2) {
		this.dept2 = dept2;
	}

	public String getDescribe2() {
		return describe2;
	}

	public void setDescribe2(String describe2) {
		this.describe2 = describe2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getDept3() {
		return dept3;
	}

	public void setDept3(String dept3) {
		this.dept3 = dept3;
	}

	public String getDescribe3() {
		return describe3;
	}

	public void setDescribe3(String describe3) {
		this.describe3 = describe3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getDept4() {
		return dept4;
	}

	public void setDept4(String dept4) {
		this.dept4 = dept4;
	}

	public String getDescribe4() {
		return describe4;
	}

	public void setDescribe4(String describe4) {
		this.describe4 = describe4;
	}

	public String getItem5() {
		return item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	public String getDept5() {
		return dept5;
	}

	public void setDept5(String dept5) {
		this.dept5 = dept5;
	}

	public String getDescribe5() {
		return describe5;
	}

	public void setDescribe5(String describe5) {
		this.describe5 = describe5;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	
}
