package org.great.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.great.search.MedicalCheckup;
import org.great.test.TsecIm;


import freemarker.template.Configuration;
import freemarker.template.Template;

public class Printing {

	  public void exportSimpleWord(MedicalCheckup mck) throws Exception{  
		  // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致  
		  Map<String,Object> dataMap = new HashMap<String,Object>(); 
		  dataMap.put("mck", mck);
		  dataMap.put("tm",CodeTest03.createBarcode(mck.getGuChId(), "传一科技"));
		  String na =mck.getGuChId();
		  //Configuration用于读取ftl文件  
	      Configuration configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	      
	      configuration.setDirectoryForTemplateLoading(new File("f:/")); 
	      
	      // 输出文档路径及名称 
	      //得到当前系统时间
	      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	      String time = df.format(new Date());
	      File outFile = new File("D:/daojiandan/"+time+"/"+""+na+".doc");  
	      if (!outFile.exists()) {   //文件不存在则创建文件，先创建目录
              File dir = new File(outFile.getParent());
              dir.mkdirs();
              outFile.createNewFile();
	      }
	      //以utf-8的编码读取ftl文件  
	      Template t =  configuration.getTemplate("djd.ftl","utf-8");  
	      
	      Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
	      
	      t.process(dataMap, out);  
	      out.close(); 
	  }
}
