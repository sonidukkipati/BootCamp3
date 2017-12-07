package TestResources;

import Bidqapages.LoginPage;
import Bidqapages.PostNewProject;
import org.openqa.selenium.WebDriver;

/**
 * Created by sc on 5/15/2017.
 */
public class PageResources {
    WebDriver dr;

    public LoginPage getLoginPage() {
        return loginPage;
    }

    private LoginPage loginPage;

    public PostNewProject getPostNewProject() {
        return postNewProject;
    }

    private PostNewProject postNewProject;



   public PageResources(WebDriver dr) {
        this.dr = dr;
        loginPage = new LoginPage(dr);
        postNewProject = new PostNewProject(dr);

    }


}
