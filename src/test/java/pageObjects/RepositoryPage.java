package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage {
    private WebDriver driver;  
      
    private By newRepobtn = By.partialLinkText("New");
    private By repoNameField = By.xpath("//input[@id=':r5:']");
    private By repoVisibilityPublic = By.xpath("//input[@id=':r9:']");
    private By repoVisibilityPrivate = By.xpath("//input[@id=':ra:']");
    private By createRepositoryButton = By.xpath("//span[text()='Create repository']"); 
    private By repoVisibility = By.xpath("(//input[@name='visibilityGroup'])[2]");

    
    
    public RepositoryPage(WebDriver driver) {
        this.driver = driver;
    
    }
    
    public void clickOnNewbtn() {
      driver.findElement(newRepobtn).click();
    }

    public void createRepository(String repoName, boolean isPublic){
    
        driver.findElement(repoNameField).sendKeys(repoName);
        
        if (isPublic) {
            driver.findElement(repoVisibilityPublic).click();
        } else {
            driver.findElement(repoVisibilityPrivate).click();
        }
        
       driver.findElement(createRepositoryButton).click();
          
    }


    public String getRepositoryVisibility() {

    	return driver.findElement(repoVisibility).getAttribute("value");
    }
}
