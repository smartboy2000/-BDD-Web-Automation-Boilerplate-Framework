package StepDefinitions;

import java.io.File;
import java.io.IOException;
import Actions.ContextActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;


public class Hooks {

    ContextActions contextActions;

    public Hooks(ContextActions testContextSetup)
    {

        this.contextActions = testContextSetup;
    }
    @After
    public void AfterScenario() throws IOException
    {

        contextActions.baseActions.WebDriverManager().quit();

    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException
    {
        WebDriver driver =contextActions.baseActions.WebDriverManager();
        if(scenario.isFailed() || !scenario.isFailed())
        {
            //screenshot
            File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }

}
