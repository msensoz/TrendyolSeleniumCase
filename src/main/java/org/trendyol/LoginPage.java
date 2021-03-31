package org.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By emailBy= By.id("login-email");
    By passwordBy=By.id("login-password-input");
    //By login=By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button submit");
    By login=By.cssSelector(".account-user");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public HomePage login(String email, String password)
    {

        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(login).click();

        return new HomePage(driver);
    }


}
