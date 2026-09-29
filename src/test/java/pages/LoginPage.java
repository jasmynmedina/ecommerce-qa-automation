package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By emailInput =
            By.cssSelector("input[data-qa='login-email']");

    private final By passwordInput =
            By.cssSelector("input[data-qa='login-password']");

    private final By loginButton =
            By.cssSelector("button[data-qa='login-button']");

    private final By loginError =
            By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginError).getText();
    }
}