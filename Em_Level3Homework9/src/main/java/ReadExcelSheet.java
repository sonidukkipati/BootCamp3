import jxl.JXLException;
import jxl.Workbook;
import  jxl.Sheet;
import jxl.read.biff.BiffException;
import java.io.File;
import java.io.IOException;

public class ReadExcelSheet {

   /* public static void main(String args[]) throws Exception
    {
        getExcelContents("C:\\Users\\jesse\\IdeaProjects\\Em_Level3Homework9\\src\\main\\resources\\ReportFeed.xls","ReportData");
    }*/

   // static Object[][] reportData ;
    public  static Object[][] getExcelContents(String filePath, String sheetName) throws Exception{
        String[][] reportData= null ;
        try {

            File f = new File(filePath);
            Workbook wb = Workbook.getWorkbook(f);
            Sheet sheet = wb.getSheet(sheetName);
            int rowCount = sheet.getRows();
            int colCount = sheet.getColumns();
            int arrayPointerRow, arrayPointerCol;

            //initialize size of reportData
            reportData = new String[rowCount-1][colCount];
            //Data starts in row 1
            int initRow = 1;
            //Data starts in column 0
            int initCol = 0;

            // initialize the pointers to reportData[][]

            arrayPointerRow = 0;


            for (int i = initRow; i < rowCount; i++, arrayPointerRow++) {
                arrayPointerCol = 0;

                for (int j = initCol; j < colCount; j++, arrayPointerCol++) {
                    reportData[arrayPointerRow][arrayPointerCol] = sheet.getCell(j, i).getContents();
                    //System.out.println("Data from Excel File "+arrayPointerRow+ " "+arrayPointerCol+ " data = "+reportData[arrayPointerRow][arrayPointerCol]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (BiffException j) {
            j.printStackTrace();
        }
        return reportData;

    }
}

