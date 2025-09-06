package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN_Day17 extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.mediaMart_URL);
    }
    @Test
    public void zaloChat(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mediaFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("easychatgpt-widget")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('easychatgpt-widget').style.display='none';");

        click(By.xpath("//div[@class='zalo-chat-widget']"));
        driver.switchTo().frame(0);
        assertTrue(isElementDisplay(By.xpath("//p[text()='Bắt đầu trò chuyện với Siêu thị điện máy MediaMart']")));
        closeDriver();
    }
}
