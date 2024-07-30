package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		String path=".\\testdata\\Opencart_LoginData.xlsx";
		ExcelUtility ex=new ExcelUtility(path);
		int rows=ex.getRowCount("sheet1");
		int cells=ex.getCellCount("sheet1",1);
		String [][] data=new String[rows][cells];
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cells;j++) {
				data[i-1][j]=ex.getCellData("sheet1",i, j);
			}
		}
		return data;
	}
		//DataProvider 2
	
		//DataProvider 3
		
		//DataProvider 4

}
