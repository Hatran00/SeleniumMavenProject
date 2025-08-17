package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_BTVN13 {
    private WebDriver driver;

    public LoginPage_BTVN13(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginFunction(String email, String password){
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys(email);
        }
        WebElement textPassword = driver.findElement(By.id("password"));
        if (textPassword.isDisplayed()) {
            textPassword.sendKeys(password);
        }
        WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        if (btnLogin.isEnabled()) {
            btnLogin.click();
        }
    }
    public void logout(){
        WebElement btnLogout1 = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[1]"));
        if (btnLogout1.isEnabled()) {
            btnLogout1.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Đăng xuất'])[2]")));

            WebElement btnLogout2 = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[2]"));
            if(btnLogout2.isEnabled()){
                btnLogout2.click();
            }
        }
    }

}
