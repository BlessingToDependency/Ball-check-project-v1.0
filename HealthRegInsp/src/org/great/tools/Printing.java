package org.great.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Printing {
	  @Test
	  public static void exportSimpleWord() throws Exception{  
		  // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致  
		  Map<String,String> dataMap = new HashMap<String,String>(); 
		  dataMap.put("username", "李四");
		  
		  //Configuration用于读取ftl文件  
	      Configuration configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	      
	      configuration.setDirectoryForTemplateLoading(new File("f:/")); 
	      
	   // 输出文档路径及名称  
	      File outFile = new File("D:/test.doc");  
	      
	      //以utf-8的编码读取ftl文件  
	      Template t =  configuration.getTemplate("lala.ftl","utf-8");  
	      
	      Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
	      
	      t.process(dataMap, out);  
	      out.close(); 
	  }
}
