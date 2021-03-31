package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBasketPage {
    private WebDriver driver;

    public MyBasketPage(WebDriver webdriver) {
        this.driver=webdriver;
    }

    By itemNameBy= By.cssSelector(".pb-item");

    public String getItemName()
    {
        return driver.findElement(itemNameBy).getText();

    }

}
