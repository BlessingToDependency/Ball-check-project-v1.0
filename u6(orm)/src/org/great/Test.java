package org.great;


public class Test {

	public static void main(String[] args) {

		OrmMain ormMain = new OrmMain();

		// 测试o-->m

		// 构建对像
		Userinfo userinfo = new Userinfo();
		userinfo.setUserid("1");
		userinfo.setLoginname("张三");
		userinfo.setPwd("123");
		userinfo.setTruename("张三三");
		userinfo.setState("01");

		ormMain.o2m(userinfo);

		// 测试m-->o
		// 构造查询对像
		Userinfo userinfo2 = new Userinfo();

		ormMain.m2o(userinfo2);

	}
}
