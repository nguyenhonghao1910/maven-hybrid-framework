package com.bankguru.payment;

import commons.BaseTest;
import environmentConfig.Environment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Level_24_Multiple_Environment extends BaseTest {
    WebDriver driver;
    Environment env;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browsername) {
    	String environmentName = System.getProperty("ENV");
    	ConfigFactory.setProperty("env",environmentName);
    	env = ConfigFactory.create(Environment.class);
        driver = getBrowserDriverUrl(browsername,env.url());
        //System.out.println(env.url());
       
    }
    
    @Test
    public void User_01_Register_To_System() {     
    }

    @Test
    public void User_02_Login_To_AdminPage() {
        
    }


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}


}
