package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day16_Factory {
    private WebDriver driver;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password") WebElement txtPass;
    @FindBy(xpath = "//button[text()='Đăng nhập']") WebElement btnLogin;

    @FindBy(xpath = "//button[text()='Thêm mới']") WebElement btnThem;
    @FindBy(name = "work_areas_code") WebElement txtMa;
    @FindBy(name = "name") WebElement txtName;
    @FindBy(xpath = "//button[text()='Lưu']") WebElement btnLuu;

    @FindBy(xpath = "//input[@placeholder='Nhập từ khóa cần tìm kiếm']") WebElement txtSearch;
    @FindBy(xpath = "//button[text()='Tìm kiếm']") WebElement btnSearch;

    @FindBy(xpath = "//a[contains(text(),'Xóa')]") WebElement btnXoa;

    public BTVN_Day16_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass)
    {
        txtEmail.sendKeys(email);
        txtPass.sendKeys(pass);
        btnLogin.click();
    }

    public void AddFunction(String ma, String ten)
    {
        btnThem.click();
        txtMa.sendKeys(ma);
        txtName.sendKeys(ten);
        btnLuu.click();
    }

    public void search(String timKiem)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + timKiem +"';", txtSearch);
        js.executeScript("arguments[0].click();", btnSearch);
    }

    public void xoa()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnXoa);
    }

}
