package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

//    public void type(By locator, String text) {
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        if (text != null) {
//            element.sendKeys(text);
//        }
//    }

    public void click(By locator) {
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        return list.size() > 0;
    }


    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 40)
                .until(ExpectedConditions.alertIsPresent());
        // if (alert != null && alert.getText().contains(message)){
        if (alert != null && alert.getText().contains(message)) {
            System.out.println(alert.getText());

            //click ok
            alert.accept();
            //click cancel ---> alert.dismiss();
            //type into alert ---> alert.sendKeys();
            //  return true;
            // }
            //click cancel ---> alert.dismiss();
            //type into alert ---> alert.sendKeys();
            return true;
        }
        return false;

    }
    //********CW_07_01_2024_addNewContact************
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
            System.out.println("hello");
            element.sendKeys(text);
        }


    }

    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }


}