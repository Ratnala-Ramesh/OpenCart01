package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AccountRegistrationPage;
import Pageobjects.HomePage;
import testBase.BaseClasss;

public class Tc_01RegistrationPage extends BaseClasss{
    @Test(groups={"sanity","master"})
    public void test() {
    	try {
    HomePage page=new HomePage(driver);
    logger.info("home page is opened");
    page.myaccount();
    page.Register();
    logger.info("registration page is opened");
    AccountRegistrationPage rpage=new AccountRegistrationPage(driver);
    rpage.setFirstName(randomString());
    rpage.setLastName(randomString());
    rpage.setEmail(randomString()+"@gmail.com");
    rpage.setTelephone(randomnumeric());
    String password=randomalphanumeric();
    rpage.setPassword(password);
    rpage.setConfirmPassword(password);
    rpage.setPrivacyPolicy();
    rpage.clickContinue();
    String confmsg=rpage.getConfirmationMsg();
    if(confmsg.equals("Your Account Has Been Created!")) {
    	logger.info("test is passed");
    }
    else {
    	logger.info("test is failed");
    }
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	
    	}
    	catch(Exception e) {
    		Assert.fail();
    		logger.info("test is failed");
    	}
    	finally {
    		logger.info("test is executed");
    	}
    }
}
