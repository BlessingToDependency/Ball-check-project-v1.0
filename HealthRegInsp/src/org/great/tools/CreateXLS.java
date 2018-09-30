package org.great.tools;

import java.io.*;
import jxl.*;
import jxl.write.*;

/*
 * 新建一个excel
 */
public class CreateXLS{
	public static void main(String args[]){
		try{
			//打开文件
			WritableWorkbook book=Workbook.createWorkbook(new File("upload/体检表.xls"));
			//生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet=book.createSheet("第一页",0);
			//在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			//以及单元格内容为test
			Label labelTable=new Label(0,0,"传一体检信息表");
			Label label=new Label(0,1,"公司：");
			Label label0=new Label(0,2,"序号");
			Label label1=new Label(1,2,"体检人姓名");
			Label label2=new Label(2,2,"年龄");
			Label label3=new Label(3,2,"性别");
			Label label4=new Label(4,2,"身份证号");
			Label label5=new Label(5,2,"联系电话");
			//将定义好的单元格添加到工作表中
			sheet.addCell(labelTable);
			sheet.addCell(label);
			sheet.addCell(label0);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			/*生成一个保存数字的单元格必须使用Number的完整包路径，否则有语法歧义
				单元格位置是第二列，第一行，值为789.123*/
//			jxl.write.Number number = new jxl.write.Number(1,0,789.123);
//			sheet.addCell(number);
			System.out.println("跑起来");
			//写入数据并关闭文件
			book.write();
			book.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
