package org.cts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static void load(String s){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sM\\eclipse-workspace\\venkii\\Sample\\driver\\chromedriver.exe" );
	    driver=new ChromeDriver();
		driver.get(s);
		
	}
	public static void fill(WebElement e,String s) {
		e.sendKeys(s);

	}
	public static String getData(int ro,int ce) throws Exception {
		File loc=new File("C:\\Users\\sM\\eclipse-workspace\\venkii\\Sample\\Excel\\New Microsoft Excel Worksheet.xlsx");
		FileInputStream stream=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
	
			Row r = s.getRow(ro);
			Cell c = r.getCell(ce);
				int type = c.getCellType();
				String name=null;
				if(type==1) {
					 name = c.getStringCellValue();
					
					
				}
				else {
					if(DateUtil.isCellDateFormatted(c)) {
						Date dateCellValue = c.getDateCellValue();
						SimpleDateFormat sim=new SimpleDateFormat("dd-mmm-yy");
						name = sim.format(dateCellValue);
						
					}
					else {
						double numericCellValue = c.getNumericCellValue();
						long l=(long)numericCellValue;
						name = String.valueOf(l);
						
					}
				}
				return name;

	}

}
