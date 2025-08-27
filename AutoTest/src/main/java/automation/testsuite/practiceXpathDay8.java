package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class practiceXpathDay8 extends CommonBase {
    //bai 1
    @Test
    public void getEmailElement(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement emailElement = driver.findElement(By.name("email"));
        System.out.println("emailElement: " + emailElement);
    }

    @Test
    public void getPasswordElement(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement passwordElement = driver.findElement(By.id("pass"));
        System.out.println("passwordElement: " + passwordElement);
    }

    @Test
    public void getCompanyElement(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement companyElement = driver.findElement(By.name("company"));
        System.out.println("companyElement: " + companyElement);
    }

    @Test
    public void getMobileNumElement(){
        driver = initChromeDriver(CT_PageURL.selector_HUB_URL);
        WebElement mobileNumberElement = driver.findElement(By.name("mobile number"));
        System.out.println("mobileNumberElement: " + mobileNumberElement);
    }

    //bai 2
    @Test
    public void getElementName() {
        driver = initChromeDriver(CT_PageURL.auto_URL);
        WebElement nameElement = driver.findElement(By.id("name"));
        System.out.println("nameElement: " + nameElement);
    }

    @Test
    public void getElementAddress() {
        driver = initChromeDriver(CT_PageURL.auto_URL);
        WebElement addressElement = driver.findElement(By.id("address"));
        System.out.println("addressElement: " + addressElement);
    }

    @Test
    public void getElementEmail() {
        driver = initChromeDriver(CT_PageURL.auto_URL);
        WebElement emailElement = driver.findElement(By.id("email"));
        System.out.println("emailElement: " + emailElement);
    }

    @Test
    public void getElementPassword() {
        driver = initChromeDriver(CT_PageURL.auto_URL);
        WebElement passwordElement = driver.findElement(By.id("password"));
        System.out.println("passwordElement: " + passwordElement);
    }
}
