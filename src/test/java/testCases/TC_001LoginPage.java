package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.HomePage;
import Pageobjects.LoginPage;
import Pageobjects.MyAccountPage;
import testBase.BaseClasss;
public class TC_001LoginPage extends BaseClasss {
	@Test(groups={"regression","master"})
	public void login() {
		logger.info("homepage started");
		HomePage hm=new HomePage(driver);
		hm.myaccount();
		hm.Login();
		logger.info("login page is started");
		LoginPage lp=new LoginPage(driver);
		lp.Email(p.getProperty("email"));
		lp.Password(p.getProperty("password"));
		lp.button();
		logger.info("my account page is started");
		MyAccountPage mp=new MyAccountPage(driver);
		boolean m=mp.MyAccount();
		if(m==true) {
			Assert.assertTrue(true);
			logger.info("test is passed");
		}
		else {
			logger.info("test is failed");
			Assert.assertTrue(false);
		}
		mp.Logout();
	}

}
