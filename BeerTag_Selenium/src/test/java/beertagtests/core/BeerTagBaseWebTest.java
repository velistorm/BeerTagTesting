package beertagtests.core;

import beertag.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import testframework.DriverManager;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class BeerTagBaseWebTest extends BaseWebTest {



    //NE ZABRAVQI NOVITE KLASOVE DA SE INSTANCIRAT!!!!!!!!!!!!!!!!

    protected HomePage homePage;
    protected RegisterPage registerPage;
    protected LogInPage signInPage;
    protected BrowsePage browsePage;
    protected CreateABeerPage createABeerPage;

    @BeforeEach
    public void beforeTests() {
        homePage = new HomePage("");
        registerPage = new RegisterPage();
        signInPage = new LogInPage();
        browsePage = new BrowsePage();
        createABeerPage = new CreateABeerPage();
        driver().get(PropertiesManager.getConfigProperties().getProperty("beertagBaseUrl"));
    }

    @AfterEach
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {
        DriverManager.quitDriver();
    }

}
