package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getExcelData(String sheetName, String tcID , String headerValue) throws Throwable
	{
		FileInputStream fin = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getPhysicalNumberOfRows();
		
		int targetRowNo = 0;
		for(int i=0;i<lastRow;i++)
		{
			String testcaseID = sheet.getRow(i).getCell(0).getStringCellValue();
			if(testcaseID.equalsIgnoreCase(tcID))
			{
				targetRowNo = i;
				break;
			}
		}
		
		targetRowNo--;
		int targetCellNo = 0;
		int lastCell = sheet.getRow(targetRowNo).getPhysicalNumberOfCells();
		for(int i=0;i<lastCell;i++)
		{
			String value = sheet.getRow(targetRowNo).getCell(i).getStringCellValue();
			
			if(value.equalsIgnoreCase(headerValue))
			{
				targetCellNo=i;
				break;
			}
		}
		
		
		return sheet.getRow(targetRowNo+1).getCell(targetCellNo).toString();
	}
}
