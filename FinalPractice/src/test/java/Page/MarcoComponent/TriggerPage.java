package Page.MarcoComponent;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TriggerPage extends BasePage {
    public TriggerPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickApplication() {
        By locator = By.id("com.arlosoft.macrodroid:id/category_container");
        WebElement element = this._action.findElementByIndex(locator, 0);
        element.click();
    }

    public void clickInsReUpdate() {
        By locator = By.id("com.arlosoft.macrodroid:id/select_item_row_frame");
        WebElement element = this._action.findElementByIndex(locator, 0);
        element.click();
    }

    public void selectOptions(String options) {
        By locator = By.id("android:id/text1");
        int index = 0;

        switch (options) {
            case "Application Updated" -> {
                index = 1;
            }
            case "Application Removed" -> {
                index = 2;
            }
            default -> {}
        }

        WebElement element = this._action.findElementByIndex(locator, index);
        element.click();
    }

    public void selectAnyApp() {
        By locator = By.id("android:id/text1");
        WebElement element = this._action.findElementByIndex(locator, 0);
        element.click();
    }

    public void clickOK() {
        By locator = By.id("android:id/button1");
        this._action.click(locator);
    }

    public boolean verifyAddTrigger(String options) {
        By locator = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_name");
        WebElement element = this._action.findElementByIndex(locator, 0);
        String text = element.getText();
        return text.equals(options);
    }
}
