import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


/**
 * Created by sc on 5/17/2017.
 */
public class ReadData {


    public Object[][] ReadExcelData(String FilePath,String sheetName) throws Exception {

        String[][] tabArray = null;
        //String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UserData.xls";
        //String sheetName =  "Sheet1" ;
        try {
            File f = new File(FilePath);
            Workbook workbook = Workbook.getWorkbook(f);
            Sheet sheet = workbook.getSheet(sheetName);


            // These are the total rows and total columns from Excel File
            //int totalRows = 0;
            //int totalCols = 0;

            //Getting the number of rows from Excel Sheet and printthem
            int RowCount = sheet.getRows();
          int ColCount = sheet.getColumns();

            //Initializing the Array
            tabArray = new String[RowCount - 1][ColCount];

            // Initializing Start Row and Start Column numbers where the data starts
            int startRow = 1;
            int startCol = 0;

            //Initializing RowPointer and Column pointer
            int PointerRow = 0;

            System.out.println("total cols = " + ColCount);
            System.out.println("total rows = " + RowCount);


            for (int i = startRow; i < RowCount; i++, PointerRow++) {
                int PointerColumn = 0;
                for (int j = startCol; j < ColCount; j++, PointerColumn++) {
                    tabArray[PointerRow][PointerColumn] = sheet.getCell(j, i).getContents();

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }catch(BiffException j){
            j.printStackTrace();
        }
        return (tabArray);

    }


    public static Object[][] giveBrowserstackPlatforms() throws ClassNotFoundException, SQLException {
        Object[][] giveBrowserstackPlatforms = new Object[1][3];
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/test";

        //Database Username
        String username = "root";

        //Database Password
        String password = "root";

        //Query to Execute
        String query = "select *  from platforms;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String os = rs.getString(1);
            String browser = rs.getString(2);
            String version = rs.getString(3);
            System.out.println(os);
            System.out.println(browser);
            System.out.println(version);

            giveBrowserstackPlatforms[0][0] = os;
            giveBrowserstackPlatforms[0][1] =browser;
            giveBrowserstackPlatforms[0][2] =version;

            //giveBrowserstackPlatforms[0][3] = "10";

        }
        // closing DB Connection
        con.close();


        //giveBrowserstackPlatforms[0][0] = os;
        //giveBrowserstackPlatforms[0][1] =browser;
        //giveBrowserstackPlatforms[0][2] =version;
        //giveBrowserstackPlatforms[0][3] = "10";

        return giveBrowserstackPlatforms;
    }


    //giveBrowserstackPlatforms[0][0] = "chrome";
    //giveBrowserstackPlatforms[0][1] ="58.0.3029.110";
    //giveBrowserstackPlatforms[0][2] ="Windows";
    //giveBrowserstackPlatforms[0][3] = "10";


}

