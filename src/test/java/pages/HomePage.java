package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private final By signupLoginLink =
            By.cssSelector("a[href='/login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://automationexercise.com");
    }

    public LoginPage clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
        return new LoginPage(driver);
    }
}