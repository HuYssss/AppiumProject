package Page;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MarcoPage extends BasePage {
    public MarcoPage(AppiumDriver driver) {
        super(driver);
    }

    public void addNewTrigger() {
        By locator = By.id("com.arlosoft.macrodroid:id/edit_macro_addTriggerButton");
        this._action.click(locator);
    }

    public void addNewActions() {
        By locator = By.id("com.arlosoft.macrodroid:id/edit_macro_addActionButton");
        this._action.click(locator);
    }

    public void addNewConstrains() {
        By locator = By.id("com.arlosoft.macrodroid:id/edit_macro_addConstraintButton");
        this._action.click(locator);
    }

    public void addNewVariable() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/varTitleLayout");
        this._action.click(locator1);

        By locator2 = By.id("com.arlosoft.macrodroid:id/addVariableButton");
        this._action.click(locator2);
    }
}
