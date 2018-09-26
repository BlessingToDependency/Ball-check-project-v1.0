package org.great.tools;


import java.io.*;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

/*
 * 修改Excel的类，添加一个工作表
 */
public class UpdateXLS{
	public static void main(String args[])
	{
		
			try {
				//创建只读的 Excel 工作薄的对象副本
				Workbook wb=Workbook.getWorkbook(new File("upload/体检表.xls"));
				//创建真实写入的 Excel 工作薄对象
				WritableWorkbook book = Workbook.createWorkbook(new File("upload/体检表修改.xls"),wb);
				//修改文本内容：例修改sheet2中cell B3的label内容
				WritableSheet sheet2 = book.getSheet(0);
				WritableCell cell = sheet2.getWritableCell(1, 2);
				if (cell.getType() == CellType.LABEL)
				{
					Label l = (Label) cell;
					l.setString("modified cell");
				}
				//修改文本格式：例修改sheet2中cell C5的Number的格式
				WritableSheet sheet3 = book.getSheet(0);
				WritableCell cell2 = sheet3.getWritableCell(2, 4);
				NumberFormat fivedps = new NumberFormat("#.#####");
				WritableCellFormat cellFormat = new WritableCellFormat(fivedps);
				cell2.setCellFormat(cellFormat);
				//添加一个工作表
				WritableSheet sheet=book.createSheet("第二页",1);
				sheet.addCell(new Label(0,0,"第二页的测试数据"));
				book.write();
				book.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
}