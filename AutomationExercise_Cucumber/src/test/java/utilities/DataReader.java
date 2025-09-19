package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader 
{
	
	public static List<HashMap<String, String>> data(String filepath, String sheetName) throws IOException
	{
		List<HashMap<String, String>> mydata=new ArrayList<HashMap<String, String>>();
		
		FileInputStream file=new FileInputStream(filepath); //open a file
		XSSFWorkbook workbook=new XSSFWorkbook(file); //open a work book
		XSSFSheet sheet=workbook.getSheet(sheetName); //open specific sheet		
		int totalRows=sheet.getLastRowNum(); //get the total rows
		
		XSSFRow headerRow=sheet.getRow(0); //get the first header row of the sheet
		
		for(int r=1; r<=totalRows; r++) //read each row from the sheet
		{
			XSSFRow currentRow=sheet.getRow(r);
			
			HashMap<String, String> map=new HashMap<String, String>();
			
			for(int c=0; c<currentRow.getLastCellNum(); c++)
			{
				XSSFCell currentCell=currentRow.getCell(c);
				map.put(headerRow.getCell(c).toString(), currentCell.toString());
			}
			
			mydata.add(map);
			
		}
		
		file.close();
		
		return mydata;
	}

}
