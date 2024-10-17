package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TestNavigation extends TestBase {

    
    @Test
    public void testNavigationBetweenFeatures(){
    	
    	HomePage homePage = new HomePage(driver);
        
        homePage.clickOnRepo();
        
        homePage.navigateToAllTabs();
   
        homePage.validateURL();
        
        homePage.validateAllTabsAreActive();
       
    }

}

