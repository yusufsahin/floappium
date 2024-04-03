package org.example.po;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.example.AndBaseTest;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
        //Home Page
        private By nameField= By.id("com.androidsample.generalstore:id/nameField");
        private By femaleRadioButton=By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']");
        private  By countryDropDown=By.id("android:id/text1");
        private By letsShopButton= By.id("com.androidsample.generalstore:id/btnLetsShop");
        private By addCart=By.xpath("//android.widget.TextView[@text='ADD TO CART']");
        private  By cartButton=By.id("com.androidsample.generalstore:id/appbar_btn_cart");

        public void fillForm(String name, String gender,String country) {
                driver.findElement(nameField).sendKeys(name);
                if ("female.".equalsIgnoreCase(gender)){
                        driver.findElement(femaleRadioButton).click();
                }
                selectCountry(country);
                driver.findElement(letsShopButton).click();
                addProductsToCart();
                navigateToCart();
        }

        private void selectCountry(String country) {
                driver.findElement(countryDropDown).click();
                String scrollCommand = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"));";
                driver.findElement(AppiumBy.androidUIAutomator(scrollCommand)).click();

        }

        private void addProductsToCart() {
                driver.findElements(addCart).get(0).click();
                driver.findElements(addCart).get(0).click();

        }

        private  void navigateToCart() {
                driver.findElement(cartButton).click();
        }
        public HomePage(AppiumDriver driver) {
                super(driver);
        }
}
