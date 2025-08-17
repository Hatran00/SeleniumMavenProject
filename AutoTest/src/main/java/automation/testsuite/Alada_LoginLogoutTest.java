package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.Alada_LoginLogoutPage_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Alada_LoginLogoutTest extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initFirefoxDriver(CT_PageURL.alada_URL);
    }
    @Test
    public void loginSuccessfully(){
        Alada_LoginLogoutPage_Factory login = new Alada_LoginLogoutPage_Factory(driver);
        login.loginFunction("tranthihaiha660@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void logoutSuccessfully(){
        loginSuccessfully();
        Alada_LoginLogoutPage_Factory logout = new Alada_LoginLogoutPage_Factory(driver);
        logout.logoutFunction();
        assertTrue(driver.findElement(By.xpath("//div[@class='login']")).isDisplayed());
    }

}
