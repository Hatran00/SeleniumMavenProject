package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
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
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Alada_Test extends CommonBase {
    static String baseEmail = "testBase";

    public static String generateRandomString(int length) {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            email.append(characterSet.charAt(index));
        }
        baseEmail = baseEmail+email.toString()+"@gmail.com";
        return baseEmail;
    }
    @BeforeMethod
    public void openBrowser(){
        driver = initFirefoxDriver(CT_PageURL.alada_URL);
    }
    @Test (priority = 2)
    public void loginSuccessfully(){
        Alada_Factory login = new Alada_Factory(driver);
        login.loginFunction(baseEmail, "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test (priority = 1)
    public void registerSuccessfully(){
        generateRandomString(4);
        Alada_Factory dangKi = new Alada_Factory(driver);
        dangKi.register("Ha",baseEmail,baseEmail, "123456", "123456",
                "0375968315");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement thongbao = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='thongbao']")));
        assertTrue(thongbao.isDisplayed());
    }

    @Test (priority = 3)
    public void editPasswordSuccessfully(){
        loginSuccessfully();
        Alada_Factory editInfor = new Alada_Factory(driver);
        editInfor.editProfile("123456", "123456", "123456");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Cập nhật mật khẩu mới thành công!");
        alert.accept();
    }

    @Test (priority = 4)
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
