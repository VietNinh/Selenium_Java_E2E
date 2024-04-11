package Lib;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class DataDriven {
@Test
    public void abc() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Project\\workSpace\\E2EProject\\src\\test\\java\\data\\testdata\\EP.xlsx");
        Hashtable testData = new Hashtable<>();
        List<String> titles = new ArrayList<String>();
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        int sheets = workBook.getNumberOfSheets();
        for (int i = 0; i < sheets;i++){
            if (workBook.getSheetName(i).equals("SMS_Processors")){
                XSSFSheet sheet = workBook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int colum=0;
                int count = 0;
                while (ce.hasNext()){
                    Cell value = ce.next();
                    String title = value.getStringCellValue();

                    titles.add(title);
                    if (title.equalsIgnoreCase("Testcase_ID")){
                        colum = count;
                    }
                        count++;
                }

                while (rows.hasNext()){
                    Row r = rows.next();
                    if (r.getCell(colum).getStringCellValue().equalsIgnoreCase("Add_EP_SMS_Processor")){
                        Iterator<Cell> cv = r.cellIterator();
                        int a=0;
                        while (cv.hasNext()){
                            String value = cv.next().getStringCellValue().trim();
                            String key =titles.get(a).trim();
                            testData.put(key,value);
                            a++;
                        }
                        break;
                    }

                }
                break;
            }
        }
        System.out.println("Name: "+testData.get("Name").toString());
        System.out.println("Mode: "+testData.get("Mode").toString());
        System.out.println("Descroption: "+testData.get("Description").toString());
    }

    public void readExcelDatabase() throws IOException, FilloException {
        System.out.println();
        Fillo fillo = new Fillo();
        Connection conn = fillo.getConnection("D:\\Project\\workSpace\\E2EProject\\src\\test\\java\\data\\testdata\\EP.xlsx");

        String query = "Select * from  SMS_Processors";
        Recordset rsData = null;
        rsData = conn.executeQuery(query);
        int rowCount = rsData.getCount();
        Hashtable htRow = new Hashtable(rowCount);

        ArrayList<String> rsmd = rsData.getFieldNames();
        int columCount = rsmd.size();



        FileInputStream fis = new FileInputStream("D:\\Project\\workSpace\\E2EProject\\src\\test\\java\\data\\testdata\\EP.xlsx");
        Hashtable testData = new Hashtable<>();
        List<String> titles = new ArrayList<String>();
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        int sheets = workBook.getNumberOfSheets();
        for (int i = 0; i < sheets;i++){
            if (workBook.getSheetName(i).equals("SMS_Processors")){
                XSSFSheet sheet = workBook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int colum=0;
                int count = 0;
                while (ce.hasNext()){
                    Cell value = ce.next();
                    String title = value.getStringCellValue();
                    titles.add(title);
                    if (title.equalsIgnoreCase("Testcase_ID")){
                        colum = count;
                    }
                    count++;
                }

                while (rows.hasNext()){
                    Row r = rows.next();
                    if (r.getCell(colum).getStringCellValue().equalsIgnoreCase("Add_EP_SMS_Processor")){
                        Iterator<Cell> cv = r.cellIterator();
                        int a=0;
                        while (cv.hasNext()){
                            String value = cv.next().getStringCellValue().trim();
                            String key =titles.get(a).trim();
                            testData.put(key,value);
                            a++;
                        }
                        break;
                    }

                }
                break;
            }
        }
        System.out.println("Name: "+testData.get("Name").toString());
        System.out.println("Mode: "+testData.get("Mode").toString());
        System.out.println("Descroption: "+testData.get("Description").toString());
    }
}
