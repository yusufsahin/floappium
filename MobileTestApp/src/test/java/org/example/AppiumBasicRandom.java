package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AppiumBasicRandom extends AndBaseTest {

    @Test
    public  void RandomTest() {
        // Wait for the ListView to be visible and find it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement listView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id='android:id/list']")));

// Instead of storing all elements in a list immediately,
// you find the number of clickable items within the ListView for a random selection.
        List<WebElement> listItems = listView.findElements(By.xpath(".//android.widget.TextView[@clickable='true']"));
        int randomIndex = new Random().nextInt(listItems.size());

// Re-find the ListView and then the random item by its index right before interaction
        listView = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']"));
        WebElement randomItem = listView.findElements(By.xpath(".//android.widget.TextView[@clickable='true']")).get(randomIndex);

// Now click on the randomly selected item
        randomItem.click();


    }
}
