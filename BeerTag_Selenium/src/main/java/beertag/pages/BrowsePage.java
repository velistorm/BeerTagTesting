package beertag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testframework.Driver;
import testframework.DriverManager;

public class BrowsePage extends BaseBeerTagPage{
    public BrowsePage() {
        super("/beers");
    }

    private final By firstPost = By.xpath("//h5[normalize-space()='Glarus English Ale']");
    private final By addToWishList = By.xpath("//div[3]//div[1]//form[1]//div[1]//div[1]//button[1]");
    private static final By addAndRemoveToWishList = By.xpath("//div[3]//div[1]//form[1]//div[1]//div[1]//button[1]");
    private final By updateButton = By.xpath("//a[normalize-space()='Update']");
    private static final By browseBackground = By.xpath("//section[@class='py-5']");
    private final By nameUpdateField = By.id("name");
    private final By abvUpdateField = By.id("abv");
    private final By styleABeerUpdateField = By.id("styleId");
    private final By saveButton = By.xpath("//input[@value='Save']");
    private final By deleteButton = By.xpath("//a[normalize-space()='Delete']");

    private final By nameSort = By.id("name");
    private final By minAbvSort = By.id("minAbv");
    private final By maxAbvSort = By.id("maxAbv");
    private final By styleIdSort = By.id("styleId");
    private final By sortBySort = By.id("sortBy");
    private final By sortOrderSort = By.id("sortOrder");
    private final By searchSort = By.xpath("//input[@value='Search']");
    private static final By ailqkLink = By.xpath("//h5[normalize-space()='Ailyak']");


    public void clickFirstPost() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(firstPost)).click();
    }
    public void clickAddToWishList() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(addToWishList)).click();
    }
    public void clickAddAndRemoveToWishList() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(addAndRemoveToWishList)).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(addAndRemoveToWishList)).click();
    }
    public void clickPost(String beerName){
        By beerByName = By.partialLinkText(beerName);
        // Retrieve the driver instance
        Driver driver = DriverManager.getDriver();
        // Scroll to the beer element
        driver.scrollToElement(beerByName);
        // Click the beer element
        driver.findElement(beerByName).click();
    }
    public void updatePost(String newName, String abv, String styleName) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(updateButton)).click();
        //name
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameUpdateField)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameUpdateField)).sendKeys(newName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(abvUpdateField)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(abvUpdateField)).sendKeys(abv);
        //styleId
        WebElement dropdown = driverWait().until(ExpectedConditions.visibilityOfElementLocated(styleABeerUpdateField));
        Select select = new Select(dropdown);
        select.selectByVisibleText(styleName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();
    }
    public void deletePost(){
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteButton)).click();
    }
    public void sort(String name, String minAbv, String maxAbv, String styleName, String sortBy, String sortOrder) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameSort)).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameSort)).sendKeys(name);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(minAbvSort)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(minAbvSort)).sendKeys(minAbv);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(maxAbvSort)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(maxAbvSort)).sendKeys(maxAbv);
        //styleId
        WebElement dropdownStyle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(styleIdSort));
        Select selectOne = new Select(dropdownStyle);
        selectOne.selectByVisibleText(styleName);

        WebElement dropdownSortBy = driverWait().until(ExpectedConditions.visibilityOfElementLocated(sortBySort));
        Select selectTwo = new Select(dropdownSortBy);
        selectTwo.selectByVisibleText(sortBy);

        WebElement dropdownSortOrder = driverWait().until(ExpectedConditions.visibilityOfElementLocated(sortOrderSort));
        Select selectThree = new Select(dropdownSortOrder);
        selectThree.selectByVisibleText(sortOrder);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchSort)).click();
    }

    public static By getAddAndRemoveToWishList(){
        return addAndRemoveToWishList;
    }
    public static By getBrowseBackground(){
        return browseBackground;
    }
    public static By getAilqkLink(){
        return ailqkLink;
    }
}
