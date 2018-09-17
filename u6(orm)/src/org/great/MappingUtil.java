package org.great;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * createBy zx
 *
 *
 * 类和表的映射工具
 *
 */
public class MappingUtil {

	public MappingUtil() {

	}

	// 从Object[] 转为Bean
	public Object fromObject2Bean(Class c, Object[] o)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Object ob = c.newInstance();
		Method[] f = c.getMethods();
		String path = this.getXmlFileName(c);
		Map map = this.readXml(path);
		for (int i = 0; i < f.length; i++) {
			Method method = f[i];
			String methodName = method.getName();
			if (methodName.startsWith("set")) {
				String fieldName = methodName.replace("set", "");
				String upChar = fieldName.charAt(0) + "";
				fieldName = fieldName.replace(upChar, upChar.toLowerCase());
				String order = (String) map.get(fieldName);
				method.invoke(ob, o[Integer.valueOf(order) - 1]);
			}
		}
		return ob;
	}

	// 获取class获取映射文件位置
	private String getXmlFileName(Class c) {
		String path = "";
		String xml = c.getName().substring((c.getName().lastIndexOf(".")) + 1)
				+ ".xml";
		path = c.getResource(xml).toString();
		return path;
	}

	// 读取xml，把属性,顺序放入map
	private Map readXml(String path) {
		Map map = new HashMap();
		SAXBuilder sb = new SAXBuilder();
		try {
			Document myDocument = sb.build(path);
			Element root = myDocument.getRootElement();
			Element table = root.getChild("table");
			List<Element> list = table.getChildren("property");
			for (Element e : list) {
				String order = e.getAttributeValue("order");
				String name = e.getAttributeValue("name");
				map.put(name, order);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 读取xml，把属性名，表字段放入map
	private Map readXmlForsql(String path) {
		Map map = new HashMap();
		SAXBuilder sb = new SAXBuilder();
		try {
			Document myDocument = sb.build(path);
			if (myDocument == null) {
				throw new RuntimeException("请检查xml的路径");
			}
			Element root = myDocument.getRootElement();
			Element table = root.getChild("table");
			List<Element> list = table.getChildren("property");
			String tableName = table.getAttributeValue("name");
			map.put("table_name", tableName);
			for (Element e : list) {
				String column = e.getAttributeValue("column");
				String name = e.getAttributeValue("name");
				map.put(name, column);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 根据对象转换插入sql语句
	public String fromBean2InsertSql(Object o) {
		StringBuilder sb = new StringBuilder();
		String path = this.getXmlFileName(o.getClass());
		Map map = this.readXmlForsql(path);
		sb.append("insert into " + map.get("table_name"));
		map.remove("table_name");
		Set set = map.entrySet();
		Iterator it = set.iterator();
		StringBuilder columns = new StringBuilder();
		StringBuilder values = new StringBuilder();
		columns.append("(");
		values.append("(");
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			columns.append(e.getValue() + ",");
			Object ob = this.getValueOfObject(o, e.getKey().toString());
			if (null == ob) {
				values.append("null,");
			} else {
				values.append("'" + ob + "',");
			}
		}
		String cStr = columns.toString().substring(0,
				columns.toString().length() - 1);
		String vStr = values.toString().substring(0,
				values.toString().length() - 1);
		sb.append(cStr + ")");
		sb.append(" values ");
		sb.append(vStr + ")");
		return sb.toString();
	}

	// 根据属性名称获取对象该属性的值
	public Object getValueOfObject(Object ob, String field) {
		Object o = new Object();
		String s = field.substring(0, 1);
		String fieldNew = s.toUpperCase() + field.substring(1, field.length());
		String method = "get" + fieldNew;
		try {
			try {
				Method m = ob.getClass().getMethod(method);
				o = m.invoke(ob);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return o;
	}

	// 把一个List<Object[]> 转为List<Bean>
	public List<?> getBeanListFromObjectArrList(List<Object[]> list, Class c) {
		List newList = new ArrayList();
		for (Object[] o : list) {
			try {
				Object ob = this.fromObject2Bean(c, o);
				newList.add(ob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return newList;
	}

	// 根据对象生成查询sql
	public String getQuerySqlFromBean(Object o) {
		StringBuilder sb = new StringBuilder();
		String path = this.getXmlFileName(o.getClass());
		Map map = this.readXmlForsql(path);
		sb.append("select * from " + map.get("table_name") + "  where 1 = 1");
		map.remove("table_name");
		map.remove("fdId");
		Set set = map.entrySet();
		System.out.println(sb.toString());
		return sb.toString();
	}


	/**
	 * jdbc执行增加的sql
	 * 
	 * @param sql
	 * @throws Exception
	 */
	public static void updateSql(String sql) throws Exception {
		// 创建数据库连接，执行sql语句
		Connection conn = DBManager.getCon();
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();
		stmt.close();
		conn.close();
	}

	/**
	 * jdbc执行查询的sql
	 */
	public static List<Object[]> findSql(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getCon();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = ps.getMetaData();

			// 取得结果集列数
			int columnCount = rsmd.getColumnCount();
			// 构造泛型结果集
			List<Object[]> datas = new ArrayList<Object[]>();

			// 循环结果集
			while (rs.next()) {
				Object[] data = new Object[columnCount];
				// 每循环一条将列名和列值存入Map
				for (int i = 1; i <= columnCount; i++) {
					data[i - 1] = rs.getObject(rsmd.getColumnLabel(i));
				}
				// 将整条数据的Map存入到List中
				datas.add(data);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeResultSet(rs);
			DBManager.closePreparedStatement(ps);
			DBManager.closeConnection();
		}
		return null;
	}


	// //根据id和class生成删除sql
	// public String getDeleteSql(Class c,String id){
	// String path = this.getXmlFileName(c);
	// Map map = this.readXmlForsql(path);
	// String sql =
	// "delete from "+map.get("table_name")+" where fd_id='"+id+"'";
	// return sql;
	// }
	//
	// //根据对象生成更新sql
	// public String getUpdateSql(Object o){
	// StringBuilder sb = new StringBuilder();
	// String path = this.getXmlFileName(o.getClass());
	// Map map = this.readXmlForsql(path);
	// sb.append("update "+map.get("table_name"));
	// //把主键和表名移除，全剩属性
	// map.remove("fdId");
	// map.remove("table_name");
	// Set set = map.entrySet();
	// Iterator it = set.iterator();
	// StringBuilder values = new StringBuilder();
	// values.append(" set ");
	// while(it.hasNext()){
	// Map.Entry e = (Map.Entry)it.next();
	// Object ob = this.getValueOfObject(o, e.getKey().toString());
	// if(null == ob){
	// values.append(e.getValue()+"=null");
	// }else{
	// values.append(e.getValue()+"='"+ob+"',");
	// }
	// }
	// String vStr =
	// values.toString().substring(0,values.toString().length()-1);
	// sb.append(vStr);
	// //主键地方需要改进
	// sb.append(" where fd_id= '"+getValueOfObject(o,"fdId")+"'");
	// return sb.toString();
	// }

}
