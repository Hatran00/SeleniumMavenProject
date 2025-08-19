package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.Alada_Factory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Alada_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initFirefoxDriver(CT_PageURL.alada_URL);
    }
    @Test
    public void loginSuccessfully(){
        Alada_Factory login = new Alada_Factory(driver);
        login.loginFunction("h3test@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void registerSuccessfully(){
        Alada_Factory dangKi = new Alada_Factory(driver);
        dangKi.register("Ha","h3test@gmail.com","h3test@gmail.com", "123456", "123456",
                "0375968315");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement thongbao = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='thongbao']")));
        assertTrue(thongbao.isDisplayed());
    }

    @Test
    public void editPasswordSuccessfully(){
        loginSuccessfully();
        Alada_Factory editInfor = new Alada_Factory(driver);
        editInfor.editProfile("123456", "12345678", "12345678");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Cập nhật mật khẩu mới thành công!");
        alert.accept();
    }

    @Test
    public void logoutSuccessfully(){
        loginSuccessfully();
        Alada_Factory logout = new Alada_Factory(driver);
        logout.logoutFunction();
        assertTrue(driver.findElement(By.xpath("//div[@class='login']")).isDisplayed());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
