package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RepositoryPage;

public class GithubRepoTest extends TestBase{
	

   @Test(priority=0)
    public void testCreatePublicRepository(){
	   
	   RepositoryPage repositoryPage = new RepositoryPage(driver);
	   
	    repositoryPage.clickOnNewbtn();
	   
        String repoName = "TestRepoPublic";
        repositoryPage.createRepository(repoName, true);    
   }

   
    @Test(priority=1)
    public void testCreatePrivateRepository(){
    	
    	RepositoryPage repositoryPage = new RepositoryPage(driver);
    	
        String repoName = "TestRepoPrivate8";
        repositoryPage.createRepository(repoName, false);
        
        Assert.assertEquals(repositoryPage.getRepositoryVisibility(), "private");
  
    }

}


