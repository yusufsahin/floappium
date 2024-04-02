package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

public class IOSBasic extends IOSBaseTest {

    @Test
    public void HelloIOS() {


        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

    }
}
