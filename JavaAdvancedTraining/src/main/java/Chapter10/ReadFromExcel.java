package Chapter10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromExcel {
    public static void main(String[] args) {
        String filePath = "D:\\repos\\java-advanced-interns-2025\\JavaAdvancedTraining\\src\\main\\resources\\Student Results.xlsx";

        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            XSSFWorkbook myWorkbook = new XSSFWorkbook(fileInput);
            XSSFSheet sheet = myWorkbook.getSheetAt(0);

//            System.err.println("Name\t\tTest 1\t\tTest 2\t\tTest 3");
//            for (int i = 1; i < sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                for (int col = 0; col < row.getLastCellNum(); col++) {
//                    Cell cell = row.getCell(col);
//                    System.out.print(cell + "\t\t");
//                }
//                System.out.println();
//            }
            for(Row row : sheet){
                for (Cell myCell : row){

                    switch (myCell.getCellType()){
                        case STRING -> System.out.print(myCell.getStringCellValue() + "\t\t");
                        case NUMERIC -> System.out.print(myCell.getNumericCellValue() + "\t\t");
                        default -> System.err.println("Invalid cell type. " + myCell.getCellType());
                    }
                    //System.out.print(myCell + "\t\t");
                }
                System.out.println();
            }
            fileInput.close();
            myWorkbook.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
