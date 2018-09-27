package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 后台登陆表
 */
@Component
public class AdminBean {
	private int adminId;//后台用户ID
	private String adminPwd;//密码
	private String adminName;//名字
	private int age;//年龄
	private String background;//背景
	private long phone;//手机号
	private String graduated;//毕业院校
	private String sex;//性别
	private int postId;//职务ID
	private String head;//头像
	private int depaId;//科室ID
	private int roleId;//角色ID
	private int stateId;//用户状态
	private int logicId;//逻辑状态
	private String idNum;//身份证号
	private String email;//邮箱
	
	@Resource
    private PostBean postBean;
	@Resource
	private RoleBean roleBean;
	@Resource
	private ParamBean paramBean;
	@Resource 
	private DeparBean deparBean;

 
 
	public AdminBean() {
		super();
	}



	public AdminBean(int adminId, String adminPwd, String adminName, int age, String background, long phone,
			String graduated, String sex, int postId, String head, int depaId, int roleId, int stateId, int logicId,
			String idNum, String email, PostBean postBean, RoleBean roleBean, ParamBean paramBean) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.age = age;
		this.background = background;
		this.phone = phone;
		this.graduated = graduated;
		this.sex = sex;
		this.postId = postId;
		this.head = head;
		this.depaId = depaId;
		this.roleId = roleId;
		this.stateId = stateId;
		this.logicId = logicId;
		this.idNum = idNum;
		this.email = email;
		this.postBean = postBean;
		this.roleBean = roleBean;
		this.paramBean = paramBean;
	}



	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getAdminPwd() {
		return adminPwd;
	}



	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}



	public String getAdminName() {
		return adminName;
	}



	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getBackground() {
		return background;
	}



	public void setBackground(String background) {
		this.background = background;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getGraduated() {
		return graduated;
	}



	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public int getPostId() {
		return postId;
	}



	public void setPostId(int postId) {
		this.postId = postId;
	}



	public String getHead() {
		return head;
	}



	public void setHead(String head) {
		this.head = head;
	}



	public int getDepaId() {
		return depaId;
	}



	public void setDepaId(int depaId) {
		this.depaId = depaId;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public int getStateId() {
		return stateId;
	}



	public void setStateId(int stateId) {
		this.stateId = stateId;
	}



	public int getLogicId() {
		return logicId;
	}



	public void setLogicId(int logicId) {
		this.logicId = logicId;
	}



	public String getIdNum() {
		return idNum;
	}



	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public PostBean getPostBean() {
		return postBean;
	}



	public void setPostBean(PostBean postBean) {
		this.postBean = postBean;
	}



	public RoleBean getRoleBean() {
		return roleBean;
	}



	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}



	public ParamBean getParamBean() {
		return paramBean;
	}



	public void setParamBean(ParamBean paramBean) {
		this.paramBean = paramBean;
	}



	public DeparBean getDeparBean() {
		return deparBean;
	}



	public void setDeparBean(DeparBean deparBean) {
		this.deparBean = deparBean;
	}

	
}
