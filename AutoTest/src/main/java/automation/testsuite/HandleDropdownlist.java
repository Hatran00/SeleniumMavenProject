package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class HandleDropdownlist extends CommonBase {
    @Test
    public void handelDropdownlist(){
        driver = initChromeDriver(CT_PageURL.codeStar_URL);
        WebElement dropCatg = driver.findElement(By.id("product_categories_filter"));
        Select catgSelect = new Select(dropCatg);
        //kiem tra so luong option
        int size = catgSelect.getOptions().size();
        assertEquals(size,5);
        //Chon AWS option bang ham selectByVisibleText
        catgSelect.selectByVisibleText("AWS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText1 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText1, "AWS");
        //chon lap trinh web bang ham selectByValue
        catgSelect.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText2 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText2, "Lập trình web");
        //chon programming courses bang ham index
        catgSelect.selectByIndex(4);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText3 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText3, "Programming courses");

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
