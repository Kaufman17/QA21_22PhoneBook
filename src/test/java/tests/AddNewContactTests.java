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
//
//    @Test
//    public void addNewContactSuccessAll() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("Kati")
//                .lastName("Jonson")
//                .phone("0543692" + i)
//                .email("kati@gmail.com")
//                .address("Tel Aviv")
//                .description("colleague")
//                .build();
//
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        app.getHelperContact().pause(5000);
//
//        Assert.assertTrue(app.getHelperContact().isContactDisplayed(contact.getName(), contact.getPhone()),
//                "Contact was not found after adding");
//    }
//
//
//    @Test
//    public void addNewContactReqSuccess() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("Jon")
//                .lastName("Jonson")
//                .phone("0573692" + i)
//                .email("jon@gmail.com")
//                .address("Haifa")
//                .build();
//
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        app.getHelperContact().pause(5000);
//
//        Assert.assertTrue(app.getHelperContact().isContactDisplayed(contact.getName(), contact.getPhone()),
//                "Contact was not found after adding");
//    }
//
//    @Test
//    public void addNewContactWrongName() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("")
//                .lastName("Jonson")
//                .phone("0573692" + i)
//                .email("jon@gmail.com")
//                .address("Haifa")
//                .build();
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        app.getHelperContact().pause(5000);
//        Assert.assertTrue(app.getHelperContact().isAlertPresent("Name not be blank must not"));
//
//    }
//
//    @Test
//    public void addNewContactWrongAddress() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("")
//                .lastName("Jonson")
//                .phone("0573692" + i)
//                .email("jon@gmail.com")
//                .address("Haifa")
//                .build();
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        app.getHelperContact().pause(5000);
//        Assert.assertTrue(app.getHelperContact().isAlertPresent("Adress not be blank must not"));
//
//    }
//
//    @Test
//    public void addNewContactWrongLastName() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("Kati")
//                .lastName("")
//                .phone("0543692" + i)
//                .email("kati@gmail.com")
//                .address("Tel Aviv")
//                .description("colleague")
//                .build();
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        Assert.assertTrue(app.getHelperContact().isAlertPresent("LastName not be blank must not"));
//
//    }
//
//
//    @Test
//    public void addNewContactWrongPhone() {
//        // int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("Kati")
//                .lastName("Jonson")
//                .phone("0543692")
//                .email("kati@gmail.com")
//                .address("Tel Aviv")
//                .description("colleague")
//                .build();
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        Assert.assertTrue(app.getHelperContact().isAlertPresent("Phone not valid"));
//
//    }
//
//
//    @Test
//    public void addNewContactWrongEmail() {
//        int i = new Random().nextInt(1000) + 1000;
//        Contact contact = Contact.builder()
//                .name("Kati")
//                .lastName("Jonson")
//                .phone("0543692" + i)
//                .email("katigmail.com")
//                .address("Tel Aviv")
//                .description("colleague")
//                .build();
//
//        app.getHelperContact().openContactForm();
//        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().submitCarForm();
//        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));
//
//    }
//********CW_07_01_2024_addNewContact************
        @Test
        public void addContactSuccessAllFields () {
            int i = (int) (System.currentTimeMillis() / 1000 % 3600);
            Contact contact = Contact.builder()
                    .name("Tony" + i)
                    .lastName("Stark")
                    .address("NY")
                    .phone("3565946" + i)
                    .email("stark" + i + "@gmail.com")
                    .description("all fields")
                    .build();
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(contact);
            app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
            //app.getHelperContact().pause(2500);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
            Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        }
    @Test
    public void addContactSuccessRequiredFields() {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contact contact = Contact.builder()
                .name("TonyReq"+i)
                .lastName("Stark")
                .address("NY")
                .phone("35659446" + i)
                .email("stark" + i + "@gmail.com")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(2500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }
    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("Stark")
                .address("NY")
                .phone("35659445613")
                .email("stark@gmail.com")
                .description("empty name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(2500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("")
                .phone("35659445613")
                .email("stark@gmail.com")
                .description("empty address")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(2500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .address("NY")
                .phone("35659445613")
                .email("stark@gmail.com")
                .description("empty lastname")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(2500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("")
                .email("stark@gmail.com")
                .description("empty phone")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(2500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("12345678123")
                .email("starkgmail.com")
                .description("wrong email")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));
    }
    }