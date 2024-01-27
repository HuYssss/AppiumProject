package Page;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage {
    public StartPage(AppiumDriver driver) {
        super(driver);
    }

    public void skipIntro() {
        By locator = By.id("com.arlosoft.macrodroid:id/button_next");
        for (int i = 0 ; i < 4 ; i++)
            this._action.click(locator);
    }

    public void skipIntro2() {
        By locator = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
        this._action.click(locator);
    }
}
