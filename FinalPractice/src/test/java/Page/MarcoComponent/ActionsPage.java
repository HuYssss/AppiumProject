package Page.MarcoComponent;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActionsPage extends BasePage {
    public ActionsPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickLogging() {
        By locator = By.id("com.arlosoft.macrodroid:id/background");
        WebElement element = this._action.findElementByIndex(locator, 9);
        element.click();
    }

    public void clickClearLog() {
        By locator = By.id("com.arlosoft.macrodroid:id/container");
        WebElement element = this._action.findElementByIndex(locator, 1);
        element.click();
    }

    public void selectOption(String options) {
        By locator = By.id("android:id/text1");
        int index = 0;

        if (options.equals("System Log"))
            index = 1;

        WebElement element = this._action.findElementByIndex(locator, index);
        element.click();
    }

    public void clickOK() {
        By locator = By.id("android:id/button1");
        this._action.click(locator);
    }

    public boolean verifyAddActions(String options) {
        By locator = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_detail");
        WebElement element = this._action.findElementByIndex(locator, 1);
        String text = element.getText();
        return text.equals(options);
    }
}
