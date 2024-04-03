package org.example.po;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class CartPage extends BasePage{

    private  By productPrice = By.id("com.androidsample.generalstore:id/productPrice");
    private By toolBarTitle= By.id("com.androidsample.generalstore:id/toolbar_title");
    private By totalAmountLabel=By.id("com.androidsample.generalstore:id/totalAmountLbl");
    private  By checkBox= AppiumBy.className("android.widget.CheckBox");

    private By proceedButton= By.id("com.androidsample.generalstore:id/btnProceed");
    public CartPage(AppiumDriver driver) {
        super(driver);
    }
    public double calcutalateTotalSum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(toolBarTitle),"text","Cart"));
        List<WebElement> productPrices= driver.findElements(productPrice);
        int count= productPrices.size();
        double totalSum=0;
        for (int i= 0; i < count; i++) {
            String amountString= productPrices.get(i).getText();
            Double price= getFormattedAmount(amountString);
            totalSum=totalSum+price;
        }
        return totalSum;
    }

    public double getDislayedTotalAmount() {
        String displaySum= driver.findElement(totalAmountLabel).getText();
        return Double.parseDouble(displaySum.substring(1));
    }
    public void proceedToCheckout() {
        //Cart Page
        driver.findElement(checkBox).click();
        driver.findElement(proceedButton).click();
    }
}
