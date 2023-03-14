package com.intigral.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Base {

    public WebDriver baseDriver;
    WebDriverWait wait;

    //Initializing chrome driver instance
    @BeforeClass
    public WebDriver driverInit () {
        System.setProperty("webdriver.chrome.driver", "././driver/chromedriver.exe");
        baseDriver = new ChromeDriver();
        return baseDriver;
    }

    @BeforeMethod
    public void goToApp () {
        baseDriver.get("https://subscribe.jawwy.tv/jo-en");
    }

    @AfterClass
    public void closeBrowser () {
        baseDriver.quit();
    }

    public WebDriver getDriver(){
        return baseDriver;
    }

    public void click_on_element (String itemCssSelector) {
        baseDriver.findElement(By.cssSelector(itemCssSelector)).click();
    }

    public void waitForElement (Integer seconds, String elementCssSelector) {
        wait = new WebDriverWait(baseDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCssSelector)));
    }

    //Package price
    public void packagePrice(String cssSelector, String expectedResult){
        String packageType = baseDriver.findElement(By.cssSelector(cssSelector)).getText();
        String[] packagePrice = packageType.split(" ");
        String price = packagePrice[0];
        Assert.assertEquals(price,expectedResult);
    }

    //Select country
    public void selectCountry(String countryCode) {
        baseDriver.findElement(By.id("country")).click();
        WebElement menu = baseDriver.findElement(By.id("country-selct"));
        menu.findElement(By.id(countryCode)).click();
    }
}
