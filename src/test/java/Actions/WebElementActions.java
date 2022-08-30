package Actions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class WebElementActions {

    private static WebElementActions instanceElement;

    public static synchronized WebElementActions getActions() {
        if (instanceElement == null) {
            instanceElement = new WebElementActions();
        }
        return instanceElement;
    }

    public  String readDataFromJsonFile(String fileName, String data) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {



            obj = parser.parse(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        return (String) jsonObject.get(data);
    }

    /**
     * Use this method to input text into text box, rich text box etc.
     *
     * @param element
     * @param text
     */
    public void inputText(WebElement element, String text) {

        WaitActions.getWaits().WaitUntilWebElementIsVisible(element);
        element.clear();
        element.sendKeys(text);

    }

    /**
     * Use this method to click on any clickable element. i.e. button
     *
     * @param element
     */
    public void clickElement(WebElement element) {

        WaitActions.getWaits().WaitUntilWebElementIsVisible(element);
        WaitActions.getWaits().waitForElementTobeClickable(element);
        element.click();

    }




}
