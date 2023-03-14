package com.intigral.tests.validatePackagePrice;

import com.intigral.base.Base;
import org.testng.annotations.Test;

public class IRAQPackagesPrice extends Base {

    @Test
    public void egPackage(){
        baseDriver = getDriver();

        //Egypt country
        selectCountry("iq");

        //Lite package price
        packagePrice("#currency-lite .new-price", "2.4");

        //Classic package price
        packagePrice("#currency-classic .new-price", "4.1");

        //Premium package price
        packagePrice("#currency-premium .new-price", "6.2");
    }
}
