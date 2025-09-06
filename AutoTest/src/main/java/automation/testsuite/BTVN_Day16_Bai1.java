package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.BTVN_Day16_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVN_Day16_Bai1 extends CommonBase {
    BTVN_Day16_Factory btvn16;
    @BeforeMethod
    public void openFirefoxBrowser(){
        driver = initFirefoxDriver(CT_PageURL.crmstar_URL);
        btvn16 = new BTVN_Day16_Factory(driver);
    }

    @Test (priority = 1)
    public void loginSuccessfully(){
        btvn16.loginFunction("admin@gmail.com", "12345678");
        WebElement loginSuccess = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        assertTrue(loginSuccess.isDisplayed());
    }

    @Test (priority = 2)
    public void themKLVSuccessfully(){
        loginSuccessfully();
        click(By.xpath("//a[contains(text(), 'Quản lý khu làm việc')]"));
        btvn16.AddFunction("test01", "test");
        click(By.xpath("//button[text()='Thêm']"));
        assertTrue(isElementDisplay(By.xpath("//div[text()='Thêm mới khu vực làm việc thành công']")));
        btvn16.search("test");
        assertTrue(isElementDisplay(By.xpath("//td[text()='test']")));
        closeDriver();
    }

    @Test (priority = 3)
    public void xoaKLVSuccessfully(){
        loginSuccessfully();
        click(By.xpath("//a[contains(text(), 'Quản lý khu làm việc')]"));
        btvn16.search("test");
        assertTrue(isElementDisplay(By.xpath("//td[text()='test']")));

        btvn16.xoa();
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Bạn có thực sự muốn xóa khu vực này");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//div[text()='Xóa khu vực làm việc thành công']")));

        btvn16.search("test");
        assertTrue(isElementDisplay(By.xpath("//h4[text()='Không tìm thấy kết quả']")));
        closeDriver();
    }
}
