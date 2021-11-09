package com.qa.zerobank.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.zerobank.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") +
			"\\src\\test\\java\\com\\qa\\zerobank\\testdata\\" + 
			prop.getProperty("testdata");

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	Connection con;
	
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
	public void switchToFrame(String framename){
		driver.switchTo().frame(framename);
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String homeDir = System.getProperty("user.dir");		
		FileUtils.copyFile(scrFile, new File(homeDir + "/screenshots/HomePage" + System.currentTimeMillis() + ".png"));
		
		}
	
	
	
	public void executeExeFile(String fileName) {
		try {
			
			Runtime.getRuntime().exec(fileName);
			//Example -
			//Runtime.getRuntime().exec("C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeJavaScript(String jsQery) {
		js = (JavascriptExecutor) driver;
		js.executeScript(jsQery);
		//Examples
		//js.executeScript(“document.getElementByID(‘element id ’).checked=false;”);
		//js.executeScript(“location.reload()”);
		//js.executeScript(“document.getElementByID(‘element id ’).value = ‘xyz’;”);
		
	}
	
	
	public Connection createDBConnection() throws ClassNotFoundException, SQLException{
		//load driver jar class
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("MySQL connection Driver loaded");
		//Create connection
		con = DriverManager.getConnection(
				"jdbc:mysql://" + prop.getProperty("dbhost") + ":" +prop.getProperty("port")+"/"+ prop.getProperty("dbname"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
		System.out.println("Connected to MySQL DB");
		
		return con;
	}
	
	
	
	public ResultSet executeDBQuery(Connection con, String query) throws SQLException{
		
		//create statement
		Statement smt = con.createStatement();
		
		//execute query
		ResultSet rs = smt.executeQuery(query);
		//System.out.println(rs);
		
//		//run through each row of result for a column
//		while(rs.next())
//		{
//			String cityname = rs.getString("Name");
//			System.out.println("City name is " + cityname);
//		}
		
		
		return rs;

	}
	
	public void closeConnection(Connection con) throws SQLException{
		//close the connection
		con.close();
	}
	
	
}
