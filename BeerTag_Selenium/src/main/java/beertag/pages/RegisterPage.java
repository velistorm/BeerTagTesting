package beertag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends HomePage {
    public RegisterPage() {
        super("/register");
    }

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("passwordConfirm");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("email");
    private final By registerButton = By.xpath("//input[@value='Register']");
    private static final By welcomeMessage = By.xpath("//h1[@class='mb-3 bread']");

    public void registerUser(String username, String password, String confirmPassword, String firstName, String lastName, String email) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
    }
    public static By getWelcomeMessage() {
        return welcomeMessage;
    }

}
