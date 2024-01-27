package Page;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ActionsBlockPage extends BasePage {
    public ActionsBlockPage(AppiumDriver driver) {
        super(driver);
    }

    public void addNewActionBlock() {
        By locator = By.id("com.arlosoft.macrodroid:id/fab");
        this._action.click(locator);
    }
}
