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

public class BTVN_Day16_Bai2 extends CommonBase {
    @BeforeMethod
    public void openFirefoxBrowser(){
        driver = initFirefoxDriver(CT_PageURL.alert_URL3);
    }
    @Test
    public void HandleAlertWithOK(){
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Welcome to Selenium WebDriver Tutorials");
        driver.switchTo().alert().accept();
        closeDriver();
    }
}
