package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class Day8_Practice extends CommonBase {
    @Test
    public void getElementById(){
        driver = initChromeDriver(CT_PageURL.alada_URL);
        WebElement emailElement = driver.findElement(By.id("txtLoginUsername"));
        System.out.println("emailElement: " + emailElement);
    }

    @Test
    public void getElementByName(){
        driver = initChromeDriver(CT_PageURL.alada_URL);
        WebElement passElement = driver.findElement(By.name("txtLoginPassword"));
        System.out.println("passElement: "+ passElement);
    }

    @Test
    public void getElementByLinkText(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement textFindout = driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
        System.out.println("textFindout: "+ textFindout);
    }

    @Test
    public void getElementByPartialLinkText(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement textCourse = driver.findElement(By.partialLinkText("A course with complex scenarios like"));
        System.out.println("textCourse: "+ textCourse);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
