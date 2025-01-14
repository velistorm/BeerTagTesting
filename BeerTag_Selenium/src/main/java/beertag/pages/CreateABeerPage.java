package beertag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateABeerPage extends BaseBeerTagPage{
    public CreateABeerPage() {
        super("/beers/new");
    }

    // //a[normalize-space()='Browse all beers']
    private final By createABeerLink = By.xpath("//a[normalize-space()='Create Beer']");
    private static final By saveButtonLink = By.xpath("//input[@value='Save']");
    private final By nameABeerLink = By.id("name");
    private final By abvLink = By.id("abv");
    private final By styleABeerLink = By.id("styleId");

    public void clickCreateABeerLink(){
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createABeerLink)).click();
    }
    public void clickNameABeerLink(String name, String abv, String styleName){
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameABeerLink)).sendKeys(name);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(abvLink)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(abvLink)).sendKeys(abv);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(styleABeerLink)).click();
        WebElement dropdown = driverWait().until(ExpectedConditions.visibilityOfElementLocated(styleABeerLink));
        Select select = new Select(dropdown);
        select.selectByVisibleText(styleName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(saveButtonLink)).click();
    }

    public static By getSaveButtonLink(){
        return saveButtonLink;
    }
}
