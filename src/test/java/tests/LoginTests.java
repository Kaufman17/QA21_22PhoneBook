package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess1(){
        User user = new User().setEmail("chara@gmail.com").setPassword("Chara12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }
    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("chara@gmail.com", "Chara12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("luck@gmail.com", "Luck123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
}
