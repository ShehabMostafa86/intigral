package com.intigral.tests.validatePackagePrice;

import com.intigral.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EGPackagesPrice extends Base {

    @Test
    public void egPackage(){
        baseDriver = getDriver();

        //Egypt country
        selectCountry("eg");

        //Lite package price
        packagePrice("#currency-lite .new-price", "0.25");

        //Classic package price
        packagePrice("#currency-classic .new-price", "0.50");

        //Premium package price
        packagePrice("#currency-premium .new-price", "1");
    }
}
