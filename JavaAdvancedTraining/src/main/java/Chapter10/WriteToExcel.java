package Chapter10;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteToExcel {
    public static void main(String[] args) {
        String filePath = "D:\\repos\\java-advanced-interns-2025\\JavaAdvancedTraining\\src\\main\\resources\\Modules.xlsx";

        try {
            OutputStream fileWrite = new FileOutputStream(filePath);
            //Create a workbook object
            XSSFWorkbook myWorkbook = new XSSFWorkbook();
            //Create a spreadsheet inside the workbook
            XSSFSheet sheet = myWorkbook.createSheet("iLAB Modules");
            //Create a header row
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("Module");
            header.createCell(1).setCellValue("Credits");
            //Create row1
            XSSFRow row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Java Fund");
            row1.createCell(1).setCellValue(250);
            //Create row2
            XSSFRow row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("Java Adv");
            row2.createCell(1).setCellValue(300);
            //Create row3
            XSSFRow row3 = sheet.createRow(3);
            row3.createCell(0).setCellValue("SQL");
            row3.createCell(1).setCellValue(150);
            //Create row4
            XSSFRow row4 = sheet.createRow(4);
            row4.createCell(0).setCellValue("ISTQB CTFL");
            row4.createCell(1).setCellValue(350);

            myWorkbook.write(fileWrite);
            fileWrite.close();
            myWorkbook.close();

        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}
