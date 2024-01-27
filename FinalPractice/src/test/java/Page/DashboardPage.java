package Page;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    public DashboardPage(AppiumDriver driver) {
        super(driver);
    }

    public void navigateToMarco() {
        By locator = By.id("com.arlosoft.macrodroid:id/clickContainer");
        WebElement element = this._action.findElementByIndex(locator, 0);
        element.click();
    }

    public void navigateActionBlock() {
        By locator = By.id("com.arlosoft.macrodroid:id/clickContainer");
        WebElement element = this._action.findElementByIndex(locator, 3);
        element.click();
    }
}
