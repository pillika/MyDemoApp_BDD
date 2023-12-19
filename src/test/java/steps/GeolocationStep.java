package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;

import java.time.Duration;

import static Utils.Waiter.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;

public class GeolocationStep {
    @When("user sets access to the device's location by clicking {string}")
    public void userAllowsTheAccessToTheDeviceSLocation(String buttonText) {
        WebElement access = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_" + buttonText));
        waitForElementVisibility(driver, access, DEFAULT_DURATION);
        access.click();

    }

    @Then("user retrieves the accurate geolocation")
    public void userRetrievesTheAccurateGeolocationLangituteAndLongitude() throws InterruptedException {
        Thread.sleep(2000);

        String latitudea = driver.findElement(AppiumBy.accessibilityId("latitude data")).getText();
        String longitudea = driver.findElement(AppiumBy.accessibilityId("longitude data")).getText();
        assertEquals(Double.parseDouble(latitudea), driver.location().getLatitude());
        assertEquals(Double.parseDouble(longitudea), driver.location().getLongitude());
    }

    @And("latitude {string} and longitude {string} are displayed")
    public void latitudeAndLogitudeAreDisplayed(String latitudeDate, String longitudeData) {
        justWait(driver, DEFAULT_DURATION);
        String latitude = driver.findElement(AppiumBy.accessibilityId("latitude data")).getText();
        String longitude = driver.findElement(AppiumBy.accessibilityId("longitude data")).getText();
        assertEquals(latitude, latitudeDate);
        assertEquals(longitude, longitudeData);
    }

    @Then("user sees the permission controller popup again")
    public void userSeenThePermissionControllerPopupAgain() {
        WebElement popup = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/grant_dialog"));
        waitForElementVisibility(driver, popup, DEFAULT_DURATION);
        assertTrue(popup.isDisplayed());
    }

    @When("user quits the My Demo App and opens it again")
    public void userQuitsTheMyDemoAppAndOpensItAgain() {
        String appId = (String) driver.getCapabilities().getCapability("appPackage");

        driver.terminateApp(appId, new AndroidTerminateApplicationOptions().withTimeout(Duration.ofSeconds(7)));
        driver.activateApp(appId);
//        String appPackage = "com.saucelabs.mydemoapp.rn";
//        String appActivity = "com.saucelabs.mydemoapp.rn.MainActivity";
//        Activity activity = new Activity(appPackage, appActivity);
//        driver.startActivity(activity);
    }

    @When("the location is mocked: latitude {string}, longitude {string}")
    public void theLocationIsMockedLatitudeLongitude(String latitude, String longitude) {
        driver.setLocation(new Location(
                Double.parseDouble(latitude),
                Double.parseDouble(longitude),
                11.1212121
        ));
    }
}
