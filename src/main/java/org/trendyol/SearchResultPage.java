package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;
    By resultexttboxBy=By.xpath("//div[@class='dscrptn']//h1[contains(text(),searchitem)]");

    public SearchResultPage(WebDriver webdriver) {
        this.driver=webdriver;
    }


    public String getSearchResultText()
    {
        return driver.findElement(resultexttboxBy).getText();
    }
}
