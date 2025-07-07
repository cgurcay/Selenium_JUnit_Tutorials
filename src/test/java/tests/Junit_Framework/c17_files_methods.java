package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class c17_files_methods {

    @Test
    public void fileTests() {

        // Find project path
        // System.getProperty("user.dir")
        System.out.println(System.getProperty("user.dir")); // C:\Users\celal\OneDrive\Desktop\Personal\Courses\WiseQuarter_SDET\T162\Selenium_JUnit_Tutorials

        // Find home path
        // System.getProperty("user.home")
        System.out.println(System.getProperty("user.home")); // C:\Users\celal

        // Find Downloads Path dynamically with String
        String dynamicDownloadsPathStr = System.getProperty("user.home") + "/Downloads/deneme.txt";

        System.out.println("Dynamic Path with String: " + dynamicDownloadsPathStr); // C:\Users\celal/Downloads/deneme.txt
        Assertions.assertFalse(Files.exists( Paths.get(dynamicDownloadsPathStr) ));

        // Find Downloads Path dynamically with Paths.get
        Path dynamicDownloadsPath = Paths.get(System.getProperty("user.home"), "Downloads", "deneme.txt");

        System.out.println("Dynamic Path with Path: " + dynamicDownloadsPath); // C:\Users\celal\Downloads\deneme.txt
        Assertions.assertFalse(Files.exists( dynamicDownloadsPath ));

        // Find Dynamic Path in the project
        String dynamicPathForProject = System.getProperty("user.dir") +
                                        "/src/test/java/tests/Junit_Framework/deneme.txt";

        System.out.println(dynamicPathForProject); // C:\Users\celal\OneDrive\Desktop\Personal\Courses\WiseQuarter_SDET\T162\Selenium_JUnit_Tutorials/src/test/java/tests/Junit_Framework/deneme.txt

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPathForProject)));

    }

}
