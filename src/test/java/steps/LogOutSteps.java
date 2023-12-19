package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.*;
import static steps.DriverFactory.driver;

public class LogOutSteps {

    @Given("User is navigated to {string} Page using sidemenu")
    public void userIsOnPage(String page) {
        WebElement sideMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        sideMenu.click();
        WebElement pageName = driver.findElement(AppiumBy.androidUIAutomator("text(\""+page+"\")"));
        pageName.click();
    }

    @When("clicking menu button")
    public void clickingMenuButton() {
        WebElement sideMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        sideMenu.click();
    }

    @Then("menu option {string} is visible")
    public void menuOptionLogOutIsVisible(String text) {
        WebElement textButton = driver.findElement(AppiumBy.androidUIAutomator("text(\""+text+"\")"));
        assertTrue(textButton.isDisplayed());
    }

       @Then("popup with a message {string} appears")
    public void popupWithAMessageAppears(String text) {
        WebElement alertMessage = driver.findElement(AppiumBy.id("android:id/message"));
        assertEquals(alertMessage.getText(), text);
    }

    @When("user clicks {string} button")
    public void userClicksButton(String name) {
        WebElement button = driver.findElement(AppiumBy.id("android:id/button1"));
        button.click();
    }

    @Then("popup with a message title {string} appears")
    public void popupWithAMessageYouAreSuccessfullyLoggedOut(String text) {
        WebElement alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle"));
        assertEquals(alertTitle.getText(), text);
    }

    @Then("Message popup closes")
    public void messagePopupCloses() {
         assertEquals(driver.findElements(AppiumBy.id("android:id/parentPanel")).size(), 0);
    }

    @And("user is navigated to {string} page")
    public void userIsAutoRedirectedToLoginPage(String pageName) {
        WebElement usernameInput = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"container header\"]/android.widget.TextView"));
         assertEquals(usernameInput.getText(),pageName);
          }

    @When("user clicks Cancel")
    public void userClicks() {
        WebElement cancel = driver.findElement(AppiumBy.id("android:id/button2"));
        cancel.click();
    }

    @And("user is still loged in")
    public void userIsStillLogedIn() {
        assertEquals(driver.findElements(AppiumBy.accessibilityId("Username input field")).size(),0);
       assertEquals(driver.findElements(AppiumBy.accessibilityId("Password input field")).size(),0);
    }
}
