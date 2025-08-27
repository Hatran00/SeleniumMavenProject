package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Day12_HandelCheckbox extends CommonBase {
    @Test
    public void chooseHobbies(){
        driver = initChromeDriver(CT_PageURL.demoQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement sportLable = driver.findElement(By.xpath("//label[text()='Sports']"));
        boolean isSportSelected = sportLable.isSelected();
        if (isSportSelected == false) {
            sportLable.click();
            System.out.println("Checkbox sport has been selected");
        }
        WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
        if (reading.isSelected() == false) {
            reading.click();
            System.out.println("Checkbox reading has been selected");
        }
        WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
        if (music.isSelected() == false) {
            music.click();
            System.out.println("Checkbox music has been selected");
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
