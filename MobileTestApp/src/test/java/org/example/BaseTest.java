package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    @BeforeEach
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {
         service= new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();

        service.start();

        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");

        //options.setDeviceName("vivo v2204");
        options.setApp("//Users//yusufsahin//Projects//floappium//MobileTestApp//src//test//resources//ApiDemos-debug.apk");

        driver= new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public Double getFormattedAmount(String amount) {

        Double price= Double.parseDouble(amount.substring(1));

        return price;
    }
    public void scrollToEndAction(){
        boolean canScrollMore;

        do {
            canScrollMore = (Boolean)(
                    ((JavascriptExecutor) driver).executeScript(
                            "mobile: scrollGesture",
                            ImmutableMap.of(
                                    "left", 100, "top", 100, "width", 200, "height", 200,
                                    "direction", "down",
                                    "percent", 3.0
                            )
                    ));

        } while (canScrollMore);
    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor) driver).executeScript(
                "mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
                        "duration", 2000));
    }
}
