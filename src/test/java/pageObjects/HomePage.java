package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
  

    private By tabs[] = {
    	    By.xpath("//a[@id='code-tab']"),
    	    By.xpath("//a[@id='issues-tab']"),
    	    By.xpath("//a[@id='pull-requests-tab']"),
    	    By.xpath("//a[@id='actions-tab']")
    	};
    private By repoLink = By.partialLinkText("effective");
    
   
    public HomePage(WebDriver driver) {
        this.driver = driver;
        
    }
		
    public void clickOnRepo() {
    	
        driver.findElement(repoLink).click();

    }

    	public void navigateToTab(By tabLocator) {
    	    driver.findElement(tabLocator).click();
    	}

    	public void navigateToAllTabs() {
    	    for (By tab : tabs) {
    	        navigateToTab(tab);
    	        
    	    }
    	}
    
    

     // URL validation
    public void validateURL() {
    	
    	Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/Harinam18/effective-invention");

    }
    
    
    // Tabs Validation
    public boolean isTabActive(String tabName) {
        try {
            driver.findElement(By.xpath("//span[text()='" + tabName + "']"));
            return true; // element found, tab is active
        } catch (NoSuchElementException e) {
            return false; // element not found, tab is not active
        }
    }
    
    public void validateAllTabsAreActive() {
        Assert.assertTrue(isTabActive("Code"), "Code is not active");
        Assert.assertTrue(isTabActive("Issues"), "Issues is not active");
        Assert.assertTrue(isTabActive("Pull requests"), "Pull requests is not active");
        Assert.assertTrue(isTabActive("Actions"), "Actions is not active");
    }

}

