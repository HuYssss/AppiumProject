package org.example.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.example.Configuration.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static AppiumDriver getDriver() throws MalformedURLException {
        Configuration _config = new Configuration("app.properties");

        File app = new File(_config.getProperty("apk"));

        DesiredCapabilities capabilities = setAndroidDriver(app);

        return new AndroidDriver(new URL("http", "127.0.0.1", 4723, "/wd/hub")
                , capabilities);
    }

    private static DesiredCapabilities setAndroidDriver(File app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.arlosoft.macrodroid");
        capabilities.setCapability("appWaitActivity", "com.arlosoft.macrodroid.intro.IntroActivity");

        return capabilities;
    }
}
