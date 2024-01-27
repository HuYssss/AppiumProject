package Page.ActionBlockComponent;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddActionPage extends BasePage {
    public AddActionPage(AppiumDriver driver) {
        super(driver);
    }

    public void addNameDes(String name, String description) {
        By locator1 = By.id("com.arlosoft.macrodroid:id/actionBlockNameText");
        By locator2 = By.id("com.arlosoft.macrodroid:id/description");

        this._action.setText(locator1, name);
        this._action.setText(locator2, description);
    }

    public void addInputValue(String name) {
        By locator1 = By.id("com.arlosoft.macrodroid:id/addInputVariableButton");
        this._action.click(locator1);

        By locator2 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_dialog_name");
        this._action.setText(locator2, name);

        By locator3 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_type_spinner");
        this._action.click(locator3);

        By locator4 = By.id("android:id/text1");
        this._action.findElementByIndex(locator4, 0).click();
    }

    public void OK() {
        By locator = By.id("com.arlosoft.macrodroid:id/okButton");
        this._action.click(locator);
    }

    public void setInputValueTrue() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/inputCollapseExpandButton");
        this._action.click(locator1);

        By locator2 = By.id("com.arlosoft.macrodroid:id/topLevelContainer");
        this._action.click(locator2);

        By locator3 = By.id("com.arlosoft.macrodroid:id/trueRadio");
        this._action.click(locator3);
    }

    public void addAction() {
        By locator = By.id("com.arlosoft.macrodroid:id/addActionButton");
        this._action.click(locator);
    }

    public void addOutput() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/addOutputVariableButton");
        this._action.click(locator1);

        By locator2 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_dialog_name");
        this._action.setText(locator2, "This is a testing string");

        By locator3 = By.id("com.arlosoft.macrodroid:id/variable_new_variable_type_spinner");
        this._action.click(locator3);

        By locator4 = By.id("android:id/text1");
        this._action.findElementByIndex(locator4, 2).click();
    }

    public boolean verifyOutPut() {
        By locator1 = By.id("com.arlosoft.macrodroid:id/outputCollapseExpandButton");
        this._action.click(locator1);

        By locator2 = By.id("com.arlosoft.macrodroid:id/macro_edit_entry_name");
        String text = this._action.findElementByIndex(locator2, 2).getText();

        return text.equals("This is a testing string");
    }

    public void confirmInformation() {
        By locator = By.id("com.arlosoft.macrodroid:id/acceptButton");
        this._action.click(locator);
    }

    public boolean verifyActionBookName(String name) {
        By locator = By.id("com.arlosoft.macrodroid:id/name");
        WebElement element = this._action.findElementByIndex(locator, 0);
        return element.getText().equals(name);
    }
}
