package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class AndLongPress extends AndBaseTest {
    @Test
    public void AndLongPressTestDemo() {
        try {

            //Views
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            //android.widget.TextView[@content-desc='Expandable Lists']
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
            //1. Custom Adapter
            driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
            //android.widget.TextView[@text="People Names"]
            WebElement ele= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
            longPressAction(ele);

            String menuText= driver.findElement(AppiumBy.id("android:id/title")).getText();
            Assertions.assertEquals(menuText, "Sample menu");
            Assertions.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());

            //"Sample menu"

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}