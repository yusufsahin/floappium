package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AppiumBasic extends AndBaseTest {

    @Test
    public  void  MainTest()   {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();



        if(!driver.findElement(By.id("android:id/checkbox")).isSelected()){
            driver.findElement(By.id("android:id/checkbox")).click();
        }
        driver.findElement(By.xpath
                ("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assertions.assertEquals(alertTitle,"WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Mercury Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
