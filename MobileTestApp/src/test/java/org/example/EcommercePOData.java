package org.example;
import org.example.po.CartPage;
import org.example.po.HomePage;


import org.example.utis.ExcelDataReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.List;
@TestInstance(Lifecycle.PER_CLASS)
public class EcommercePOData extends AndBaseTest{

    private List<Object[]> testData;

    @BeforeAll
    public void setUp() {
        String excelFilePath = "src/test/resources/TestData.xlsx";
        testData = ExcelDataReader.readTestData(excelFilePath);
    }
    // Provide test data for the parameterized test

    public List<Object[]> getTestData() {

        return testData;
    }
    @ParameterizedTest
    @MethodSource("getTestData")
    public void ecommerceTestDemo(String name, String gender, String country, double expectedTotal) {
        HomePage homePage = new HomePage(driver); // Ensure HomePage constructor correctly handles the driver
        CartPage cartPage = new CartPage(driver); // Same for CartPage

        homePage.fillForm(name, gender, country);

        double totalSum = cartPage.calcutalateTotalSum();
        Assertions.assertEquals(expectedTotal, totalSum, 0.01, "Mismatch in calculated total sum.");

        cartPage.proceedToCheckout();
    }
}
