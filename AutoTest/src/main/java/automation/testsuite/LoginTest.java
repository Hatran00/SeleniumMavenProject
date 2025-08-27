package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeDriver(CT_PageURL.alada_URL);
    }

    //Case1: Login thanh cong
    @Test
    public void loginSuccessfully(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("tranthihaiha660@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }
    @Test
    public void loginFail_IncorrectEmail(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("tran", "123456");
        WebElement textErrorEmail = driver.findElement(By.id("txtLoginUsername-error"));
        assertTrue(textErrorEmail.isDisplayed());
    }
    @Test
    public void loginFail_IncorrectPass(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("tranthihaiha660@gmail.com", "12345678");
        WebElement textErrorPass = driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']"));
        assertTrue(textErrorPass.isDisplayed());
    }
    @Test
    public void loginFail_BlankEmailPass(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("", "");
        WebElement textErrorEmail = driver.findElement(By.id("txtLoginUsername-error"));
        WebElement textErrorPass = driver.findElement(By.id("txtLoginPassword-error"));
        assertTrue(textErrorEmail.isDisplayed() && textErrorPass.isDisplayed());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
