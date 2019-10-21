package datadriventesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataDrivenTest_AddNewEmployees {
	
	@DataProvider(name="empDataProvider")
	String [][] getEmpData() throws IOException{
		//read data from excel
		String path = System.getProperty("user.dir") + "/src/test/java/datadriventesting/empdata.xlsx";
		
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		int colcount = ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String empdata[][] = new String[rownum][colcount];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; i<colcount; j++) {
				empdata[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		//String empdata_hardcoded[][] = { {"xyz123", "30000","40"}, {"abc123", "50000","25"}, {"Arish34", "70000","20"} };
		return empdata;
	}

}
