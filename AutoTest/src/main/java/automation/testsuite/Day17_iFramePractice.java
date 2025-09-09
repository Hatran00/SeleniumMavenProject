package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day17_iFramePractice extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser){
        driver = setupDriver(browser);
        driver.get(CT_PageURL.codeStar_URL2);
    }

    @Test
    public void handleIFrame(){
        scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp" +
                " về AWS/Kiểm thử/Lập trình web']"));
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        type(By.id("email"), "0375968356");
        clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));
        assertTrue(isElementDisplay(By.id("email")));
    }
    @AfterMethod
    public void closeBrowser(){
        closeDriver();
    }
}
