package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_PageFactory {
    private WebDriver driver;

    public TEDU_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "UserName") WebElement textEmail;
    @FindBy(id = "Password") WebElement textPassword;
    @FindBy(xpath = "//button[text()='Đăng nhập']") WebElement btnDN;
    @FindBy(id = "onesignal-slidedown-allow-button") WebElement btnSub;
    @FindBy(id = "my_account") WebElement btnAcc;
    @FindBy(xpath = "//a[text()=' Đổi mật khẩu']") WebElement btnChange;
    @FindBy(id = "OldPassword") WebElement textOldPassword;
    @FindBy(id = "NewPassword") WebElement textNewPassword;
    @FindBy(id = "ConfirmNewPassword") WebElement textConfirmPassword;
    @FindBy(xpath="//input[@value='Cập nhật']") WebElement btnCapNhat;
    @FindBy(xpath = "//input[@placeholder='Tìm bất cứ thứ gì mà bạn muốn']") WebElement textSearch;
    @FindBy(xpath = "//i[@class='fa fa-search']") WebElement btnSearch;

    public void loginFunction(String email, String pass){
        textEmail.sendKeys(email);
        textPassword.sendKeys(pass);
        btnDN.click();
    }
    public void updatePassword(String oldPass, String newPass) throws InterruptedException {
        Thread.sleep(3000);
        btnSub.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('my_account').click();");
        js.executeScript("arguments[0].click();", btnChange);
        Thread.sleep(3000);
        textOldPassword.sendKeys(oldPass);
        textNewPassword.sendKeys(newPass);
        textConfirmPassword.sendKeys(newPass);
        btnCapNhat.click();
    }
    public void search(String timKiem) {
        textSearch.sendKeys(timKiem);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", btnSearch);
    }
}
