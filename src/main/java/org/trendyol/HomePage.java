package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    
    By searchboxBy=By.className("search-box");
    By popupcloseBy=By.className("fancybox-close");
    By recommendationboxBy=By.className("suggestion-result");
    By login=By.cssSelector(".account-user");
    By loginpopup=By.id("Combined-Shape");
    By componentBy=By.className("component-list");
    By categoryBy=By.xpath("//a[text()='ELEKTRONİK']");
    By subCategoryBy=By.xpath("//a[text()='TV & Görüntü & Ses']");

    private WebDriver driver;

    public HomePage(WebDriver webdriver) {
        this.driver=webdriver;
    }




    public void closePopup()
    {
        WebDriverWait wd=new WebDriverWait(driver, Duration.ofSeconds(20));
        wd.until(ExpectedConditions.visibilityOfElementLocated(popupcloseBy));
        driver.findElement(popupcloseBy).click();
    }
    
    public SearchResultPage setSearchboxBy(String searchitem)
    {
         driver.findElement(searchboxBy).sendKeys(searchitem+ Keys.ENTER);
         return new SearchResultPage(driver);

    }

    public void searchText(String param)
    {
        driver.findElement(searchboxBy).sendKeys(param);

    }

    public boolean isRecommendationBoxdsiplayed()
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(recommendationboxBy));
       return driver.findElement(recommendationboxBy).isDisplayed();

    }

    public LoginPage getLoginPage()
    {
        driver.findElement(login).click();
        return new LoginPage(driver);
    }

    public void closeLoginPopup()
    {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loginpopup));
        driver.findElement(loginpopup).click();

    }

    public void waitPageLoading()
    {

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentBy));
    }

    public String getLoginText()
    {

        return driver.findElement(login).getText();
    }

    public CategoryPage goToCategory()
    {
        Actions action = new Actions(this.driver);

        action.moveToElement(this.driver.findElement(categoryBy)).build().perform();
        this.driver.findElement(subCategoryBy).click();

        return new CategoryPage(this.driver);
    }
}
