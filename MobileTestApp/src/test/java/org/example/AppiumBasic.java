package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AppiumBasic {

    @Test
    public  void  MainTest() throws URISyntaxException, MalformedURLException, InterruptedException {
        AppiumDriverLocalService  service= new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\yusuf\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();

        service.start();

        UiAutomator2Options options= new UiAutomator2Options();
        //options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");

        options.setDeviceName("vivo v2204");
        options.setApp("C:\\Projects\\FloAppium\\MobileTestApp\\src\\test\\resources\\ApiDemos-debug.apk");

        AndroidDriver driver= new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(5000);
        driver.quit();
        service.stop();

    }
}
