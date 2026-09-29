package tests;

import base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTest {

    @Test
    @Tag("smoke")
    @Tag("regression")
    void invalidLoginShowsErrorMessage() {

        HomePage homePage = new HomePage(driver);

        homePage.open();

        LoginPage loginPage = homePage.clickSignupLogin();

        loginPage.login("fakeuser@example.com", "wrongpassword");

        assertEquals("Your email or password is incorrect!", loginPage.getLoginErrorMessage());
    }
}