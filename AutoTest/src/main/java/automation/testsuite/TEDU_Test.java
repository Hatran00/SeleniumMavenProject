package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TEDU_Test extends CommonBase {
    TEDU_PageFactory tedu;
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.tedu_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test
    public void loginSuccessfully() throws InterruptedException {
        tedu.loginFunction("tranthihaiha660@gmail.com", "1234567");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test
    public void upadateSuccessfully() throws InterruptedException {
        loginSuccessfully();
        tedu.updatePassword("1234567", "1234567");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
    }
    @Test
    public void searchSuccessfully() throws InterruptedException {
        loginSuccessfully();
        tedu.search("Web API");
        Thread.sleep(5000);
        List<WebElement> titleSearchResult = driver.findElements(By.xpath("//div[@class='post-title']/h3/a"));
        List<WebElement> contentSearchResult = driver.findElements(By.xpath("//div[@class='post-title']/p"));
        System.out.println("actualTitle is: " + titleSearchResult.size());
        System.out.println("actualContent is: " + contentSearchResult.size());
        for (WebElement titleElement : titleSearchResult) {
            String actualTitle= titleElement.getText();
            if(!actualTitle.contains("Web API")){
                for (WebElement contentElement : contentSearchResult){
                    String actualContent= contentElement.getText();
                    System.out.println("actualContent is: " + actualContent);
                    assertTrue(actualContent.contains("Web API"));
                }
            } else {
                System.out.println("actualTitle is: " + actualTitle);
                assertTrue(actualTitle.contains("Web API"));
            }
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
