import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readerFile.Xls_Reader;

public class dynamicDataReading {
	
	@Test(dataProvider = "getData")
	public void data(Hashtable<String, String> data)
	{
		System.out.println(data.get("Runmode") +"---------"+ data.get("Col1")+"---------"+ data.get("Col2")+"---------"+ data.get("Col3"));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "//data.xlsx");
		
		String sheetName = "TestCases";
		String testName = "TestA";
		int startTestRow = 1;
		while(!testName.equalsIgnoreCase(xls.getCellData(sheetName, 0, startTestRow)))
		{
			startTestRow ++;
		}
		
		System.out.println(startTestRow);
		
		int colStartRow = startTestRow + 1;
		int dataStartRow = startTestRow + 2;
		
		int rows = 0;
		while(!xls.getCellData(sheetName, 0, dataStartRow+rows).equals(""))
		{
			rows++;
		}
		
		System.out.println("rows are  ->"+rows);
		
		int cols = 0;
		while(!xls.getCellData(sheetName, cols, dataStartRow).equals(""))
		{
			cols++;
		}
		
		System.out.println("cols are "+cols);
		
		Hashtable<String, String> table = null;
		Object[][] data = new Object[rows][1];
		int datarow = 0;
		
		for(int rnum = dataStartRow; rnum < dataStartRow + rows ; rnum++)
		{
			table = new Hashtable<String, String>();
			for(int cnum = 0; cnum<cols; cnum++)
			{
				String key = xls.getCellData(sheetName, cnum, colStartRow);
				String value = xls.getCellData(sheetName, cnum, rnum);
				table.put(key, value);
			}
			data[datarow][0]=table;
			datarow++;
		}
		return data;
	}

}
