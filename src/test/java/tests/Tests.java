package tests;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebElement;
import utils.Log;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static dataСonstants.DataConstants.*;
import static locators.AllLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("resources/screenshots");

    private static final String PICTURE = new File("src/main/resources/address_book.png").getAbsolutePath();

    @BeforeAll

    public void setUp() {

        Log.info("Open the page a.testaddressbook.com/sign_in");
        open("http://a.testaddressbook.com/sign_in");

        Log.info("We check that the user can sign in to the site");

        Log.info("In the 'Email' field, enter the email");
        $(EMAIL_FIELD).sendKeys(EMAIL);

        Log.info("In the 'Password' field, enter the password");
        $(PASSWORD_FIELD).sendKeys(PASSWORD);

        Log.info("Click on the 'Sign in' button");
        $(SIGN_IN_BUTTON).click();

        Log.info("Finding text on the page sign in 'Welcome to Address Book' ");
        WebElement text = $(TEXT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Welcome to Address Book'");
        Assertions.assertEquals("Welcome to Address Book", textTitle, "Error: user is not sign in");

    }

    @Test
    @Order(1)
    @DisplayName("Checking the address addition")

    public void addingAnAddress() {

        Log.info("Finding an addresses link and clicking on it");
        $(ADDRESSES_LINK).click();

        Log.info("Finding an new address link and clicking on it");
        $(NEW_ADDRESS_LINK).click();

        Log.info("In the 'First name' field, enter the first name");
        $(FIRST_NAME_FIELD).sendKeys(FIRST_NAME);

        Log.info("In the 'Last name' field, enter the last name");
        $(LAST_NAME_FIELD).sendKeys(LAST_NAME);

        Log.info("In the 'Address1' field, enter the address1");
        $(ADDRESS1_FIELD).sendKeys(ADDRESS1);

        Log.info("In the 'Address2' field, enter the address2");
        $(ADDRESS2_FIELD).sendKeys(ADDRESS2);

        Log.info("In the 'City' field, enter the city");
        $(CITY_FIELD).sendKeys(CITY);

        Log.info("In the 'State' field, select the state");
        $(STATE_FIELD).click();

        Log.info("In the 'Zip code' field, enter the zip code");
        $(ZIP_CODE_FIELD).sendKeys(ZIP_CODE);

        Log.info("In the 'Country' field, select the country");
        $(COUNTRY_FIELD).click();

        Log.info("In the 'Birthday' field, enter the birthday");
        $(BIRTHDAY_FIELD).sendKeys(BIRTHDAY);

        Log.info("In the 'Color' field, select the color");
        $(COLOR_FIELD).sendKeys(COLOR);

        Log.info("In the 'Age' field, enter the age");
        $(AGE_FIELD).sendKeys(AGE);

        Log.info("In the 'Website' field, enter the website");
        $(WEBSITE_FIELD).sendKeys(WEBSITE);

        Log.info("In the 'Picture' field, select the picture");
        WebElement uploadElement = $(PICTURE_FIELD);
        uploadElement.sendKeys(PICTURE);

        Log.info("In the 'Phone' field, enter the phone");
        $(PHONE_FIELD).sendKeys(PHONE);

        Log.info("In the 'Common Interests' field, select the common interests");
        $(COMMON_INTEREST_FIELD).click();

        Log.info("In the 'Note' field, enter the note");
        $(NOTE_FIELD).sendKeys(NOTE);

        Log.info("Click the button 'Create Address'");
        $(CREATE_ADDRESS_BUTTON).click();

        Log.info("Find the text on the page to add the address 'Address was successfully created.'");
        WebElement text = $(MESSAGE_ADD);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully created.'");
        Assertions.assertEquals("Address was successfully created.", textTitle, "Error: No address added");

    }

    @Test
    @Order(2)
    @DisplayName("Checking the change of address")

    public void editAnAddress () {

        Log.info("Finding an addresses link and clicking on it");
        $(ADDRESSES_LINK).click();

        Log.info("Finding an edit link and clicking on it");
        $(EDIT_LINK).click();

        Log.info("Delete the entry in the address field 1");
        $(ADDRESS1_FIELD).clear();

        Log.info("In the 'Address1' field, enter a new address1");
        $(ADDRESS1_FIELD).sendKeys(ADDRESS1_NEW);

        Log.info("Delete the entry in the address field 2");
        $(ADDRESS2_FIELD).clear();

        Log.info("In the 'Address2' field, enter a new address2");
        $(ADDRESS2_FIELD).sendKeys(ADDRESS2_NEW);

        Log.info("Delete the entry in the phone field ");
        $(PHONE_FIELD).clear();

        Log.info("In the 'Phone' field, enter a new phone");
        $(PHONE_FIELD).sendKeys(PHONE_NEW);

        Log.info("Click the button 'Update Address'");
        $(UPDATE_ADDRESS_BUTTON).click();

        Log.info("Find the text on the page to edit the address 'Address was successfully updated.'");
        WebElement text = $(MESSAGE_EDIT);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully updated.'");
        Assertions.assertEquals("Address was successfully updated.", textTitle, "Error: address not changed");

    }

    @Test
    @Order(3)
    @DisplayName("Checking for address deletion")

    public void deletingAnAddress (){

        Log.info("Finding an addresses link and clicking on it");
        $(ADDRESSES_LINK).click();

        Log.info("Finding a destroy link and clicking on it");
        $(DESTROY_LINK).click();

        Log.info("In the pop-up window, click OK");
        switchTo().alert().accept();

        Log.info("Find the text on the page to edit the address 'Address was successfully destroyed.'");
        WebElement text = $(MESSAGE_DELETE);

        Log.info("Getting the text on the page");
        String textTitle = text.getText();

        Log.info("Checking the message :'Address was successfully destroyed.'");
        Assertions.assertEquals("Address was successfully destroyed.", textTitle, "Error: the address was not deleted");

    }

    @AfterAll
    public void tearDown() {

        Log.info("We check that the user can sign out of the site");
        $(SIGN_OUT_LINK).click();

        }

    }


