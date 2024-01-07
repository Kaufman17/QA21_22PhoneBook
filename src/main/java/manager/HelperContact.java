package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public void submitCarForm() {
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactDisplayed(String name, String phone) {
        WebDriverWait wait = new WebDriverWait(wd, 20);

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.cssSelector(".contact-item_card__2SOIM"), "No Contacts !"));
            return false;
        } catch (TimeoutException e) {

            String contactInfo = name + " " + phone;
            By contactLocator = By.xpath("//div[contains(@class, 'contact-item_card__2SOIM') and contains(., '" + contactInfo + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactLocator));
            return true;
        }
    }

}





