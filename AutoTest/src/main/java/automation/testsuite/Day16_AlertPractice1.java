package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_AlertPractice1 extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.alert_URL1);
    }
    @Test
    public void HandleAlertWithOKAndCancel(){
        click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        click(By.xpath("//button[@class='btn btn-primary']"));
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Press a Button !");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//p[text()='You pressed Ok']")));
    }

    @Test
    public void HandleAlertWithTextbox(){
        click(By.xpath("//a[text()='Alert with Textbox ']"));
        click(By.xpath("//button[@class='btn btn-info']"));
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Please enter your name");
        driver.switchTo().alert().sendKeys("My June amazing class");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//p[text()='Hello My June amazing class How are you today']")));
    }
}
