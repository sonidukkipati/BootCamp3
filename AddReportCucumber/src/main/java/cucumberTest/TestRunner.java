package cucumberTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.junit.*;
import gherkin.formatter.model.Feature;
import org.junit.runner.RunWith;


/**
 * Created by sc on 6/7/2017.
 */



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features= "src/main/Feature/AddReport.feature"
            ,glue={"stepDefinition"}

    )
public class TestRunner{
}
