package tests.Junit_Framework;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class c06_junit_usingTestBase extends TestBase_Each {

    @Test
    public void test01() {

        driver.get("https://demowebshop.tricentis.com/register");

        ReusableMethods.wait(1);

    }

}
