package beertag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends HomePage {
    public LogInPage() {
        super("/login");
    }

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private static final By loginHeader = By.xpath("//input[@value='Login']");
    public void signIn(String username, String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
    public static By getLoginHeader() {
        return loginHeader;
    }
}

