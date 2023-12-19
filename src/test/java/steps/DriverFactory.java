package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    public static AndroidDriver driver;

    public static void startAppiumServer() throws MalformedURLException {
//        if (driver == null) {
//            AppiumServiceBuilder builder = new AppiumServiceBuilder();
//            builder.withIPAddress("127.0.0.1")
//                    .usingPort(4723)
//                    .withAppiumJS(new File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
//                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//                    .withArgument(BASEPATH, "/wd/hub");
//
//            AppiumDriverLocalService.buildService(builder).start();
//        }

        UiAutomator2Options options = new UiAutomator2Options()
//                .setDeviceName("Ugne A21s")
//                .setUdid("R58NA0C07VL")
                .setUdid("32091JEHN03378")
                .setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setPlatformName("Android")
                .setPlatformVersion("14");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stopAppiumServer() {
        if (driver != null) {
            driver.quit();
        }

    }
}
