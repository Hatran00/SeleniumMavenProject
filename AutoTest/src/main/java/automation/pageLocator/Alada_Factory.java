package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alada_Factory {
    private WebDriver driver;

    //Goi chu thich @findBy de lien ket giua webelement voi locator
    @FindBy(id= "txtLoginUsername") WebElement textEmail;
    @FindBy(id= "txtLoginPassword") WebElement textPassword;
    @FindBy(xpath= "(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnLogin;

    @FindBy(xpath= "//div[@class='avatar2']") WebElement imageAvatar;
    @FindBy(xpath= "//a[text()='Thoát']") WebElement btnlogout;

    @FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']") WebElement selectEdit;
    @FindBy(id= "txtpassword") WebElement currentPassword;
    @FindBy(id= "txtnewpass") WebElement newPassword;
    @FindBy(id= "txtrenewpass") WebElement reNewPassword;
    @FindBy(xpath= "//button[text()='Lưu mật khẩu mới']") WebElement btnSavePass;

    @FindBy(xpath= "//a[text()='Đăng Ký']") WebElement btnDangKi;
    @FindBy(id= "txtFirstname") WebElement txtName;
    @FindBy(id= "txtEmail") WebElement txtEmail;
    @FindBy(id= "txtCEmail") WebElement txtReEmail;
    @FindBy(id= "txtPassword") WebElement txtPassword;
    @FindBy(id= "txtCPassword") WebElement txtRePassword;
    @FindBy(id= "txtPhone") WebElement txtPhone;
    @FindBy(id= "chkRight") WebElement checkDieuKhoan;
    @FindBy(xpath= "(//button[text()='ĐĂNG KÝ'])[3]") WebElement btnRegister;

    public Alada_Factory(WebDriver driver) {
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
    public void editProfile(String currentPass, String newPass, String reNewPass){
        imageAvatar.click();
        selectEdit.click();
        currentPassword.sendKeys(currentPass);
        newPassword.sendKeys(newPass);
        reNewPassword.sendKeys(reNewPass);
        btnSavePass.click();
    }
    public void register(String ten, String email, String reEmail, String pass, String rePass, String phone){
        btnDangKi.click();
        txtName.sendKeys(ten);
        txtEmail.sendKeys(email);
        txtReEmail.sendKeys(reEmail);
        txtPassword.sendKeys(pass);
        txtRePassword.sendKeys(rePass);
        txtPhone.sendKeys(phone);
        if (checkDieuKhoan.isSelected() == false) {
            checkDieuKhoan.click();
        }
        btnRegister.click();
    }
}
