package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String testName) {

        File screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        Path destination =
                Path.of(
                        "build",
                        "screenshots",
                        testName + ".png"
                );

        try {
            Files.createDirectories(destination.getParent());

            Files.copy(
                    screenshot.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to save screenshot",
                    e
            );
        }
    }
}