package Base;

import io.appium.java_client.AppiumDriver;
import org.example.Configuration.Configuration;
import org.example.Keyword.ActionKeywords;

public class BasePage {
    public AppiumDriver _driver;
    public Configuration _config;
    public ActionKeywords _action;

    public BasePage(AppiumDriver driver){
        this._driver = driver;
        this._config = new Configuration("app.properties");
        this._action = new ActionKeywords(this._driver);
    }
}
