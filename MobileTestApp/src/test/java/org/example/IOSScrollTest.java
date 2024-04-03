package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSScrollTest extends IOSBaseTest{

    @Test
    public void iOSScrollTestDemo(){
    try {
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        // params.put("element", ((RemoteWebElement) ele).getId());
        driver.executeScript("mobile:scroll", params);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
        Thread.sleep(5000);


    }catch (Exception e) {
        e.printStackTrace();
    }
    }
}
