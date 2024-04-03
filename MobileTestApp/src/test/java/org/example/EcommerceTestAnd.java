package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EcommerceTestAnd extends AndBaseTest {

    @Test
    public void EcommerceFillFormTest() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jane Doe");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        List<WebElement> productPrices= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count= productPrices.size();
        double totalSum=0;
        for (int i= 0; i < count; i++) {
            String amountString= productPrices.get(i).getText();
            Double price= getFormattedAmount(amountString);
            totalSum=totalSum+price;
        }
        String displaySum= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum= getFormattedAmount(displaySum);
        Assertions.assertEquals(totalSum,displayFormattedSum);
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

    }


}
