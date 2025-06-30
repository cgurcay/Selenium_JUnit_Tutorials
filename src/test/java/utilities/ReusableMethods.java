package utilities;

public class ReusableMethods {

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Error on Thread.sleep");
        }
    }
}