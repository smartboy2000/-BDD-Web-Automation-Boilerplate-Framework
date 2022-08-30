package PageObjects;

import Actions.WaitActions;
import Actions.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Actions.BaseActions.driver;

public class DemoFormPage {

    @FindBy(id ="firstName")
    WebElement first_name;

    @FindBy(id ="lastName")
    WebElement last_name;

    @FindBy(id ="userEmail")
    WebElement email;

    @FindBy(id ="userNumber")
    WebElement mobile_number;

    @FindBy(xpath = "//label[contains(.,'Male')]")
    WebElement gender;

    @FindBy(xpath = "//label[contains(.,'Music')]")
    WebElement hobby;

    @FindBy(id = "subjectsInput")
    WebElement subject;

    @FindBy(id = "currentAddress")
    WebElement current_address;


    /*
     * Enter First Name
     *
     */
    public void enterFirstName(String fname) {
        PageFactory.initElements(driver, this);
        WebElementActions.getActions().inputText(first_name,fname);
    }

    /*
     * Enter Last Name
     *
     */
    public void enterLastName(String lname) {
        WebElementActions.getActions().inputText(last_name,lname);
    }

    /*
     * Enter Email
     *
     */
    public void enterEmail(String emailValue) {
        WebElementActions.getActions().inputText(email,emailValue);
    }

    /*
     * Choose Gender
     *
     */
    public void chooseGender() {
        WebElementActions.getActions().clickElement(gender);
    }

    /*
     * Enter Mobile Number
     *
     */
    public void enterMobileNum(String mobileNumber) {
        WebElementActions.getActions().inputText(mobile_number,mobileNumber);
    }

    /*
     * Enter Subject
     *
     */
    public void enterSubject(String subjectName) {
        WebElementActions.getActions().inputText(subject,subjectName);
        subject.sendKeys(Keys.ENTER);
    }

    /*
     * Choose Hobby
     *
     */
    public void chooseHobby() {
        WaitActions.getWaits().scrollElementTillView(current_address);
        WebElementActions.getActions().clickElement(hobby);
    }

    /*
     * Enter Current Address
     *
     */
    public void enterAddress(String address) {
        WaitActions.getWaits().scrollElementTillView(current_address);
        WebElementActions.getActions().inputText(current_address,address);
    }

    /*
     * Navigate to Different Page/Url
     *
     */
    public void navigateToDifferentPage(String url){
        driver.navigate().to(url);
    }

}
