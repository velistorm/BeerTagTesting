package beertagtests.web;

import beertag.pages.BrowsePage;
import beertag.pages.HomePage;
import beertag.pages.LogInPage;
import beertagtests.core.BeerTagBaseWebTest;
import beertagtests.enums.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testframework.DriverManager;
import testframework.utils.AssertionUtils;

@Epic("Standard User Tests")
public class StandardUserTests extends BeerTagBaseWebTest {
    @Test
    @Feature("Standard User Registration")
    @Description("Tests the functionality of creating a new standard user.")
            //"Verifies that a user can create a post and it appears in the feed.")
    public void registerStandardUser(){
        homePage.navigate();
        homePage.clickRegister();

        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.FIRST_NAME.getValue(), TestData.LAST_NAME.getValue(), TestData.EMAIL.getValue());

        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", LogInPage.getLoginHeader());
    }
    @Test
    @Feature("Standard User Log In")
    @Description("Tests the functionality of logging in a standard user.")
    public void loginStandardUser(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getLogoutLink());
    }
    @Test
    @Feature("Standard User Can Look At Public Posts")
    @Description("Tests the functionality of a standard user looking at public posts")
    public void standardUserCanLookAtPosts(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        //You can choose which post you want to open by entering its number below (the element has to exist)
        homePage.clickBeerInHomePage("10");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getHomePageBackground());
    }
    @Test
    @Feature("Standard User Can Browse Posts")
    @Description("Tests the functionality of standard user browsing posts")
    public void standardUserCanBrowsePosts(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getBrowseAllBeersLink());
    }
    @Test
    @Feature("Standard User Can Click Posts In The Browse Page")
    @Description("Tests the functionality of standard user clicking a post in the Browse Page")
    public void standardUserCanClickPostsInBrowsePage(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickFirstPost();
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Delete");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Update");
    }
    @Test
    @Feature("Standard User Can Add A Post To Wishlist")
    @Description("Tests the functionality of standard user adding a post to wishlist")
    public void standardUserAddAPostToWishlist(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickAddToWishList();
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Remove from wishlist");
    }
    @Test
    @Feature("Standard User Can Remove A Post From Wishlist")
    @Description("Tests the functionality of standard user removing a post from wishlist")
    public void standardUserRemoveAPostFromWishlist(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickAddAndRemoveToWishList();
        AssertionUtils.assertElementDeselected(DriverManager.getDriver(), BrowsePage.getAddAndRemoveToWishList());
    }
    @Test
    @Feature("Standard User Can Create A Post")
    @Description("Tests the functionality of standard user creating a post")
    public void standardUserCreatesAPost() {
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.STD_BEER_NAME.getValue(), "10", "Red Ale");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Beer");
    }
    @Test
    @Feature("Standard User Can Update His Own Post")
    @Description("Tests the functionality of standard user updating a post owned by him")
    public void standardUserUpdatesHisOwnPost(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.STD_BEER_NAME.getValue(), "10", "Red Ale");
        homePage.clickBrowseAllBeersLink();
        browsePage.clickPost("Beer");
        browsePage.updatePost("Beer Updated", "4", "Stout");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getBrowseBackground());
    }
    @Test
    @Feature("Standard User Can Delete His Own Post")
    @Description("Tests the functionality of standard user deleting a post owned by him")
    public void standardUserDeletesHisOwnPost(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.STD_BEER_NAME.getValue(), "10", "Red Ale");
        homePage.clickBrowseAllBeersLink();
        browsePage.clickPost("Beer");
        browsePage.deletePost();
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getBrowseBackground());
    }
    @Test
    @Feature("Standard User Can Sort Posts")
    @Description("Tests the functionality of standard user sorting posts")
    public void standardUserSort(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.sort("Ailyak", "1", "9", "Indian pale ale", "Name", "Ascending");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getAilqkLink());
    }
    @Test
    @Feature("Standard User Can Fill A Contact Us Form")
    @Description("Tests the functionality of standard user filling a Contact Us form")
    public void standardUserFillingAContactUsForm(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        homePage.fillContactUsForm("Velislav Petev", "test@gmail.com", "08888888", "This is my message.");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Form submission successful!");
    }
}
