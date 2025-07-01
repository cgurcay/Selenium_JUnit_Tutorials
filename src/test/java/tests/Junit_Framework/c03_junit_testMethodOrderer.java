package tests.Junit_Framework;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder(MethodOrderer.MethodName.class) // A-Z by name (MethodName or DisplayName)
public class c03_junit_testMethodOrderer {

    /*
        Without - MethodOrderer.OrderAnnotation.class
        Third Test
        First Test
        Second Test
     */

    @Test @Order(1)
    public void zfirstTest() {
        System.out.println("First Test");
    }

    @Test @Order(2)
    public void secondTest() {
        System.out.println("Second Test");
    }

    @Test @Order(3)
    public void thirdTest() {
        System.out.println("Third Test");
    }


}
