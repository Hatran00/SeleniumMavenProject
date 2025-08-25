package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TEDU_Test extends CommonBase {
    TEDU_PageFactory tedu;
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.tedu_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test
    public void loginSuccessfully() throws InterruptedException {
        tedu.loginFunction("tranthihaiha660@gmail.com", "1234567");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test
    public void upadateSuccessfully() throws InterruptedException {
        loginSuccessfully();
        tedu.updatePassword("1234567", "1234567");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
    }
    @Test
    public void searchSuccessfully() throws InterruptedException {
        loginSuccessfully();
        tedu.search("ASP Net");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//a[text()='Bài 52: Gửi phản hồi và gửi mail trong" +
                " ASP NET sử dụng SMTP']")).isDisplayed());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
