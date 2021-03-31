package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.trendyol.*;

import java.util.Iterator;
import java.util.Set;

public class SearchTest extends BaseTest{

    @Test
    public void shouldLogin()
    {
        HomePage home=new HomePage(driver);
        home.closePopup();
        LoginPage loginPage=home.getLoginPage();
        loginPage.login("hhm75886@zwoho.com","test1234");
        home.closeLoginPopup();
        home.waitPageLoading();
        String loginText=home.getLoginText();
        Assert.assertEquals(loginText,"Hesabım");


    }

    @Test
    public void shouldAddtoBasket()
    {
        HomePage home=new HomePage(driver);
        home.closePopup();
        CategoryPage categoryPage=home.goToCategory();
        ItemDetailsPage itemDetailsPage=categoryPage.selectCategoryItem();



        String parentWindowHandler = driver.getWindowHandle();
        String subhandler = null;

        Set<String> handles =driver.getWindowHandles();

        Iterator<String> iterator= handles.iterator();

        while(iterator.hasNext())
        {
            subhandler=iterator.next();
        }

        driver.switchTo().window(subhandler);

        itemDetailsPage.addToBasket();
        itemDetailsPage.hoverToElement();
        Boolean isHoverVisible=itemDetailsPage.isHoverTextVisible();
        Assert.assertTrue(isHoverVisible);
        MyBasketPage myBasketPage=itemDetailsPage.setGoBasket();
        String actualItem=myBasketPage.getItemName();
        Assert.assertEquals(expectedItem,actualItem);

        driver.close();
        driver.switchTo().window(parentWindowHandler);



    }


}
