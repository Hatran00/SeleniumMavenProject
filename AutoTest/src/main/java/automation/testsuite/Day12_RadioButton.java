package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Day12_RadioButton extends CommonBase {
    @Test
    public void chosseMale(){
        driver = initChromeDriver(CT_PageURL.demoQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        boolean rdMale = radioMale.isSelected();
        //kiem tra gia tri mac dinh
        assertEquals(rdMale, false);
        //click vao male
        if (radioMale.isEnabled() == true) {
            radioMale.click();
            System.out.println("Radio male was clicked");
        }
    }

    @Test
    public void chosseFemale(){
        driver = initChromeDriver(CT_PageURL.demoQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        boolean rdFemale = radioFemale.isSelected();
        //kiem tra gia tri mac dinh
        assertEquals(rdFemale, false);
        //click vao male
        if (radioFemale.isEnabled() == true) {
            radioFemale.click();
            System.out.println("Radio female was clicked");
        }
    }

    @Test
    public void chosseOther(){
        driver = initChromeDriver(CT_PageURL.demoQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        boolean rdOther = radioOther.isSelected();
        //kiem tra gia tri mac dinh
        assertEquals(rdOther, false);
        //click vao male
        if (radioOther.isEnabled() == true) {
            radioOther.click();
            System.out.println("Radio other was clicked");
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
