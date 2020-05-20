import readerFile.Xls_Reader;

public class dataManagement {

	public static void main(String[] args) {
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "//data.xlsx");
		//Xls_Reader xls = new Xls_Reader("D:\\New folder (2)\\Practise\\DataReading\\data.xlsx");
		
		String sheetName = "TestCases";
		String testName = "Testc";
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
		
		for(int rnum = dataStartRow; rnum < dataStartRow + rows ; rnum++)
		{
			for(int cnum = 0; cnum<cols; cnum++)
			{
				System.out.println(xls.getCellData(sheetName, cnum, rnum));
			}
		}
		
		
	}

}