package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.LoginPage;

public class TestBase {
	
    protected WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        
        driver = new ChromeDriver();
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
	
	
	
	
	
	
	
	
	


