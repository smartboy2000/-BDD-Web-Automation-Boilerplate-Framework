package Actions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


public class WaitActions extends BaseActions {

    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;
    private static WaitActions instance;


    public WaitActions() throws IOException {
        this.wait = new WebDriverWait(driver, 15);
        jsExecutor = ((JavascriptExecutor) driver);


    }

    public static synchronized WaitActions getWaits() {
        if (instance == null) {
            try {
                instance = new WaitActions();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    /**
     * wait for webElement visible
     *
     * @param element
     * @return
     */
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            Thread.sleep(1000);
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }


    /**
     * wait for web List Element
     *
     * @param element
     * @return
     */
    public boolean WaitUntilWebElementIsVisible(List<WebElement>element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfAllElements(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * wait for element clickable
     *
     * @param element
     * @return
     */
    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }

    /**
     * wait for element to be clickable
     *
     * @param element
     * @return
     */
    public boolean waitForElementTobeClickable(WebElement element) {
        long explicitWaitDefault = 120;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            new WebDriverWait(driver, explicitWaitDefault)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Can not wait till element click");
        }
        return false;
    }

    /**
     * Page load time out using javascript
     */
    public void pageLoadTimeOutUsingJavaScript() {
        WebDriverWait jsWait = new WebDriverWait(driver, 60);
        jsWait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Wait for loader with list web element
     * @param element
     */
    public void loadingWait(WebElement element) {
        try {
            WebDriverWait loadWait = new WebDriverWait(driver, 12);
            WaitUntilWebElementIsVisible(element);
            loadWait.until(ExpectedConditions.invisibilityOf(element)); // wait for loader to disappear
        }catch (Exception e){}

    }

    /**
     * Scroll Till Element
     * @param element
     */
    public void scrollElementTillView(WebElement element){
        WaitUntilWebElementIsVisible(element);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * click Using Javascript
     * @param element
     */
    public void clickUsingJS(WebElement element){
        WaitUntilWebElementIsVisible(element);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
        jsExecutor.executeScript("arguments[0].click();",element);
    }
}
