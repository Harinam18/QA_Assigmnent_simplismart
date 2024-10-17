package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class TestBase {
	
    protected WebDriver driver;
    private LoginPage loginPage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser){
          
        switch(browser.toLowerCase())
        {
        case "chrome"  : driver = new ChromeDriver(); break;
        case "firefox" : driver = new FirefoxDriver(); break;
        case "edge"  : driver = new EdgeDriver(); break;
        default : System.out.println("Invalid browser name..."); return;
        }

        driver.manage().window().maximize();
        
        driver.get("https://github.com/login");

        loginPage = new LoginPage(driver);
        
        loginPage.login("harinam18@gmail.com","Hari@5353");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  
    }
    
    
    @AfterClass
    public void tearDown(){
      driver.quit();
    		
    }
}
	
	
	
	
	
	
	
	
	


