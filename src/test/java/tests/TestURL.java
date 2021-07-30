package tests;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

import utils.Log;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestURL {


    @BeforeAll
    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        open("http://a.testaddressbook.com/sign_in");

    }

    @Test
    @Order(1)
    @DisplayName("We check if the URL of the site's login page is correct")

    public void urlPage() {

        Log.info("Open the page a.testaddressbook.com/sign_in" + url());

        Log.info("We check if the URL of the site's login page is correct");
        String currentURL = url();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL, "Url wrong");

    }

    @AfterAll
    public void tearDown() {

        Log.info("Close the browser");

    }
}