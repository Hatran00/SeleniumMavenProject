package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_AlertPractice2 extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.alert_URL2);
    }
    @Test
    public void deleteCustomer(){
        type(By.name("cusid"), "123");
        click(By.name("submit"));
        String actual1 = driver.switchTo().alert().getText();
        assertEquals(actual1, "Do you really want to delete this Customer?");
        driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String actual2 = driver.switchTo().alert().getText();
        assertEquals(actual2, "Customer Successfully Delete!");
        driver.switchTo().alert().accept();
    }
}
