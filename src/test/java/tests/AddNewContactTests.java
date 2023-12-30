package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.By.name;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preConditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("chara@gmail.com").withPassword("Chara12345$"));

        }
    }

    @Test
    public void addNewContactSuccessAll() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Kati")
                .lastName("Jonson")
                .phone("0543692" + i)
                .email("kati@gmail.com")
                .address("Tel Aviv")
                .description("colleague")
                .build();


        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitCarForm();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(app.getHelperContact().isContactDisplayed(contact.getName(), contact.getPhone()),
                "Contact was not found after adding");
    }


    @Test
    public void addNewContactReqSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Jon")
                .lastName("Jonson")
                .phone("0573692" + i)
                .email("jon@gmail.com")
                .address("Haifa")
                .build();


        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitCarForm();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(app.getHelperContact().isContactDisplayed(contact.getName(), contact.getPhone()),
                "Contact was not found after adding");
    }



}
