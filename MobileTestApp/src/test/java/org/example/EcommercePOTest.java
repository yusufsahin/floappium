package org.example;

import org.example.po.CartPage;
import org.example.po.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EcommercePOTest  extends AndBaseTest{

    @Test
    public void  ecommerceTestDemo()
    {
        HomePage homePage= new HomePage(driver);
        CartPage cartPage= new CartPage(driver);

        homePage.fillForm("Jane Doe","female","Australia");

        double totalSum= cartPage.calcutalateTotalSum();
        double displayedTotalSum= cartPage.getDislayedTotalAmount();
        Assertions.assertEquals(totalSum,displayedTotalSum, "The calculated total sum does not match the displayed total sum.");

        cartPage.proceedToCheckout();


    }
}
