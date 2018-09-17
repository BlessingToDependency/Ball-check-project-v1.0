package org.great.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTool {

	public static SqlSession getSession() {
		String config = "SqlMapConfig.xml";
		SqlSession session=null;
		try {
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

			Reader reader = Resources.getResourceAsReader(config);

			SqlSessionFactory sf = sfb.build(reader);
			
			 session= sf.openSession();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	public static void main(String[] args) {
		System.out.println(MybatisTool.getSession());
	}
}
