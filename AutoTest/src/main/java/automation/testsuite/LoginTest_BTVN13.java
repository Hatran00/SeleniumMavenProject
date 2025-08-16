package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.LoginPage_BTVN13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.*;

public class LoginTest_BTVN13 extends CommonBase {
    @BeforeMethod
    public void openFirefoxBrowser(){
        driver = initFirefoxDriver(CT_PageURL.crmstar_URL);
    }

    //Case 1- Login thanh cong
    @Test
    public void loginSuccessfully(){
        LoginPage_BTVN13 login = new LoginPage_BTVN13(driver);
        login.LoginFunction("admin@gmail.com", "12345678");
        WebElement loginSuccess = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        assertTrue(loginSuccess.isDisplayed());
    }
    //Case 2- Login thất bại do sai email
    @Test
    public void loginFail_IncorrectEmail(){
        LoginPage_BTVN13 login = new LoginPage_BTVN13(driver);
        login.LoginFunction("tran@gmail.com", "12345678");
        WebElement textErrorEmail = driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']"));
        assertFalse(textErrorEmail.isDisplayed());
    }
    //Case 3- Login thất bại do sai password
    @Test
    public void loginFail_IncorrectPass(){
        LoginPage_BTVN13 login = new LoginPage_BTVN13(driver);
        login.LoginFunction("admin@gmail.com", "123456");
        WebElement textErrorPass = driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']"));
        assertFalse(textErrorPass.isDisplayed());
    }
    //Case 4- Login thất bại do sai cả mail và password.
    @Test
    public void loginFail_BlankEmailPass(){
        LoginPage_BTVN13 login = new LoginPage_BTVN13(driver);
        login.LoginFunction("", "");
        WebElement textError = driver.findElement(By.xpath("//span[text()='Không được để trống trường này']"));
        assertFalse(textError.isDisplayed());
    }
    //Case 5- Logout
    @Test
    public void logout(){
        LoginPage_BTVN13 test = new LoginPage_BTVN13(driver);
        test.LoginFunction("admin@gmail.com", "12345678");
        WebElement loginSuccess = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast")));
        loginSuccess.click();
        test.logout();
        String actual = driver.getCurrentUrl();
        assertEquals(actual, "http://test-system.crmstar.vn/");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
