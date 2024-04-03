package org.example.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.AndBaseTest;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage extends AndBaseTest {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
