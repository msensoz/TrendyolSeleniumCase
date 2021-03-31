package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemDetailsPage {

    private WebDriver driver;

    By addBasketBy= By.xpath("//*[text()='Sepete Ekle']");
    By myBasketBy=By.xpath("//p[text()='Sepetim']");
    By hoverBoxBy=By.cssSelector(".slideUpBox");
    By goBasket=By.cssSelector(".goBasket");

    public ItemDetailsPage(WebDriver webdriver) {
        this.driver=webdriver;
    }

    public void addToBasket()
    {

        WebDriverWait wd=new WebDriverWait(driver, Duration.ofSeconds(20));
        wd.until(ExpectedConditions.visibilityOfElementLocated(addBasketBy));
        driver.findElement(addBasketBy).click();

    }

    public void hoverToElement()
    {
        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(myBasketBy)).build().perform();

    }
    public boolean isHoverTextVisible()
    {
        WebDriverWait wd=new WebDriverWait(driver, Duration.ofSeconds(20));
        wd.until(ExpectedConditions.visibilityOfElementLocated(hoverBoxBy));
        return driver.findElement(hoverBoxBy).isDisplayed();
    }

    public MyBasketPage setGoBasket()
    {
        driver.findElement(goBasket).click();
        return new MyBasketPage(driver);
    }

}
