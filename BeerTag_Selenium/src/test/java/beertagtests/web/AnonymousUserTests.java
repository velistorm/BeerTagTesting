package beertagtests.web;

import beertag.pages.BrowsePage;
import beertag.pages.HomePage;
import beertagtests.core.BeerTagBaseWebTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import testframework.utils.AssertionUtils;

@Epic("Anonymous User Tests Tests")
public class AnonymousUserTests extends BeerTagBaseWebTest {
    @Test
    @Feature("Anonymous User Can Browse Public Posts")
    @Description("Tests the functionality of an anonymous user browsing public posts")
    public void anonymousUserCanBrowsePosts() throws InterruptedException {
        homePage.navigate();
        homePage.clickBeerInHomePage("10");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getHomePageBackground());
    }
    @Test
    @Feature("Anonymous User Can Fill A Contact Us Form")
    @Description("Tests the functionality of anonymous user filling a Contact Us form")
    public void anonymousUserFillingAContactUsForm(){
        homePage.navigate();
        homePage.fillContactUsForm("Velislav Petev", "test@gmail.com", "08888888", "This is my message.");
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Form submission successful!");
    }
    @Test
    @Feature("Anonymous User Can Sort Posts")
    @Description("Tests the functionality of anonymous user sorting posts")
    public void anonymousUserSort(){
        homePage.navigate();
        homePage.clickBrowseAllBeersLink();
        browsePage.sort("Ailyak", "1", "9", "Indian pale ale", "Name", "Ascending");
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", BrowsePage.getAilqkLink());
    }
}

