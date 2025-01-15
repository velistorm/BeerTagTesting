package beertag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.Driver;
import testframework.DriverManager;

public class HomePage extends BaseBeerTagPage {
    public HomePage(String s) {
        super("");
    }

    private final By registerLink = By.xpath("//a[normalize-space()='Register']");
    private final By loginLink = By.xpath("//a[normalize-space()='Login']");
    private final By beerTagNameHomeLink = By.xpath("//a[@class='navbar-brand']");
    private static final By logoutLink = By.xpath("//a[normalize-space()='Logout']");
    private static final By browseAllBeersLink = By.xpath("//a[normalize-space()='Browse all beers']");
    private static final By adminPortalLink = By.xpath("//a[normalize-space()='Admin Portal']");
    private static final By homePageBackground = By.xpath("//section[@id='portfolio']");
    private final By nameContactUs = By.id("name");
    private final By emailContactUs = By.id("email");
    private final By phoneContactUs = By.id("phone");
    private final By messageContactUs = By.id("message");
    private final By sendContactUs = By.id("submitButton");

    public void clickRegister() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(registerLink)).click();
    }
    public void clickLogIn() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginLink)).click();
    }

    public void clickBeerTagNameHomeLink() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(beerTagNameHomeLink)).click();
    }
    public void clickBrowseAllBeersLink() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(browseAllBeersLink)).click();
    }
    public void clickAdminPortalLink() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(adminPortalLink)).click();
    }
    public static By getLogoutLink(){
        return logoutLink;
    }
    public static By getBrowseAllBeersLink() {
        return browseAllBeersLink;
    }
    public static By getAdminPortalLink(){
        return adminPortalLink;
    }
    public static By getHomePageBackground(){
        return homePageBackground;
    }
    public void clickBeerInHomePage(String divNum) {
        By beer = By.xpath("//*[@id=\"portfolio\"]/div/div[2]/div[" + divNum + "]/div");
        By closeWindow = By.xpath("//*[@id=\"beerModal" + divNum + "\"]/div/div/div[2]/div/div/div/button");
        Driver driver = DriverManager.getDriver();
        driver.scrollToElement(beer);
        driver.findElement(beer).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(closeWindow)).click();
    }
    public void fillContactUsForm(String name, String email, String phoneNumber, String message) {
        Driver driver = DriverManager.getDriver();
        driver.scrollToElement(sendContactUs);
        driver.findElement(nameContactUs).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameContactUs)).sendKeys(name);
        driver.findElement(emailContactUs).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailContactUs)).sendKeys(email);
        driver.findElement(phoneContactUs).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(phoneContactUs)).sendKeys(phoneNumber);
        driver.findElement(messageContactUs).click();
        driver.scrollToElement(sendContactUs);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(messageContactUs)).sendKeys(message);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(sendContactUs)).click();
    }
}
