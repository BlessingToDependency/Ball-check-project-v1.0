//package org.great.tools;
//
//import java.io.File;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import jxl.Workbook;
//import jxl.format.Colour;
//import jxl.write.Label;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//public class sql2excel {
//
//    public void createXLS() {
//        Connection conn = null;
//        try {
//           
//            Date now = new Date();
//            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//            String nowdate = df.format(now);
//            // 打开文件
//            WritableWorkbook book = Workbook.createWorkbook(new File(nowdate + ".xls"));
//            System.out.println(book);
//            System.out.println(nowdate + ".xls");
//            // 生成名为"第一页"的工作表，参数0表示这是第一
//            WritableSheet sheet = book.createSheet("第一页", 0);
//
//            // 设置字体为宋体,16号字,加粗,颜色为黑色
//            WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
//            font1.setColour(Colour.BLACK);
//            WritableCellFormat format1 = new WritableCellFormat(font1);
//            format1.setAlignment(jxl.format.Alignment.CENTRE);
//            format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
//
//            Label labelA = new Label(0, 0, "序号", format1);
//            Label labelB = new Label(1, 0, "姓名", format1);
//            Label labelC = new Label(2, 0, "性别", format1);
//            Label labelD = new Label(3, 0, "年龄", format1);
//            Label labelE = new Label(4, 0, "身份证号", format1);
//            Label labelF = new Label(5, 0, "联系电话", format1);
//            Label labelG = new Label(6, 0, "公司名", format1);
//
//            // 将定义好的单元格添加到工作表中
//            sheet.addCell(labelA);
//            sheet.addCell(labelB);
//            sheet.addCell(labelC);
//            sheet.addCell(labelD);
//            sheet.addCell(labelE);
//            sheet.addCell(labelF);
//            sheet.addCell(labelG);
//           
//            // 查询数据库中所有的数据
//            List<StuEntity> list = StuService.getAllByDb();
//            System.out.println(list.size());
////            System.out.println("------------------------"+list.toString());
//            while (result.next()) {
//                for (int i = 0; i < list.size(); i++) {
//                    Label labelAi = new Label(0, i + 1, list.get(i).getId());
//                    System.out.println("----------------------"+labelAi.toString());
//                    Label labelBi = new Label(1, i + 1, list.get(i).getOffice_id());
//                    Label labelCi = new Label(2, i + 1, list.get(i).getName());
//                    Label labelDi = new Label(3, i + 1, list.get(i).getEnname());
//                    Label labelEi = new Label(4, i + 1, list.get(i).getRole_type());
//                    Label labelFi = new Label(5, i + 1, list.get(i).getData_scope());
//                    Label labelGi = new Label(6, i + 1, list.get(i).getIs_sys());
//                    Label labelHi = new Label(7, i + 1, list.get(i).getUseable());
//                    Label labelIi = new Label(8, i + 1, list.get(i).getCreate_by());
//                    Label labelJi = new Label(9, i + 1, list.get(i).getCreate_date());
//                    Label labelKi = new Label(10, i + 1, list.get(i).getUpdate_by());
//                    Label labelLi = new Label(11, i + 1, list.get(i).getUpdate_date());
//                    Label labelMi = new Label(12, i + 1, list.get(i).getRemarks());
//                    Label labelNi = new Label(13, i + 1, list.get(i).getDel_flag());
//
//                    
//                    sheet.addCell(labelAi);
//                    sheet.addCell(labelBi);
//                    sheet.addCell(labelCi);
//                    sheet.addCell(labelDi);
//                    sheet.addCell(labelEi);
//                    sheet.addCell(labelFi);
//                    sheet.addCell(labelGi);
//                    sheet.addCell(labelHi);
//                    sheet.addCell(labelIi);
//                    sheet.addCell(labelJi);
//                    sheet.addCell(labelKi);
//                    sheet.addCell(labelLi);
//                    sheet.addCell(labelMi);
//                    sheet.addCell(labelNi);
//
//                }
//                System.out.println(sheet.toString());
//            }
//            
//            // 写入数据并关闭文件
//            book.write();
//            book.close();
//            System.out.println("创建文件成功!");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        new sql2excel().createXLS();
//    }
//}
