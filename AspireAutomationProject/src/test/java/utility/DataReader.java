package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class DataReader 
{
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public void dataReading(String path) throws Exception
	{
		File f=new File("");
		FileInputStream fis=new FileInputStream(f);
		wb=new HSSFWorkbook(fis);
		
	}
}
