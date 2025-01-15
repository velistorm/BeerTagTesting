package beertagtests.web;

import beertag.pages.BrowsePage;
import beertag.pages.HomePage;
import beertagtests.core.BeerTagBaseWebTest;
import beertagtests.enums.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import testframework.utils.AssertionUtils;

@Epic("Admin User Tests Tests")
public class AdminUserTests extends BeerTagBaseWebTest {
    @Test
    @Feature("Admin User Can Log In")
    @Description("Tests the functionality of logging in an admin user")
    public void loginAdminUser() {
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getLogoutLink());
    }
    @Test
    @Feature("Anonymous User Can Open The Admin Portal")
    @Description("Tests the functionality of an admin user opening the Admin Portal")
    public void adminPortal() {
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickAdminPortalLink();
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Welcome to Admin Portal!");
    }
    @Test
    @Feature("Admin User Can Look At Public Posts")
    @Description("Tests the functionality of a standard admin looking at public posts")
    public void adminUserCanLookAtPosts(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        //You can choose which post you want to open by entering its number below (the element has to exist)
        homePage.clickBeerInHomePage("10");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getHomePageBackground());
    }
    @Test
    @Feature("Admin User Can Browse Posts")
    @Description("Tests the functionality of admin user browsing posts")
    public void adminUserCanBrowsePosts(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getBrowseAllBeersLink());
    }
    @Test
    @Feature("Admin User Can Click Posts In The Browse Page")
    @Description("Tests the functionality of admin user clicking a post in the Browse Page")
    public void adminUserCanClickPostsInBrowsePage(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickFirstPost();
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Delete");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Update");
    }
    @Test
    @Feature("Admin User Can Add A Post To Wishlist")
    @Description("Tests the functionality of admin user adding a post to wishlist")
    public void adminUserAddAPostToWishlist(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickAddToWishList();
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Remove from wishlist");
    }
    @Test
    @Feature("Admin User Can Remove A Post From Wishlist")
    @Description("Tests the functionality of admin user removing a post from wishlist")
    public void adminUserRemoveAPostFromWishlist(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.clickAddAndRemoveToWishList();
        AssertionUtils.assertElementDeselected(DriverManager.getDriver(), BrowsePage.getAddAndRemoveToWishList());
    }
    @Test
    @Feature("Admin User Can Sort Posts")
    @Description("Tests the functionality of admin user sorting posts")
    public void adminUserSort(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickBrowseAllBeersLink();
        browsePage.sort("Ailyak", "1", "9", "Indian pale ale", "Name", "Ascending");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getAilqkLink());
    }
    @Test
    @Feature("Admin User Can Create A Post")
    @Description("Tests the functionality of admin user creating a post")
    public void adminUserCreatesAPost() {
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.ADMIN_BEER_NAME.getValue(), "10", "Red Ale");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Beer");
    }
    @Test
    @Feature("Admin User Can Update His Any Post")
    @Description("Tests the functionality of admin user updating any post")
    public void adminUserUpdatesHisOwnPost(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.ADMIN_BEER_NAME.getValue(), "10", "Red Ale");
        homePage.clickBrowseAllBeersLink();
        browsePage.clickPost("Admin");
        browsePage.updatePost("Admin Updated Beer", "4", "Stout");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getBrowseBackground());
    }
    @Test
    @Feature("Admin User Can Delete Any Post")
    @Description("Tests the functionality of admin user deleting any post")
    public void adminUserDeletesHisOwnPost(){
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        createABeerPage.clickCreateABeerLink();
        createABeerPage.clickNameABeerLink(TestData.ADMIN_BEER_NAME.getValue(), "10", "Red Ale");
        homePage.clickBrowseAllBeersLink();
        browsePage.clickPost("Beer");
        browsePage.deletePost();
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getBrowseBackground());
    }
    @Test
    @Feature("Admin User Can Fill A Contact Us Form")
    @Description("Tests the functionality of admin user filling a Contact Us form")
    public void adminUserFillingAContactUsForm() {
        homePage.navigate();
        homePage.clickLogIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.fillContactUsForm("Velislav Petev", "velistorm@gmail.com", "08888888", "This is my message.");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Form submission successful!");
    }
}