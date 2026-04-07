package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import base.BaseClass;

public class ExcelReader extends BaseClass{
	
	public static Object[][] getExcelData() {

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/testdata/paymentdata.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount - 1][colCount]; // skip header

            for (int i = 1; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
