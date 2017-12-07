import org.testng.annotations.DataProvider;

public class Data_Provider {

    static String filePath="C:\\Users\\jesse\\IdeaProjects\\Em_Level3Homework9\\src\\main\\resources\\ReportFeed.xls";
    static String sheetName="ReportData";


   @DataProvider(name="reportData")
    public static Object[][] reportInput() throws Exception{
        ReadExcelSheet readExcelSheet = new ReadExcelSheet();
        Object[][] reportInput=readExcelSheet.getExcelContents(filePath,sheetName);
        return reportInput;
    }
}
