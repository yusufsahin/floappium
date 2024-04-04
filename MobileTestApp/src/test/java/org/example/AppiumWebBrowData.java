package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Iterator;

public class AppiumWebBrowData {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    Workbook workbook;
    @BeforeEach
    public void setUp() throws URISyntaxException, IOException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");
        //options.setDeviceName("vivo v2204");
        //options.setApp("//Users//yusufsahin//Projects//chromedriver//chromedriver");
        options.setChromedriverExecutable("//Users//yusufsahin//Projects//chromedriver//chromedriver3");
        options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        FileInputStream fis=new FileInputStream(new File("src/test/resources/searchData.xlsx"));
        workbook= new XSSFWorkbook(fis);
    }
    @Test
    public void WebBrowserTest() throws URISyntaxException, MalformedURLException {
        Sheet sheet= workbook.getSheetAt(0);

        Iterator<Row> rowIterator= sheet.rowIterator();

        if(rowIterator.hasNext()){
            rowIterator.next();
        }

        while (rowIterator.hasNext()){
            driver.get("https://www.google.com");
            Row row =rowIterator.next();
            Cell cell= row.getCell(0);
            String searchKey= cell.getStringCellValue();
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(searchKey);
            searchBox.sendKeys(Keys.RETURN);
        }

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
