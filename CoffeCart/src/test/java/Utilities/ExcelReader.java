package Utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A utility class for reading test data from an excel workbook. Primarily used
 * to obtain data for data-driven testing.
 */
public class ExcelReader {

	/**
	 * Test data is ready from an Excel sheet and then returned in a 2D Array,
	 * method has been created to be used by TestNG DataProvider.
	 * 
	 * @param filePath  Setting a file path which is used to load the excel file.
	 * @param sheetName Name of the specified excel sheet
	 * @return 2D Object array which includes the test data
	 * @throws IOException When the file cannot be found or read.
	 */
	public static Object[][] getTestData(String filePath, String sheetName) throws IOException {

		FileInputStream fis = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();

		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {

				data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));

			}

		}

		workbook.close();

		fis.close();

		return data;

	}

}
