package data;

import utilities.Xls_Reader;

public class DataFile {
	
	 Xls_Reader xl=new Xls_Reader("C:\\Users\\JAY SHRI KRISHNA\\Desktop\\Testing Class\\Projectfolder\\Selenium_Workspace\\BasicFrameWork59\\AkashTestData.xlsx");
	   
	 
	//login
	public String wrongEmail = xl.getCellData("Data1", "UserName",2);
	public String wrongPassword = xl.getCellData("Data1", "Password",2);
	public String emailWithSpecialChar = xl.getCellData("Data1", "UserName",5);
	public String globalErr =xl.getCellData("Data1", "Global Error",2);
	public String emptyEmailErr = xl.getCellData("Data1", "Email Error",4);
	public String emailWithSpecCharErr =  xl.getCellData("Data1", "Email Error",5);
	public String emptyPasswordErr=xl.getCellData("Data1", "Password Error", 3);
	

}
