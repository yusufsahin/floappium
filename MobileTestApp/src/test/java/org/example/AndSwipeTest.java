package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndSwipeTest extends AndBaseTest {

    @Test
    public void AndSwipeTestDemo() {
        try {
           // accId Gallery
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
            WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
            Assertions.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
            swipeAction(firstImage,"left",0.75);
            Assertions.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
