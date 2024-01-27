package Page.MarcoComponent;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class VariablesPage extends BasePage {
    public VariablesPage(AppiumDriver driver) {
        super(driver);
    }

    public void setVariables() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_dialog_name");
        this._action.setText(locator1, "Test Case");

        By locator2 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_type_spinner");
        this._action.click(locator2);

        By locator3 = By.id("android:id/text1");
        this._action.findElementByIndex(locator3, 1).click();
    }

    public void OK() {
        By locator4 = By.id("com.arlosoft.macrodroid:id/okButton");
        this._action.click(locator4);
    }

    public void setInputValue() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/topLevelContainer");
        this._action.findElementByIndex(locator1, 3).click();

        By locator2 = By.id("com.arlosoft.macrodroid:id/enter_variable_dialog_value");
        this._action.setText(locator2, "1");
    }

    public boolean verifyVariables() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_name");
        By locator2 = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_detail");

        String text1 = this._action.findElementByIndex(locator1, 3).getText();
        String text2 = this._action.findElementByIndex(locator2, 2).getText();

        return text1.equals("Test Case") && text2.equals("1");
    }
}