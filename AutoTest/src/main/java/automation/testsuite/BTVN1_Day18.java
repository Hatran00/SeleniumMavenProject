package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class BTVN1_Day18 extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(String browser){
        driver = setupDriver(browser);
        driver.get(CT_PageURL.dienMay_URL);
    }
    @Test
    public void chatZalo() {
        String mainWindow = driver.getWindowHandle();
        click(By.xpath("//img[@alt='Zalo']"));
        Set<String> listWindow = driver.getWindowHandles();
        for (String window : listWindow) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                String currentURL = driver.getCurrentUrl();
                assertEquals(currentURL, "https://zalo.me/0965880198");
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String currentURL = driver.getCurrentUrl();
        assertEquals(currentURL, "https://dienmaynhapkhaugiare.com.vn/");
    }
    @AfterMethod
    public void closeBrowser(){
        closeDriver();
    }
}
