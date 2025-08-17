package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alada_LoginLogoutPage_Factory {
    private WebDriver driver;

    //Goi chu thich @findBy de lien ket giua webelement voi locator
    @FindBy(id= "txtLoginUsername") WebElement textEmail;
    @FindBy(id= "txtLoginPassword") WebElement textPassword;
    @FindBy(xpath= "(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnLogin;

    @FindBy(xpath= "//div[@class='avatar2']") WebElement imageAvatar;
    @FindBy(xpath= "//a[text()='Thoát']") WebElement btnlogout;

    public Alada_LoginLogoutPage_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void loginFunction(String email, String pass){
        textEmail.sendKeys(email);
        textPassword.sendKeys(pass);
        btnLogin.click();
    }
    public void logoutFunction(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
        imageAvatar.click();
        btnlogout.click();
    }
}
