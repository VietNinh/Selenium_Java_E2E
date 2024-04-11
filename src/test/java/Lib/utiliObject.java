//package Lib;
//
//import com.codoid.products.exception.FilloException;
//import com.codoid.products.fillo.Connection;
//import com.codoid.products.fillo.Fillo;
//import com.codoid.products.fillo.Recordset;
//import org.testng.ITestContext;
//import org.testng.annotations.DataProvider;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Properties;
//
//public class utiliObject {
//
//	@DataProvider(name ="readdata")
//	public void Hashtable readExcelDatabase() throws FilloException {
////		Recordset rsData = null;
//		Hashtable htData = new Hashtable();
//		Fillo fillo = new Fillo();
////		String sTestCaseName = context.getCurrentXmlTest().getName();
////		String sSheetName = context.getCurrentXmlTest().getParameter("dataSheet");
////		String dataFile = context.getCurrentXmlTest().getTestParameters().get("dataFile").toString();
//
//		String pathData = System.getProperty("user.dir")+"\\test\\java\\testdata\\login.xlsx";
//		Connection connection = fillo.getConnection(pathData);
//		String sQuery = "";
//		sQuery = "Select * from LoginPage where Testcase_ID='login_Incorrect_Pass' and Execute='Yes'";
////		sQuery = "Select * from " + sSheetName + " where Testcase_ID='" + sTestCaseName
////				+ "' and TExecute='Yes'";
//		Recordset rsData = connection.executeQuery(sQuery);
//		List<String> fieldNames = rsData.getFieldNames();
//		for (int i =0;i<fieldNames.size();i++){
//			htData.put(fieldNames.get(i),rsData.getField(fieldNames.get(i)));
//		}
//		return htData;
//	}
//
//	public Hashtable readdata() throws FilloException {
//		System.out.println("Into readdata Method");
//		utiliObject util = new utiliObject();
//		ITestContext context = null;
//		Hashtable htData = util.readExcelDatabase();
////		Hashtable htData =null;
//		return htData;
//	}
//
//	public String readPropertiesData(String key) throws IOException {
//		String value="";
//		Properties properties = new Properties();
//		FileInputStream fis = new FileInputStream("D:\\Project\\workSpace\\E2EProject\\src\\test\\java\\data\\config.properties");
//		properties.load(fis);
//		value = properties.getProperty(key);
//		return value;
//	}
//
//}
