package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class BTVN2_Day18 extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser){
        driver = setupDriver(browser);
        driver.get(CT_PageURL.bepAnToan_URL);
    }
    @Test
    public void chatZalo(){
        String mainWindow = driver.getWindowHandle();
        click(By.xpath("//a[contains(@class, 'space-x-0')][2]"));
        Set<String> listWindow = driver.getWindowHandles();
        for (String window : listWindow) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                String currentURL= driver.getCurrentUrl();
                assertEquals(currentURL, "https://zalo.me/0912331335");
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String currentURL= driver.getCurrentUrl();
        assertEquals(currentURL, "https://bepantoan.vn/");
    }
    @AfterMethod
    public void closeBrowser(){
        closeDriver();
    }
}
