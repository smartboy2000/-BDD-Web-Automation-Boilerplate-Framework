package StepDefinitions;
import PageObjects.DemoFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.List;

public class DemoFormSteps {

    public DemoFormPage demoFormPage;
    List<List<String>> data;

    @Given("User is on Demo Form Page")
    public void UserOnDemoPage() {
        demoFormPage = new DemoFormPage();
    }

    @When("User Enter Firstname & Lastname")
    public void EnterFistNameLastName(DataTable pageDetails) {
        data = pageDetails.asLists();
        demoFormPage.enterFirstName(data.get(1).get(0));
        demoFormPage.enterLastName(data.get(1).get(1));
    }

    @And("User Enter Email")
    public void EnterEmail(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.enterEmail(data.get(1).get(0));
    }

    @And("User Select Gender")
    public void ChooseGender()
    {
        demoFormPage.chooseGender();
    }

    @And("User Enter Mobile Number")
    public void EnterMobileNumber(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.enterMobileNum(data.get(1).get(0));
    }

    @And("User Enter Subject")
    public void EnterSubject(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.enterSubject(data.get(1).get(0));
    }

    @And("User Choose Hobby")
    public void ChooseHobby()
    {
        demoFormPage.chooseHobby();
    }

    @And("User Enter Address")
    public void EnterAddress(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.enterAddress(data.get(1).get(0));
    }

    @And("User navigate to second page")
    public void NavigateToSecondPage(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.navigateToDifferentPage(data.get(1).get(0));
    }

    @And("User navigate to third page")
    public void NavigateToThirdPage(DataTable pageDetails)
    {
        data = pageDetails.asLists();
        demoFormPage.navigateToDifferentPage(data.get(1).get(0));
    }

}
