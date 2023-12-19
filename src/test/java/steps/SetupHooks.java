package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class SetupHooks {
    @Before
    public void setUp() throws MalformedURLException {
        DriverFactory.startAppiumServer();
    }

    @After
    public void tearDown() {
        DriverFactory.stopAppiumServer();
    }

}
