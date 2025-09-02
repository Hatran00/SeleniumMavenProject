package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVN_Day16_Bai1 extends CommonBase {
    @BeforeMethod
    public void openFirefoxBrowser(){
        driver = initFirefoxDriver(CT_PageURL.crmstar_URL);
    }

    @Test (priority = 1)
    public void loginSuccessfully(){
        type(By.name("email"), "admin@gmail.com");
        type(By.name("password"), "12345678");
        click(By.xpath("//button[text()='Đăng nhập']"));
        WebElement loginSuccess = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        assertTrue(loginSuccess.isDisplayed());
    }

    @Test (priority = 2)
    public void themKLVSuccessfully(){
        loginSuccessfully();
        click(By.xpath("//a[contains(text(), 'Quản lý khu làm việc')]"));
        click(By.xpath("//button[text()='Thêm mới']"));
        type(By.name("work_areas_code"), "test01");
        type(By.name("name"), "test");
        click(By.xpath("//button[text()='Lưu']"));
        click(By.xpath("//button[text()='Thêm']"));
        assertTrue(isElementDisplay(By.xpath("//div[text()='Thêm mới khu vực làm việc thành công']")));
    }

    @Test (priority = 3)
    public void xoaKLVSuccessfully(){
        loginSuccessfully();
        click(By.xpath("//a[contains(text(), 'Quản lý khu làm việc')]"));
        type(By.name("query"), "test");
        click(By.xpath("//button[text()='Tìm kiếm']"));
        assertTrue(isElementDisplay(By.xpath("//td[text()='test']")));
        click(By.xpath("//a[contains(text(),'Xóa')]"));
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Bạn có thực sự muốn xóa khu vực này");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//div[text()='Xóa khu vực làm việc thành công']")));
    }

}
