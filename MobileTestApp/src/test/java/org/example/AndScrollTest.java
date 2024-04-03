package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AndScrollTest extends BaseTest{

    @Test
    public void AndScrollTestDemo(){
        try {
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            // scrollIntoView to WebView
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
            //Views
            //new UiSelector().text("Views")
            driver.navigate().back();
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            scrollToEndAction();
            driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}
