package manager;

import models.Contact;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }


    //    public void submitCarForm() {
//        click(By.xpath("//b[text()='Save']"));
//    }
//
//    public boolean isContactDisplayed(String name, String phone) {
//        WebDriverWait wait = new WebDriverWait(wd, 20);
//
//        try {
//            wait.until(ExpectedConditions.textToBePresentInElementLocated(
//                    By.cssSelector(".contact-item_card__2SOIM"), "No Contacts !"));
//            return false;
//        } catch (TimeoutException e) {
//
//            String contactInfo = name + " " + phone;
//            By contactLocator = By.xpath("//div[contains(@class, 'contact-item_card__2SOIM') and contains(., '" + contactInfo + "')]");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(contactLocator));
//            return true;
//        }
//    }
//********CW_07_01_2024_addNewContact************

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2>button"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));

    }


    //****************HW_RemoveContact*************
    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of Contacts list before remove is --->" + before);
        removeContact();

        int after = countOfContacts();
        logger.info("Number of Contacts list after remove is --->" + after);

        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        //return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        int res = list.size();
        return res;
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeContact();
        }
    }

    public void provideContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                //addNewContact
                addOneContact();
            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Harry" + i)
                .lastName("Potter")
                .address("Hogwards")
                .email("harry" + i + "@gmail.com")
                .phone("55566777" + i)
                .description("Friend")
                .build();

        openContactForm();
        fillContactForm(contact);
        saveContact();
        pause(500);
    }



}






