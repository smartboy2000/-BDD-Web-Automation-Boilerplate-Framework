package Actions;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class ContextActions {
    public PageObjectManager pageObjectManager;
    public BaseActions baseActions;



    public ContextActions() throws IOException {
        baseActions = new BaseActions();
        pageObjectManager = new PageObjectManager(baseActions.WebDriverManager());
    }

}
