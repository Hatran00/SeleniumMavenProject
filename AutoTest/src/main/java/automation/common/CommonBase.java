package automation.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonBase {
    public static WebDriver driver;

    public WebDriver initChromeDriver(String Url){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver initFirefoxDriver(String Url){
        System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
//        FirefoxOptions options = new FirefoxOptions();
//        // Disable the “Insecure form submission” warning popup
//        options.addPreference("security.warn_submit_insecure", false);
//        // (Optional) disable insecure field warnings
//        options.addPreference("security.insecure_field_warning.contextual.enabled", false);
//        FirefoxDriver driver = new FirefoxDriver(options);
        driver = new FirefoxDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver initEdgeDriver(String Url){
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver(){
        System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        // Disable the “Insecure form submission” warning popup
        options.addPreference("security.warn_submit_insecure", false);
        // (Optional) disable insecure field warnings
        options.addPreference("security.insecure_field_warning.contextual.enabled", false);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }
    private WebDriver initEdgeDriver(){
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver setupDriver(String browserName){
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                System.out.println("Running with default chrome driver....");
                driver = initChromeDriver();
                break;
            case "firefox":
                System.out.println("Running with default firefox driver....");
                driver = initFirefoxDriver();
                break;
            case "edge":
                System.out.println("Running with default edge driver....");
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Invalid browser name, run with default chrome driver....");
                driver = initChromeDriver();
        }
        return driver;
    }
    public WebElement getElementPresentDOM(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public WebElement getElementPresentDOM(By locator) {
        return getElementPresentDOM(locator,5);
    }
    public WebElement getElementPresentDOM2(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElementPresentDOM(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //wrap phuong thuc display
    public boolean isElementDisplay(By locator){
        try {
            WebElement element = getElementPresentDOM(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException ex1) {
            return false;
        } catch (TimeoutException ex2) {
            return false;
        } catch (Exception ex) {
            return false;
        }

    }
    //wrap phuong thuc click
    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getElementPresentDOM(locator);
        element.click();
    }
    public void clickByJS(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].click();", element);
    }
    //wrap phuong thuc type
    public void type(By locator, String value){
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void closeDriver(){
        try{
        if (driver != null)
            driver.quit();
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }

}
