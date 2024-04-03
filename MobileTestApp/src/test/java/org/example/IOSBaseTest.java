package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSBaseTest {
    public AppiumDriverLocalService service;
    public IOSDriver driver;
    @BeforeEach
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException, InterruptedException {
        service= new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();

        service.start();

        XCUITestOptions options= new XCUITestOptions();
        //options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");

        //options.setDeviceName("iPhone");
        options.setDeviceName("iPhone 15");
       // options.setUdid("00008030-00052CC83EA0402E");
        options.setUdid("4CC4CFAE-1F5E-4910-A2ED-177AC600499E");
        options.setPlatformName("iOS");
        options.setAutomationName("XCUITest");

        //options.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
       // options.setApp("//Users//yusufsahin//Projects//floappium//MobileTestApp//src//test//resources//UIKitCatalog.app");
        //options.setCapability("xcodeSigningId", "iPhone Developer");
        //options.setCapability("xcodeOrgId", "BCS4RJGDD6");
        options.setCapability("platformVersion", "17.4");
      // options.setWdaLocalPort(8100);

        options.setWdaLaunchTimeout(Duration.ofSeconds(50));

        driver= new IOSDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(10);

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        service.stop();
    }


}
