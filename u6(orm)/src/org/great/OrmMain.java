package org.great;

import java.util.List;
/**
 * orm主类
 * @author Administrator
 *
 */
public class OrmMain {

	/**
	 * 数据库插入 
	 * Object --> Relational
	 * @param userinfo:要保存的对像
	 */
	public static void o2m(Userinfo userinfo) {

		try {
			MappingUtil mappingUtil = new MappingUtil();
			// 读取配置文件，使用反射机制，生成sql语句
			String insertSql = mappingUtil.fromBean2InsertSql(userinfo);

			mappingUtil.updateSql(insertSql);// jdbc执行sql语句
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 数据库查询
	 * Relational --> Object
	 * @param userinfo:要查询的对像
	 * @param condition:查询条件
	 */
	public static void m2o(Userinfo userinfo) {
		MappingUtil mappingUtil = new MappingUtil();
		Class c = Userinfo.class;
		//根据对像，加载配置文件，生成查询语句
		String sql = mappingUtil.getQuerySqlFromBean(userinfo);
		//执行sql语句,返回List<Object[]>形式的结果
		List<Object[]> datas =mappingUtil.findSql(sql);
		//将List<Object[]>转化成指定的List<Userinfo>类型
		List<Userinfo> users = (List<Userinfo>)mappingUtil.getBeanListFromObjectArrList(
				datas, Userinfo.class);
		//查询结果
		for (Userinfo us : users) {
			System.out.println("userid=" + us.getUserid());
			System.out.println("Loginname=" + us.getLoginname());
			System.out.println("Pwd=" + us.getTruename());
			System.out.println("Truename=" + us.getPwd());
			System.out.println("State=" + us.getState());
			System.out.println("============================");
		}

	}
}
