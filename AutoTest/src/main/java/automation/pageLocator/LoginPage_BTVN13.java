package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            WebElement btnLogout2 = driver.findElement(By.xpath("(//button[text()='Đăng xuất'])[2]"));
            if(btnLogout2.isEnabled()){
                btnLogout2.click();
            }
        }
    }

}
