package org.great.tools;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class ReadExcel {
	/* public static void main(String[] args) {
		 int i;
		 Sheet sheet;
		 Workbook book;
		 Cell cell1,cell2,cell3;
		 try { 
			 //t.xls为要读取的excel文件名
			 book= Workbook.getWorkbook(new File("D://aa.xls")); 
			 
			 //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
			 sheet=book.getSheet(0); 
			 //获取左上角的单元格
			 cell1=sheet.getCell(0,0);
			 System.out.println("标题："+cell1.getContents()); 
			 
			 i=1;
			 while(true)
			 {
				 //获取每一行的单元格 
				 cell1=sheet.getCell(0,i);//（列，行）
				 cell2=sheet.getCell(1,i);
				 cell3=sheet.getCell(2,i);
				 if("".equals(cell1.getContents())==true)  //如果读取的数据为空
					 break;
				 System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()); 
				 i++;
			 }
			 book.close(); 
		 }
		 catch(Exception e) { } 
	 }*/
	
	public static void main(String args[]){ 
		 File f=new File("D://aa.xls"); 
		 try { 
		  Workbook book=Workbook.getWorkbook(f);// 
		  Sheet sheet=book.getSheet(0); //获得第一个工作表对象 
		  for(int i=0;i<sheet.getRows();i++){ 
		   for(int j=0;j<sheet.getColumns();j++){ 
		    Cell cell=sheet.getCell(j, i); //获得单元格 
		    System.out.print(cell.getContents()+" "); 
		   } 
		   System.out.print("\n"); 
		  } 
		 } catch (BiffException e) { 
		  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		 } catch (IOException e) { 
		  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		 } 
		} 
}
