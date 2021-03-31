package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver webdriver) {
        this.driver=webdriver;
    }

    By itemcategoryBy= By.xpath("//span[text()='Televizyon']");
    By items=By.cssSelector(".p-card-wrppr");



    public ItemDetailsPage selectCategoryItem()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElements(items).get(0).click();
        return new ItemDetailsPage(driver);

    }


}
