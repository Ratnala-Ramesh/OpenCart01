package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);	
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccount;
	@FindBy(xpath="//a[normalize-space()='Logout'][@class='list-group-item']") WebElement logout;
	
	public boolean MyAccount() {
		try {
			return (MyAccount.isDisplayed());
		}
		catch(Exception e) {
			return (false);
		}
	}
	public void Logout() {
		logout.click();
	}

}