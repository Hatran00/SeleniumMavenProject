package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //1 page la 1 doi tuong can test
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Tim locator cua tung element tren page
    public void LoginFunction(String email, String password){
        WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys(email);
        }
        WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
        if (textPassword.isDisplayed()) {
            textPassword.sendKeys(password);
        }
        WebElement btnLogin = driver.findElement(By.xpath("(//button[text()='ĐĂNG NHẬP'])[3]"));
        if (btnLogin.isEnabled()) {
            btnLogin.click();
        }
    }
}
