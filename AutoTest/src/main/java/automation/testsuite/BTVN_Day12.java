package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BTVN_Day12 extends CommonBase {
    //bai 1
    @Test
    public void countryDropdownlist() {
        driver = initChromeDriver(CT_PageURL.country_URL);
        WebElement dropCountry = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
        Select countrySelect = new Select(dropCountry);
        int size = countrySelect.getOptions().size();
        assertEquals(size,249);
        countrySelect.selectByValue("ATG");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText = countrySelect.getFirstSelectedOption().getText();
        assertEquals(actualText, "Antigua and Barbuda");
    }

    //bai 2
    @Test
    public void chosseUnder(){
        driver = initChromeDriver(CT_PageURL.auto_URL);
        scrollToElement(By.id("number"));
        WebElement radioUnder = driver.findElement(By.id("under_18"));
        boolean rdUnder = radioUnder.isSelected();
        //kiem tra gia tri mac dinh
        assertEquals(rdUnder, false);
        //click vao male
        if (radioUnder.isEnabled() == true) {
            radioUnder.click();
            System.out.println("Radio under 18 was clicked");
        }
    }

    @Test
    public void chosseOver(){
        driver = initChromeDriver(CT_PageURL.auto_URL);
        scrollToElement(By.id("number"));
        WebElement radioOver = driver.findElement(By.id("over_18"));
        boolean rdOver = radioOver.isSelected();
        //kiem tra gia tri mac dinh
        assertEquals(rdOver, false);
        //click vao male
        if (radioOver.isEnabled() == true) {
            radioOver.click();
            System.out.println("Radio over 18 was clicked");
        }
    }

    @Test
    public void chosseDiasble(){
        driver = initChromeDriver(CT_PageURL.auto_URL);
        scrollToElement(By.id("number"));
        WebElement radioDiasble = driver.findElement(By.id("radio-disabled"));
        boolean rdDiasble = radioDiasble.isSelected();
        assertEquals(rdDiasble, false);
        if (radioDiasble.isEnabled() == true) {
            System.out.println("Radio under 18 was clicked");
        } else{
            System.out.println("Radio is disable");
        }
    }
}
