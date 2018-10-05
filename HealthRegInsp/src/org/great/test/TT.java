package org.great.test;

import org.great.search.MedicalCheckup;
import org.great.tools.CodeTest03;
import org.great.tools.Printing;

public class TT {

	public static void main(String[] args) {
		/*String dd =CodeTest03.createBarcode("KJ4.1-0127-2222-8888", "漂爸爸");
		System.out.println(dd);*/
		MedicalCheckup mck = new MedicalCheckup();
		mck.setAge(50);
		mck.setBatch(2);
		mck.setCompany("无敌项目组");
		mck.setGuChId("jx1803-2018-10-10-11");
		mck.setName("小黑");
		mck.setPhone("15888231687");
		mck.setPrintTime("2018-10-10");
		mck.setSex("男");
		mck.setDept1("1111111");
		mck.setDept2("2222222");
		mck.setDept3("3333333");
		mck.setDept4("4444444");
		mck.setDept5("5555555");
		mck.setDescribe1("1111111111");
		mck.setDescribe2("2222222222");
		mck.setDescribe3("3333333333");
		mck.setDescribe4("4444444444");
		mck.setDescribe5("5555555555");
		mck.setItem1("111111111");
		mck.setItem2("111111111");
		mck.setItem3("111111111");
		mck.setItem4("111111111");
		mck.setItem5("111111111");
		mck.setId("888888888888888888888");
		Printing p = new Printing();
		try {
			p.exportSimpleWord(mck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
