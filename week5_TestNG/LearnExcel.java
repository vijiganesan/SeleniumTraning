package testcase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public static String[][] readData(String fileName) throws IOException {
		
		//for .xls Format
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");

		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getLastRowNum();
		//System.out.println(rowsCount);
		
		short cellCount = ws.getRow(0).getLastCellNum();
		//System.out.println(cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			
			for (int j = 0; j < cellCount; j++) {
				
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				
			}
						
		}
		
		wb.close();
		
		return data;
	}

}
