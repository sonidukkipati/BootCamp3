package TestResources;

import Pages.AddReport;
import Pages.LoginPage;
import Pages.LogoutPage;
import org.openqa.selenium.WebDriver;


public class PageResources {

    private LoginPage loginPage;
    private AddReport addReport;
    private LogoutPage logoutPage;

    public PageResources(WebDriver driver) {
        loginPage = new LoginPage();
        loginPage.LoginPage(driver);

        addReport = new AddReport(driver);

    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AddReport getAddReport() {
        return addReport;
    }

    public LogoutPage getLogoutPage() {
        return logoutPage;
    }


}