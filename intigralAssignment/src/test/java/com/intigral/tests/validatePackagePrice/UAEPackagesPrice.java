package com.intigral.tests.validatePackagePrice;

import com.intigral.base.Base;
import org.testng.annotations.Test;

public class UAEPackagesPrice extends Base {

    @Test
    public void egPackage(){
        baseDriver = getDriver();

        //Egypt country
        selectCountry("ae");

        //Lite package price
        packagePrice("#currency-lite .new-price", "5.4");

        //Classic package price
        packagePrice("#currency-classic .new-price", "10.9");

        //Premium package price
        packagePrice("#currency-premium .new-price", "16.3");
    }
}
