package base;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.IAssert;

import framework.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ControlActions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest extends ControlActions {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "/Users/pujakarmakar/Desktop/BrowserDrivers/chromedriver_mac64/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @BeforeMethod(alwaysRun = true)
    public void login() throws InterruptedException, JSONException, IOException, ParseException{
        Settings settings=new Settings();
        WebElement usernameelement = driver.findElement(By.xpath("//input[@name='username']"));
        usernameelement.sendKeys(settings.getUsername());
        WebElement passwordelemenet = driver.findElement(By.xpath("//input[@name='pw']"));
        passwordelemenet.sendKeys(settings.getPassword());
        driver.findElement(By.xpath("//input[@name='Login']")).click();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(15000));
        //Thread.sleep(30000);
    }

    @AfterMethod(alwaysRun = true)
    public void logout() throws InterruptedException{
        driver.findElement(By.xpath("//img[@title='User']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
        Thread.sleep(6000);
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() throws InterruptedException{
                driver.quit();
    }

    @Override
    public WebDriver getDriver(){
        return driver;
    }

  

  
    


    
}
