package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

public class AndScrollTest extends AndBaseTest {

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
