package org.example.Keyword;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;

public class ActionKeywords {
    public AppiumDriver _driver;
    public WebDriverWait _wait;
    public ActionKeywords(AppiumDriver driver){
        this._driver = driver;
        this._wait = new WebDriverWait(this._driver, Duration.ofSeconds(30));
    }

    public WebElement findElement(By locator){
        return this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        WebElement element = this.findElement(locator);
        element.click();
    }

    public void setText(By locator, String text){
        WebElement element = this.findElement(locator);
        try{
            element.clear();
            element.sendKeys(text);
        }
        catch (WebDriverException e){
            throw new WebDriverException("Element is not able to set text");
        }
    }

    public WebElement findElementByIndex(By locator, int index) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> elements = this._driver.findElements(locator);
        return this._wait.until(ExpectedConditions.elementToBeClickable(elements.get(index)));
    }

    public String getText(By locator) {
        WebElement element = this.findElement(locator);
        return element.getText();
    }

    public void scroll(int times, String options, By locator) {

        WebElement element = this.findElement(locator);

        int centerX = element.getRect().x + (element.getSize().width / 2);

        double startY = element.getRect().y + (element.getSize().height * 0.9);

        double endY = element.getRect().y + (element.getSize().height * 0.1);

        if (options.equals("up"))
        {
            double tmp = startY;
            startY = endY;
            endY = tmp;
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1);

        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), centerX, (int) startY));

        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));

        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), centerX, (int) endY));

        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        for (int i = 0 ; i < times ; i++)
            this._driver.perform(List.of(sequence));
    }
}
