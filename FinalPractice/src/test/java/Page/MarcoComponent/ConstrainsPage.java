package Page.MarcoComponent;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConstrainsPage extends BasePage {
    public ConstrainsPage(AppiumDriver driver) {
        super(driver);
    }

    public void DeviceState() {
        By locator = By.id("com.arlosoft.macrodroid:id/category_container");
        WebElement element = this._action.findElementByIndex(locator, 3);
        element.click();
    }

    public void AirPlaneMode() {
        By locator = By.id("com.arlosoft.macrodroid:id/select_item_row_frame");
        WebElement element = this._action.findElementByIndex(locator, 1);
        element.click();
    }

    public void selectOptions(String options) {
        By locator = By.id("android:id/text1");
        int index = 0;

        if (options.equals("Airplane Mode Disabled"))
            index = 1;

        WebElement element = this._action.findElementByIndex(locator, index);
        element.click();
    }

    public void OK() {
        By locator = By.id("android:id/button1");
        this._action.click(locator);
    }

    public boolean verifyAddConstrains(String options) {
        By locator = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_name");
        WebElement element = this._action.findElementByIndex(locator, 2);
        String text = element.getText();
        this._config.updateProperty("result", text);
        return text.equals(options);
    }
}
