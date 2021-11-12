package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String Excelpath) throws IOException
	{
		try {
			File src=new File(Excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
    public String getData(int sheetno,int row,int column)
    {
     sheet1 = wb.getSheetAt(sheetno);
     
    String data = sheet1.getRow(row).getCell(column).getStringCellValue();
    return data;
    }
    
    public int getRow(int sheetindex)
    {
          int row = wb.getSheetAt(sheetindex).getLastRowNum();
          row=row+1;
          return row;
    }
	
	
}
